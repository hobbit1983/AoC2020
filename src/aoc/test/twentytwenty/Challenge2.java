package aoc.test.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Challenge2 {
    public String rule = new String();
    public String letter = new String();
    public String password = new String();

    public static void main(String[] args) {
        Challenge2 app = new Challenge2();

        Scanner s;
        try {
            s = new Scanner(new File("passwords"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        int count = 0;
		while (s.hasNextLine()) {
            app.parseEntry(s.nextLine());
            if(app.validateEntry2(app.getMin(), app.getMax(), app.getCharacter(), app.getPassword())){
                count++;
            }
        }
        System.out.println("Invalid passwords: " + count);
    }

    public int getMin(){
        return Integer.parseInt(rule.substring(0, rule.indexOf("-")));
    }

    public int getMax(){
        int a = rule.indexOf("-");
        return Integer.parseInt(rule.substring(a+1));
    }

    public char getCharacter(){
        return this.letter.toCharArray()[0];
    }

    public String getPassword(){
        return this.password;
    }

    public void parseEntry(String input){
        StringTokenizer st = new StringTokenizer(input, " ");
        rule = st.nextToken();
        letter = st.nextToken().substring(0, 1);
        password = st.nextToken();
    }

    public boolean validateEntry2(int pos1, int pos2, char token, String password){
        char[] input = password.toCharArray();
        
       return input[pos1-1] == token ^ input[pos2-1] == token;
    }

    public boolean validateEntry(int min, int max, char token, String password){
        char[] input = password.toCharArray();
        int count=0;
        for(int a=0; a<input.length; a++){
            if(input[a] == token)
                count++;
        }

        if(count < min)
            return false;
        
        if(count > max)
            return false;

        return true;
    }
    
}
