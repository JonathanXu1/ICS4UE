import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        BinarySortTree<Integer> treeBoi = new BinarySortTree<>();
        System.out.println("Enter 'esc' to stop inputting.");
        String name;

        boolean escape = false;
        while(!escape){
            System.out.print("Enter name: ");
            name = input.nextLine();
            if(name.equals("esc")){
                escape = true;
            } else {
                treeBoi.add(Integer.parseInt(name));
            }
        }

        System.out.println("Size: " + treeBoi.size());
        System.out.println();

        treeBoi.displayTree();
        System.out.println();

        System.out.println("Check for contains: ");
        System.out.println(treeBoi.contains(Integer.parseInt(input.nextLine())));


        System.out.print("Remove a boi: ");
        treeBoi.remove(Integer.parseInt(input.nextLine())); // Remove integer cust

    }
}

/*
For lazy testing:
10
5
20
2
9
17
30
16
esc
 */
