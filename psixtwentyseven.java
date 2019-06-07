/**
 * Program to combine to ArrayLists by alternating between both p.6.27
 * @author Matt
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class psixtwentyseven {
	
	/*
	 * create lists, combine them, print them
	 */
	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		fillLists(list,list2);		
		
		System.out.println(list);
		System.out.println(list2);
		
		ArrayList<Integer> combine = merge(list,list2);		
		
		System.out.println(combine);
	}
	
	
	/*
	 * user input to fill the list
	 */
	public static void fillLists(ArrayList<Integer> a, ArrayList<Integer> b){
		
		Scanner in = new Scanner(System.in);		
		
		boolean over = false;
		
		System.out.println("Enter a list of numbers, type any letter to stop");
		
		while(over == false) {
			
			String input = "";
			
			input = in.next();
			
			if(!(Character.isDigit(input.charAt(0)))) {				
				break;				
			}
			
			int sub = Integer.parseInt(input);		
			
			a.add(sub);			
		}
		
		over = false;
		
		System.out.println("Enter another list of numbers, type any letter to stop");
		
		
		
		while(over == false) {
			
			String input = "";
			
			input = in.next();
			
			if(!(Character.isDigit(input.charAt(0)))) {				
				break;				
			}
			
			int sub = Integer.parseInt(input);		
			
			b.add(sub);			
		}
		
	}
	
	/*
	 * merges the lists
	 */
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
		
		ArrayList<Integer> combine = new ArrayList<Integer>();
		int maxSize = 0;
		
		if(a.size() >= b.size()) {
			maxSize = a.size();
		}
		else {
			maxSize = b.size();
		}
				
		for(int i = 0; i < maxSize; ++i) {
			
			if(i < a.size()) {
				combine.add(a.get(i));
			}
			if(i < b.size()) {
				combine.add(b.get(i));
			}
			
		}
		
		
		
		return combine;
		
	}
	
}


//Enter a list of numbers, type any letter to stop
//4 5 7 69 44 32 34 56 4 3 8 1 o
//Enter another list of numbers, type any letter to stop
//5 65 45 66 3 2 45 65 88 65 33 65 22 l
//[4, 5, 7, 69, 44, 32, 34, 56, 4, 3, 8, 1]
//[5, 65, 45, 66, 3, 2, 45, 65, 88, 65, 33, 65, 22]
//[4, 5, 5, 65, 7, 45, 69, 66, 44, 3, 32, 2, 34, 45, 56, 65, 4, 88, 3, 65, 8, 33, 1, 65, 22]
