package aoc.test.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge1 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new File("expenses.txt"));
		ArrayList<Integer> listI = new ArrayList<Integer>();

		while (s.hasNextLine()) {
			listI.add(s.nextInt());
		}

		Integer[] values = listI.toArray(new Integer[listI.size()]);

		for(int a=0; a<values.length; a++){
			for(int b=0; b<values.length; b++){
				if(b==a){
					continue;
				}
				if(values[a].intValue() + values[b].intValue() == 2020){
					System.out.println("Part 1 Answer = " + values[a].intValue() * values[b].intValue());
				}
			}
		}

		for(int a=0; a<values.length; a++){
			for(int b=0; b<values.length; b++){
				for(int c=0; c<values.length;c++){
					if(a==b && b==c)
						continue;
					if(values[a].intValue() + values[b].intValue() + values[c].intValue() == 2020){
						System.out.println("Part 2 Answer = " + values[a].intValue() * values[b].intValue() * values[c].intValue());
					}

				}
			}
		}
	}
}