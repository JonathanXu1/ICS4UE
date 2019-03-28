public class Queue<T> {

    private Node<T> head, tail;
    Queue(){
        head = new Node<T>();
    }

    public void enqueue(T value){
        Node<T> tempNode = head;
        while(tempNode.getNext() != null){
            tempNode = tempNode.getNext();
        }
        tail = new Node<T>(value);
        tempNode.setNext(tail);
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }

        T value = head.getNext().getValue();
        Node<T> newNext = head.getNext().getNext();
        head.setNext(newNext);
        return value;
    }

    public boolean isEmpty(){
        return head.getNext() == null;
    }

}
