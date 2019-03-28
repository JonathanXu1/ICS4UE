public class ComparableNode<T extends Comparable<T>>{
    private T value = null;
    private ComparableNode next = null;

    ComparableNode(){
    }
    ComparableNode(T value){
        this.value = value;
    }

    ComparableNode<T> getNext(){
        return next;
    }

    void setNext(ComparableNode<T> next){
        this.next = next;
    }

    T getValue(){
        return this.value;
    }

    void setValue(T value){
        this.value = value;
    }
}
