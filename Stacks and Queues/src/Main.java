import java.util.Random;

public class Main {
    public static void main (String[]args){
        /*
        Queue<Integer> queueBoi = new Queue<>();
        for(Integer i = 0; i < 10; i++){
            queueBoi.enqueue(i);
        }
        for(Integer i = 0; i < 10; i++){
            System.out.println(queueBoi.dequeue());
        }
        */
        q3();
        //q4("2 10 + 9 6 - /");

    }

    void q1(){
        /*
        Stack<Integer> stackBoi = new Stack();
        stackBoi.push(3);
        stackBoi.push(17);
        stackBoi.push(-1);
        stackBoi.push(12);
        stackBoi.push(10);
        stackBoi.push(2);

        stackBoi.push(4);
        stackBoi.pop();
        stackBoi.pop();
        stackBoi.push(2);
        stackBoi.push(-1);
        stackBoi.pop();
        stackBoi.pop();
        stackBoi.pop();

        while(!stackBoi.isEmpty()){
            System.out.println(stackBoi.pop());
        }
        */
    }

    static void q3(){
        Random rand = new Random();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int i = 0; i < 10; i ++){
            Integer boi = rand.nextInt(100);
            queue.enqueue(boi);
            System.out.println(boi);
        }
        System.out.println("Dequeueueueue");
        for(int i = 0; i < 10; i++){
            System.out.println(queue.dequeue());
        }
    }

    static void q4(String operation){
        Stack<Integer> stack = new Stack<Integer>();

        String[] steps = operation.split(" ");
        for(int i = 0; i < steps.length; i ++){
            if(steps[i].equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if(steps[i].equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if(steps[i].equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if(steps[i].equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(steps[i]));
            }
        }

        System.out.println(stack.pop());
    }
}
