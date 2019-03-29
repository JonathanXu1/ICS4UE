public class QueueNode {
  private BinaryTreeNode value = null;
  private QueueNode next = null;

  QueueNode(){}
  QueueNode(BinaryTreeNode value){
    this.value = value;
  }

  public QueueNode getNext(){
    return this.next;
  }

  public void setNext(QueueNode next){
    this.next = next;
  }

  public BinaryTreeNode getValue(){
    return this.value;
  }

  public void setValue(BinaryTreeNode value){
    this.value = value;
  }
}
