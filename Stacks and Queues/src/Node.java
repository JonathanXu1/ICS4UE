public class Node<T>{
    private T value = null;
    private Node next = null;

    Node(){
    }
    Node(T value){
        this.value = value;
    }

    Node<T> getNext(){
        return next;
    }

    void setNext(Node<T> next){
        this.next = next;
    }

    T getValue(){
        return this.value;
    }

    void setValue(T value){
        this.value = value;
    }
}
