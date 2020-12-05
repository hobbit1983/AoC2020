package aoc.test.twentytwenty;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Challenge5 {

    public static int getSeatID(String code){
        char[] rowData = code.substring(0, 7).toCharArray();
        char[] columnData = code.substring(7).toCharArray();
        int frontRow = 0;
        int backRow = 128;
        for(int a=0; a<rowData.length; a++){
            int difference = (backRow - frontRow)/2;
            if(rowData[a] == 'F'){
                backRow -= difference;
            }else{
                frontRow += difference;
            }

        }
        int row = frontRow;

        int leftColumn = 0;
        int rightColum = 8;
        for(int a=0; a<columnData.length; a++){
            int difference = (rightColum - leftColumn)/2;
            if(columnData[a] == 'L'){
                rightColum -= difference;
            }else{
                leftColumn += difference;
            }

        }

        int column = leftColumn;

        return (row*8) + column;
    }

    public static void main(String [] args){
        Scanner s;
        try {
            s = new Scanner(new File("boardingPasses"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
        int highestSeat = 0;
		while (s.hasNextLine()) {
            int seat = Challenge5.getSeatID(s.nextLine());
            if(seat > highestSeat)
                highestSeat = seat;
        }

        System.out.println(highestSeat);
    }

    
}
