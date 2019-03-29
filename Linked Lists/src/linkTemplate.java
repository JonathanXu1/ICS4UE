//**********A template  for a simple linked list ********

class linkTemplate {
  public static void main(String[] args) {     //the main method

 
    SimpleLinkedList<String> myList = new SimpleLinkedList<String>();   //you can use your list similar to an ArrayList
    
    myList.add("Bob");
    
  }
}

// ********************** Simple Linked List class in the linked list *********
class SimpleLinkedList<E> { 
    private Node<E> head;
    
    
    public void add(E item) { 
      Node<E> tempNode = head;
      
      if (head==null) {
        head=new Node<E>(item,null);
        return;
      }
    
      while(tempNode.getNext()!=null) { 
        tempNode = tempNode.getNext();
      }
      
      tempNode.setNext(new Node<E>(item,null));
      return;
      
    }
    
    public E get(int index) {
      if(head == null){
        return null;
      }
      Node<E> tempNode = head;

      for(int i = 0; i < index; i++){
        tempNode = tempNode.getNext();
      }

      return tempNode.getItem();
    }

    public int indexOf(E item){
      Node<E> tempNode = head;
      int size =  size();
      for( int i = 0; i < size; i++){
        if(tempNode.getItem().equals(item)){
          return i;
        }
      }
      return -1;
    }
    /*
    public int indexOf(E item) {
      if(head == null){
        return -1;
      }

      Node<E> tempNode = head;
      boolean found = false;
      int index = -1;
      int output = -1;

      while(tempNode.getNext() != null && !found){
        tempNode = tempNode.getNext();
        index ++;
        if(tempNode.getItem().equals(item)){
          output = index;
          found = true;
        }
      }
      return output;
    }
    */
    public boolean remove(int index) {
      if(head == null){
        return false;
      }

      Node<E> tempNode = head;

      for(int i = 0; i < index; i++){
        tempNode = tempNode.getNext();
      }

      if(tempNode.getNext() != null){
        Node<E> afterNode = tempNode.getNext().getNext();

        tempNode.setNext(afterNode);
      } else {
        tempNode = null;
      }
      return true;
    }

    public boolean remove(E item) {
      Node<E> tempNode = head;
      boolean removed = false;

      while(tempNode.getNext() != null){
        if(tempNode.getNext().getItem().equals(item)){
          Node<E> afterNode = tempNode.getNext().getNext();
          tempNode.setNext(afterNode);
          removed = true;
        }
        tempNode = tempNode.getNext();
      }
      return removed;
    }


    public void clear() {
      head = null;
    }
    
    public int size() {
      Node<E> tempNode = head;
      int size = 0;

      while(tempNode != null){
        size ++;
        tempNode = tempNode.getNext();
      }
      return size;
    }

}



// ********************** A Node in the linked list *********
class Node<T> { 
  private T item;
  private Node<T> next;

public Node(T item) {
  this.item=item;
  this.next=null;
}

public Node(T item, Node<T> next) {
  this.item=item;
  this.next=next;
}

public Node<T> getNext(){
  return this.next;
}

public void setNext(Node<T> next){
  this.next = next;
}

public T getItem(){
  return this.item;
}

}