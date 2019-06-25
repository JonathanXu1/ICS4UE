/*
Compression Assignment
Takes a file and compresses it with Huffman Encoding
@author Jonathan Xu
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
    // Declaring an array of ints to store occurences of each character
    int[] charList = new int[256];
    // A string to store the binary output of the tree
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

    // Loading file
    BufferedInputStream in = new BufferedInputStream(new FileInputStream(infile));
    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outfile));

    int c;
    // Logging the frequencies of each character's occurence
    while ((c = in.read()) != -1) {
      charList[c] += 1;
    }
    in.close();

    //Print filename
    infile = infile.toUpperCase();
    for (int i = 0; i < infile.length(); i++) {
      out.write((int) infile.charAt(i));
    }
    out.write((int) '\r');
    out.write((int) '\n');

    //Creating tree
    BinaryTree tree = new BinaryTree(charList);
    String treeLined = tree.getLined();
    for (int i = 0; i < treeLined.length(); i++) {
      char dataChar = treeLined.charAt(i);
      out.write((int) dataChar);
    }
    out.write((int) '\r');
    out.write((int) '\n');

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

    // Convert binary to int
    for (int i = 0; i < binaryString.length(); i += 8) {
      out.write(Integer.parseInt(binaryString.substring(i, i+8), 2));
    }

    //Debugging for timing
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;
    System.out.println("Time: " + timeElapsed + "ms");

    in.close();
    out.close();
  }
}
