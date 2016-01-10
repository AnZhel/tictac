package tictac;

public class Computer extends Player{
	int turn;
	public Computer() {
		super();
		turn = 0;
		}

	@Override
	public void nextMove(Field field) {
		System.out.println("Computer turn:");
		turn++;
		//если ход первый или второй крестиками - просто заполняем центр или углы
		if (turn==1||(turn==2&&this.symbol==FieldState.CROSS)){
			if (field.getCellState((field.size*field.size)/2+(field.size*field.size)%2)==FieldState.BLANK)
			field.setCellState((field.size*field.size)/2+(field.size*field.size)%2, this.symbol);
			else if (field.getCellState(0, 0)==FieldState.BLANK) field.setCellState(0, 0, this.symbol);
			else if (field.getCellState(0, field.size-1)==FieldState.BLANK) field.setCellState(0, field.size-1, this.symbol);
			else if (field.getCellState(field.size-1, 0)==FieldState.BLANK) field.setCellState(field.size-1,0, this.symbol);
			else if (field.getCellState(field.size-1, field.size-1)==FieldState.BLANK) field.setCellState(field.size-1,field.size-1, this.symbol);
			field.showField();
			return;
		}
		else {
			//сначала пытаемся атаковать - найти в ряду два "своих" символа
			int[] place = getPlace(field, this.symbol);
			if (place[0]!=-1&&place[1]!=-1) field.setCellState(place[0], place[1], this.symbol);
			//если не получилось - пытаемся защититься - найти в ряду два "чужих" символа
			else {
				place = getPlace(field, FieldState.oppositeState(this.symbol));
				if (place[0]!=-1&&place[1]!=-1) field.setCellState(place[0], place[1], this.symbol);
				//если не получилось ищем два пустых
				else {
					place = getPlace(field, FieldState.BLANK);
					if (place[0]!=-1&&place[1]!=-1) field.setCellState(place[0], place[1], this.symbol);
				}
			}
			
		}	
			field.showField();
			return;
		}
	int[] getPlace(Field field, FieldState sign){
		int[][] result={{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int[] res={-1,-1};
		int sameV;
		int sameH;
		int sameD1 = 0;
		int sameD2 = 0;
		for (int i=0; i<field.size;i++){
			sameV = 0; result[0][0] = -1; result[0][1] = -1;
			sameH = 0; result[1][0] = -1; result[1][1] = -1;
			for (int j=0; j<field.size; j++){
				if(field.getCellState(i, j)==FieldState.BLANK){result[4][0]=i; result[4][1]=j;}
				if(field.getCellState(i, j)==sign) sameV++;
				if(field.getCellState(i, j)==FieldState.BLANK) {result[0][0]=i; result[0][1]=j;}
				if(field.getCellState(j, i)==sign) sameH++;
				if(field.getCellState(j, i)==FieldState.BLANK) {result[1][0]=j; result[1][1]=i;}
				if(i==j){
					if(field.getCellState(i, j)==sign) sameD1++;
					if(field.getCellState(i, j)==FieldState.BLANK) {result[2][0]=i; result[2][1]=j;}
				}
				if(i==(field.size-1)-j){
					if(field.getCellState(i, j)==sign) sameD2++;
					if(field.getCellState(i, j)==FieldState.BLANK) {result[3][0]=i; result[3][1]=j;}
				}
			}
			if(sameV==field.size-1&&result[0][0]!=-1&&result[0][1]!=-1){
				res[0]=result[0][0];
				res[1]=result[0][1];
				return res;
			}
			if(sameH==field.size-1&&result[1][0]!=-1&&result[1][1]!=-1){
				res[0]=result[1][0];
				res[1]=result[1][1];
				return res;
			}
		}
		if (sameD1==field.size-1&&result[2][0]!=-1&&result[2][1]!=-1) {res[0]=result[2][0]; res[1]=result[2][1];}
		else if (sameD2==field.size-1&&result[3][0]!=-1&&result[3][1]!=-1) {res[0]=result[3][0]; res[1]=result[3][1];}
		else if (sign==FieldState.BLANK) {res[0]=result[4][0]; res[1]=result[4][1];}
		return res;
	}	
	
	}
	

