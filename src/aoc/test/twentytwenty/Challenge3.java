package aoc.test.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge3 {

    public final static char TREE = '#';
    public final static char space = '.';

    private final static String inputFile = "trees";

    public char[][] grid;

    public int width,length;

    public int numberOfTrees = 0;

    public int rightTravel = 0;
    public int downTravel = 0;

    public static void main(String[] args) {
        for(int counter=0; counter<100; counter ++){
            System.out.println(counter%10);
        }
        Challenge3 app = new Challenge3();

        long result = 1l;
        result = result * app.go(1,1);
        result = result * app.go(3,1);
        result = result * app.go(5,1);
        result = result * app.go(7,1);
        result = result * app.go(1,2);
        System.out.println(result);
    }

    public Challenge3(){
        Scanner s = getScanner(inputFile);
        length = 0;
        String currLine = new String();
        while(s.hasNextLine()){
            length++;
            currLine = s.nextLine();
        }
        width = currLine.length();
        grid = new char[length][width];

        s = getScanner(inputFile);
        int currLengthPosition = 0;
        while(s.hasNextLine()){
           char[] input =  s.next().toCharArray();
           for(int a = 0; a<input.length; a++){
               grid[currLengthPosition][a] = input[a];
           }
           currLengthPosition++;
        }
    }

    public int go(int right, int down){
        this.rightTravel = right;
        this.downTravel = down;
        this.travel();
        return this.numberOfTrees;
    }

    private Scanner getScanner(String file){
        Scanner s = null;
        try {
            s = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        return s;
    }

    public void travel(){
        int x = 0;
        int y = 0;

        this.numberOfTrees = 0;

        while(x < this.length){
            if(grid[x][y%width] == Challenge3.TREE){
                this.numberOfTrees++;
            }
            x = x + this.downTravel;
            y = y + this.rightTravel;
        }
    }
}
