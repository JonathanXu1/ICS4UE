/*
NoOop
Jonathan Xu
Feb 5, 2019
Rearranges content in a file
 */

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

public class NoOop {

    static ArrayList<String> randomize(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<>();
        int randIndex;
        Random rand = new Random();
        while(!input.isEmpty()){
            randIndex = rand.nextInt(input.size());
            output.add(input.get(randIndex));
            input.remove(randIndex);
        }
        return output;
    }

    private static ArrayList<String> readFile() throws Exception{
        ArrayList<String> output = new ArrayList<>();
        String read;

        File inFile = new File("ClassList.txt");

        System.out.println("Reading file...");
        Scanner sc = new Scanner(inFile);
        while (sc.hasNextLine()){
            read = sc.nextLine();
            output.add(read);
            System.out.println(read);
        }
        sc.close();

        return output;
    }

    public static void main(String args[]) throws Exception{
        //Read file
        ArrayList<String> inList = readFile();
        ArrayList<String> outList;

        System.out.println("Writing file...");
        outList = randomize(inList);
        FileWriter fileWriter = new FileWriter("RandomizedClassList.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for(int i = 0; i < outList.size(); i++){
            printWriter.printf("%-8s", (i+1) + "/" + (char)(65 + i));
            printWriter.println(outList.get(i));
        }
        printWriter.close();

    }
}
