/*
Compression Assignment
Takes a file and compresses it with Huffman Encoding
Jonathan Xu
March 20, 2019
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] charList = new int[256];
    String message = "";
    String binaryString = "";

    // Takes user input for file name
    String infile = "hello.txt";
    String outfile = "goodbye.MZIP";
    Scanner reader = new Scanner(System.in);
    System.out.println("Please enter a file to encode:");
    boolean validFile = false;
    while (!validFile) {
      infile = reader.nextLine();
      // Replaces extension at the end of a file
      if (infile.lastIndexOf('.') == -1) {
        System.out.println("Please include file extension.");
      } else {
        outfile = infile.substring(0, infile.lastIndexOf('.')) + ".MZIP";
        validFile = true;
      }
    }
    reader.close();

    //Debugging for time taken
    long start = System.currentTimeMillis();

    System.out.println("Loading file");
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(infile));
    FileOutputStream out = new FileOutputStream(outfile);

    int c;

    while ((c = in.read()) != -1) {
      //System.out.print((char)c);
      message += (char) c;
      charList[c] += 1;
      //out.write(c);
    }

    //Print filename
    System.out.println("Printing filename");
    for (int i = 0; i < outfile.length(); i++) {
      out.write((int) outfile.charAt(i));
    }
    out.write((int) '\r');
    out.write((int) '\n');

    //Printing tree
    System.out.println("Creating tree");
    BinaryTree tree = new BinaryTree(charList);
    String treeLined = tree.lineify();
    for (int i = 0; i < treeLined.length(); i++) {
      char dataChar = treeLined.charAt(i);
      out.write((int) dataChar);
    }
    out.write((int) '\r');
    out.write((int) '\n');
    //System.out.println(treeLined);

    System.out.println("Encoding to binary");

    //Encoding
    for (int i = 0; i < message.length(); i++) {
      binaryString += tree.encode(message.charAt(i));
    }

    //Output extra bits
    String extraBits = Integer.toString(8 - binaryString.length() % 8);
    for (int i = 0; i < extraBits.length(); i++) {
      out.write((int) extraBits.charAt(i));
    }
    out.write((int) '\r');
    out.write((int) '\n');

    //Output encoded data
    for (int i = 0; i < Integer.parseInt(extraBits); i++) {
      binaryString += "0";
    }

    System.out.println("Writing compressed data");

    for (int i = 0; i < binaryString.length(); i += 8) {
      // Convert binary to int
      int integerValue = 0;
      for (int j = 0; j < 8; j++) {
        if (binaryString.charAt(i + j) == '1') {
          integerValue += Math.pow(2, 7 - j);
        }
      }
      out.write(integerValue);
    }

    System.out.println("Compression complete");
    //Debugging for timing
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("Time: " + timeElapsed);

    in.close();
    out.close();
  }
}
