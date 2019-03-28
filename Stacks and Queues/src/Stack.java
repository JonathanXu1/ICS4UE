public class Stack<T> {

    private Node<T> top;
    Stack(){
        top = new Node<T>();
    }

    public void push(T value){
        Node<T> newNode = new Node<T>(value);
        newNode.setNext(top);
        top = newNode;
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }

        T value = top.getValue();
        top = top.getNext();
        return value;
    }

    public boolean isEmpty(){
        return top.getNext() == null;
    }

}
