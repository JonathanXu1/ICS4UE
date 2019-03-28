// Question: do we need to know the extend cust
// Why extend cust works like this
// Why need comparable if there's a priority value

public class PriorityQueue<T extends Comparable<T>> {
    private ComparableNode<T> head;

    public PriorityQueue(){
        head = new ComparableNode<T>();
    }

    public boolean isEmpty(){
        return head.getNext() == null;
    }

    public void enqueue(T value){
        ComparableNode<T> item = new ComparableNode<T>(value);
        if(head.getNext() == null){
            item.setNext(head.getNext());
            head.setNext(item);
            return;
        }
        ComparableNode<T> tempNode = head;
        while(tempNode.getNext() != null && value.compareTo(tempNode.getNext().getValue()) < 0){
            tempNode = tempNode.getNext();
        }
        item.setNext(tempNode.getNext());
        tempNode.setNext(item);
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }

        T output = head.getNext().getValue();
        ComparableNode<T> nextNode = head.getNext().getNext();
        head.setNext(nextNode);
        return output;
    }
}
