/*
 * Program to sell seats for a theater p.6.24
 */
import java.util.Scanner;

public class psixtwentyfour {
	
	public static void buildTable(int[][] a) {
		
		//build rows index 0-2
		for(int i = 0; i < 10; ++i) {
			
			a[0][i] = 10;
			a[1][i] = 10;
			a[2][i] = 10;
		}
		
		//build rows index 3 and 4 and 5
		for(int i = 0; i < 10; ++i) {
			
			if(0 == i || 1 == i || 8 == i || 9 == i) {
				a[3][i] = 10;
				a[4][i] = 10;
				a[5][i] = 10;
			}
			else {
				a[3][i] = 20;
				a[4][i] = 20;
				a[5][i] = 20;
			}	
		}
		
		//build row index 6
		for(int i= 0; i < 10; ++i) {
			
			if(0 == i || 1 == i || 8 ==i || 9 ==i) {
				a[6][i] = 20;
			}
			else if(2 == i || 3 == i || 6 == i || 7 == i) {
				a[6][i] = 30;
			}
			else {
				a[6][i] = 40;
			}			
		}
		
		//build row index 7
		for(int i = 0; i < 10; ++i) {
			
			if(0 == i || 9 == i) {
				a[7][i] = 20;				
			}
			else if(1 == i || 2 == i || 7 == i || 8 == i) {
				a[7][i] = 30;
			}
			else if(3 == i || 6 == i) {
				a[7][i] = 40;
			}
			else {
				a[7][i] = 50;
			}
		}
		
		//build row index 8
		for(int i = 0; i < 10; ++i) {
			
			if(0 == i || 9 == i) {
				a[8][i] = 30;
			}
			else if(1 == i || 8 == i) {
				a[8][i] = 40;
			}
			else {
				a[8][i] = 50;
			}			
		}
	}
	
	public static void printTable(int[][] a) {
		
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 10; ++j) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println(" ");
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int ROWS = 9;
		int COLUMNS = 10;
		
		int[][] seats = new int[ROWS][COLUMNS];
		
		buildTable(seats);
		printTable(seats);
		
		boolean over = false;
		
		Scanner in = new Scanner(System.in);
		
		
		
		do {
			
			System.out.println("Pick either a seat or a price.");
			System.out.println("Seats has max 9 rows and 10 colums");
			System.out.println("Price options are $10, $20, $30, $40, $50");
			System.out.println("If choosing a seat, pick row first, then column");
			System.out.println("to Exit, enter 100");
			
			int input = in.nextInt();
			int input2 = 0;
			
			if(1 == input || 2 == input || 3 == input || 4 == input || 5 == input || 6 == input ||
					7 == input || 8 == input ||9 ==  input) {
				
				input2 = in.nextInt();
				
				if(1 == input2 || 2 == input2 || 3 == input2 || 4 == input2 || 5 == input2 || 6 == input2 ||
					7 == input2 || 8 == input2 ||9 ==  input2 || 10 == input2) {
					int row = input - 1;
					int column = input2 - 1;			
					if(0 != seats[row][column]) {
						seats[row][column] = 0;
						System.out.println("Congrats, you have chosen row " + (row + 1) + " and column " + (column + 1));
					}
					else {
						System.out.println("Sorry, that seat is already taken");
					}
				}
				else {
					System.out.println("Inproper input! Try again!");
				}	
				
			}
			else if(10 == input || 20 == input || 30 == input || 40 == input || 50 == input) {
				
				int price = input;
				
				boolean find = false;
				
				for(int i = 8; i >= 0; --i) {
					
					for(int j = 0; j < 10; ++j) {
						
						if(seats[i][j] == price) {
							seats[i][j] = 0;
							System.out.println("Congrats, you have chosen row " + (i + 1) + " and column " + (j + 1));
							find = true;
							j = 9;
							i = 0;
						}
						
					}
					
				}
				
				if(find == false) {
					System.out.println("No seats available for $" + price);
				}
				
				
			}
			else if(100 == input) {
				over = true;
				System.out.println("Goodbye");
			}
			else {
				System.out.println("Inproper input! Try again!");
			}			
			printTable(seats);
			
		} while(over == false);
		
		
	}
}


//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//20 20 30 30 40 40 30 30 20 20  
//20 30 30 40 50 50 40 30 30 20  
//30 40 50 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//50
//Congrats, you have chosen row 9 and column 3
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//20 20 30 30 40 40 30 30 20 20  
//20 30 30 40 50 50 40 30 30 20  
//30 40 0 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//40
//Congrats, you have chosen row 9 and column 2
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//20 20 30 30 40 40 30 30 20 20  
//20 30 30 40 50 50 40 30 30 20  
//30 0 0 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//20
//Congrats, you have chosen row 8 and column 1
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//10
//Congrats, you have chosen row 6 and column 1
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 10 20 20 20 20 20 20 10 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//10
//Congrats, you have chosen row 6 and column 2
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 10 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//10
//Congrats, you have chosen row 6 and column 9
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 50 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//50
//Congrats, you have chosen row 9 and column 4
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 0 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//1 5
//Congrats, you have chosen row 1 and column 5
//10 10 10 10 0 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 0 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//3 7
//Congrats, you have chosen row 3 and column 7
//10 10 10 10 0 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 0 10 10 10  
//10 10 20 20 20 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 0 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//4 5
//Congrats, you have chosen row 4 and column 5
//10 10 10 10 0 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 0 10 10 10  
//10 10 20 20 0 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//30 0 0 0 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//9 1
//Congrats, you have chosen row 9 and column 1
//10 10 10 10 0 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 0 10 10 10  
//10 10 20 20 0 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//0 0 0 0 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100
//9 4
//Sorry, that seat is already taken
//10 10 10 10 0 10 10 10 10 10  
//10 10 10 10 10 10 10 10 10 10  
//10 10 10 10 10 10 0 10 10 10  
//10 10 20 20 0 20 20 20 10 10  
//10 10 20 20 20 20 20 20 10 10  
//0 0 20 20 20 20 20 20 0 10  
//20 20 30 30 40 40 30 30 20 20  
//0 30 30 40 50 50 40 30 30 20  
//0 0 0 0 50 50 50 50 40 30  
//Pick either a seat or a price.
//Seats has max 9 rows and 10 colums
//Price options are $10, $20, $30, $40, $50
//If choosing a seat, pick row first, then column
//to Exit, enter 100

