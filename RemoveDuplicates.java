package week4.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String name="Sriram";
		Set<Character> sri=new LinkedHashSet<Character>();
		char[] char1=name.toCharArray();
		for (int i = 0; i < char1.length; i++) 
		{
			if(!sri.add(char1[i])) 
			{
				sri.remove(char1[i]);
			}
		}
			System.out.println("After Removed Duplicates:" +sri);
	}

}
