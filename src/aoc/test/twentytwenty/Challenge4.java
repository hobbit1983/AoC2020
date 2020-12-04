package aoc.test.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge4 {

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new File("passports"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Passport> passports = new ArrayList<Passport>();
        ArrayList<String> input = new ArrayList<String>();
        while(s.hasNextLine()){
            String line = s.nextLine();
            if(line.isBlank()){
                passports.add(new Passport(input));
                input = new ArrayList<String>();
            }else{
                input.add(line);
            }
        }
        if(!input.isEmpty()){
            passports.add(new Passport(input));
        }
        int count = 0;
        for(Passport p : passports){
            if(p.isValid())
                count ++;
        }
        System.out.println(count);
    }
    
}
