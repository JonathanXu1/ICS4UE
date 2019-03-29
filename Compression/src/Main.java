/*
Compression Assignment
Takes a file and compresses it with Huffman Encoding
Jonathan Xu
March 20, 2019
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws IOException {
    int[] charList = new int[256];
    StringBuilder binaryString = new StringBuilder();

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

    //System.out.println("Loading file");
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(infile));
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outfile));

    int c;
    // Logging the frequencies of each character's occurence
    while ((c = in.read()) != -1) {
      charList[c] += 1;
    }
    in.close();

    //Print filename
    //System.out.println("Printing filename");
    infile = infile.toUpperCase();
    for (int i = 0; i < infile.length(); i++) {
      out.write((int) infile.charAt(i));
    }
    out.write((int) '\r');
    out.write((int) '\n');

    //Printing tree
    //System.out.println("Creating tree");
    BinaryTree tree = new BinaryTree(charList);
    String treeLined = tree.getLined();
    for (int i = 0; i < treeLined.length(); i++) {
      char dataChar = treeLined.charAt(i);
      out.write((int) dataChar);
    }
    out.write((int) '\r');
    out.write((int) '\n');

    //System.out.println("Encoding to binary");

    //Compressing
    in = new BufferedInputStream(new FileInputStream(infile));
    while ((c = in.read()) != -1) {
      binaryString.append(tree.compress(c));
    }
    in.close();

    //Output extra bits
    String extraBits = Integer.toString(8 - binaryString.length() % 8);
    for (int i = 0; i < extraBits.length(); i++) {
      out.write((int) extraBits.charAt(i));
    }
    out.write((int) '\r');
    out.write((int) '\n');

    //Output compressed data
    for (int i = 0; i < Integer.parseInt(extraBits); i++) {
      binaryString.append('0');
    }

    //System.out.println("Writing compressed data");

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

    //System.out.println("Compression complete");
    //Debugging for timing
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("Time: " + timeElapsed + "ms");

    in.close();
    out.close();
  }
}
