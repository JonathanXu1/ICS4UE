
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        FileInputStream in = null;
        FileOutputStream out = null;

        int[] charList = new int[256];
        String message = "";
        String binaryString = "";

        String infile = "Frankenstein.txt";
        String outfile = infile.toUpperCase();

        System.out.println("Loaded file");

        try {
            System.out.println("Creating tree");

            in = new FileInputStream(infile);
            out = new FileOutputStream("goodbye.MZIP");
            int c;

            while ((c = in.read()) != -1) {
                //System.out.print((char)c);
                message += (char)c;
                charList[c] += 1;
                //out.write(c);
            }

            //Print filename
            for(int i = 0; i < outfile.length(); i++){
                out.write((int)outfile.charAt(i));
            }
            out.write((int)'\r');
            out.write((int)'\n');

            //Printing tree
            BinaryTree tree = new BinaryTree(charList);
            String treeLined = tree.lineify();
            for(int i = 0; i < treeLined.length(); i++){
                char dataChar = treeLined.charAt(i);
                out.write((int)dataChar);
            }
            out.write((int)'\r');
            out.write((int)'\n');
            //System.out.println(treeLined);
            System.out.println("Printed tree");

            System.out.println("Encoding to binary");

            //Encoding
            for(int i = 0; i < message.length(); i++){
                binaryString += tree.encode(message.charAt(i));
            }

            //Output extra bits
            String extraBits = Integer.toString(8- binaryString.length() % 8);
            for(int i = 0; i < extraBits.length(); i++){
                out.write((int)extraBits.charAt(i));
            }
            out.write((int)'\r');
            out.write((int)'\n');

            //Output encoded data
            for(int i = 0; i < Integer.parseInt(extraBits); i++){
                binaryString += "0";
            }
            /*
            //Debugging
            for(int i = 0; i < binaryString.length(); i++){

                if(i%8 == 0){
                    out.write((int)'\n');
                }
                out.write((int)binaryString.charAt(i));

            }
            out.write((int)'\r');
            out.write((int)'\n');
            */
            System.out.println("Writing compressed data");

            for(int i = 0; i < binaryString.length(); i+= 8){
                // Convert binary to int
                int integerValue = 0;
                for(int j = 0; j < 8; j++){
                    if(binaryString.charAt(i + j) == '1'){
                        integerValue += Math.pow(2, 7-j);
                    }
                }
                out.write(integerValue);
            }

            System.out.println("Compression complete");

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
