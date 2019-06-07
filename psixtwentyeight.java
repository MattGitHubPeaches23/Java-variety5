/**
 * Program to combine two ArrayLists in increasing order p.6.28
 * @author Matt
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class psixtwentyeight {
	
	/*
	 * fill lists, sort lists, merge lists
	 */
	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		fillLists(list,list2);		
		
		System.out.println(list);
		System.out.println(list2);
		
		Collections.sort(list);
		Collections.sort(list2);
		
		System.out.println(list);
		System.out.println(list2);
		
		ArrayList<Integer> combine = merge(list,list2);		
		
		System.out.println(combine);		
		
	}
	
	/*
	 * fill lists
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
	 * merge the lists together
	 */
	public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
	
		ArrayList<Integer> combine = new ArrayList<Integer>();
		
		int totalSize = a.size() + b.size();
		int aIndex = 0;
		int bIndex = 0;
		boolean aOver = false;
		boolean bOver = false;
		
		for(int i = 0; i < totalSize; ++i) {
			
			if(aOver == false && bOver == false) {
				
				if(a.get(aIndex) <= b.get(bIndex)) {
					
					combine.add(a.get(aIndex));
					aIndex += 1;
				}
				else if(b.get(bIndex) < a.get(aIndex)) {
					
					combine.add(b.get(bIndex));
					bIndex += 1;
				}
				
			}
			
			else {
				if(aOver == false) {
					
					combine.add(a.get(aIndex));
					aIndex += 1;
					
				}
				else {
					
					combine.add(b.get(bIndex));
					bIndex += 1;
					
				}
			}
			
			if(aIndex == a.size()) {
				aOver = true;
			}
			else if(bIndex == b.size()) {
				bOver = true;
			}
			
		}		
		
		
		return combine;
	
	}

}

//Enter a list of numbers, type any letter to stop
//4 5 5 89 3 44 22 11 7 6 99 33 k
//Enter another list of numbers, type any letter to stop
//44 55 66 22 33 11 7 5 0 11 38 84 33 n
//[4, 5, 5, 89, 3, 44, 22, 11, 7, 6, 99, 33]
//[44, 55, 66, 22, 33, 11, 7, 5, 0, 11, 38, 84, 33]
//[3, 4, 5, 5, 6, 7, 11, 22, 33, 44, 89, 99]
//[0, 5, 7, 11, 11, 22, 33, 33, 38, 44, 55, 66, 84]
//[0, 3, 4, 5, 5, 5, 6, 7, 7, 11, 11, 11, 22, 22, 33, 33, 33, 38, 44, 44, 55, 66, 84, 89, 99]

