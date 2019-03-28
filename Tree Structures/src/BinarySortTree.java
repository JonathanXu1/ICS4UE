public class BinarySortTree<E extends Comparable> {
    private BinaryTreeNode<E> root;
    BinarySortTree(){
        root = new BinaryTreeNode<E>();
    }

    boolean contains(E value){
        BinaryTreeNode tempNode = root;
        Boolean found = false;
        while(!found){
            if(tempNode == null || tempNode.isLeaf()){
                return false;
            }
            if(tempNode.getLeft() != null && value.compareTo(tempNode.getItem()) < 0){
                tempNode = tempNode.getLeft();
            } else {
                tempNode = tempNode.getRight();
            }
            if(tempNode.getItem().compareTo(value) == 0){
                found = true;
            }
        }
        return true;
    }
    int size(){
        if(isEmpty()){
            return 0;
        }
        return recursiveSize(root);
    }
    private int recursiveSize(BinaryTreeNode node){
        int size = 1;
        if(node.isLeaf()){
            return size;
        }
        if(node.getLeft() != null){
            size += recursiveSize(node.getLeft());
        }
        if(node.getRight() != null){
            size += recursiveSize(node.getRight());
        }
        return size;
    }
    void add(E value){
        BinaryTreeNode<E> toAdd = new BinaryTreeNode<E>(value);
        if(isEmpty()){
            root.setRight(toAdd);
            return;
        }

        BinaryTreeNode tempNode = root.getRight();
        boolean placed = false;
        while(!placed){
            if(value.compareTo(tempNode.getItem()) < 0){
                if(tempNode.getLeft() != null){
                    tempNode = tempNode.getLeft();
                } else {
                    tempNode.setLeft(toAdd);
                    placed = true;
                }
            } else { // Assuming no values equal a node
                if(tempNode.getRight() != null){
                    tempNode = tempNode.getRight();
                } else {
                    tempNode.setRight(toAdd);
                    placed = true;
                }

            }
        }

    }
    boolean remove(E value){
        if(isEmpty()){
            return false;
        }

        boolean removed = false;
        BinaryTreeNode tempNode = root.getRight();
        BinaryTreeNode parentNode = root;
        boolean removeRight = false; //false for left, true for right
        while(!removed){
            if(tempNode == null){
                return false;
            }

            if(value.compareTo(tempNode.getItem()) < 0){
                parentNode = tempNode;
                tempNode = tempNode.getLeft();
                removeRight = false;
            } else if(value.compareTo(tempNode.getItem()) > 0){
                parentNode = tempNode;
                tempNode = tempNode.getRight();
                removeRight = true;
            } else {
                if(tempNode.isLeaf()){
                    if(removeRight){
                        parentNode.setRight(null);
                    } else {
                        parentNode.setLeft(null);
                    }
                } else if(tempNode.getLeft() != null && tempNode.getRight() == null){
                    if(removeRight){
                        parentNode.setRight(tempNode.getLeft());
                    } else {
                        parentNode.setLeft(tempNode.getLeft());
                    }
                }
                else{
                    BinaryTreeNode subTreeRoot = parentNode;
                    tempNode = tempNode.getRight();
                    //Find smallest node on the right side and replaces it
                    while(tempNode.getLeft() != null){
                        parentNode = tempNode;
                        tempNode = tempNode.getLeft();
                    }
                    if(removeRight){
                        tempNode.setLeft(subTreeRoot.getRight().getLeft());
                        parentNode.setLeft(null);
                        tempNode.setRight(subTreeRoot.getRight().getRight());
                        subTreeRoot.setRight(tempNode);
                    } else {
                        tempNode.setLeft(subTreeRoot.getLeft().getLeft());
                        parentNode.setLeft(null);
                        tempNode.setRight(subTreeRoot.getLeft().getRight());
                        subTreeRoot.setLeft(tempNode);
                    }
                }

                removed = true;
            }
        }
        return true;
    }
    private Boolean isEmpty(){
        return root.isLeaf();
    }

    public void displayTree(BinaryTreeNode point){
        if(point == null){
            return;
        }
        // Display children & content
        System.out.print(point.getItem());

        if(point.getLeft() != null){
            System.out.print(" Left: " + point.getLeft().getItem());
        }
        if(point.getRight() != null){
            System.out.print(" Right: " + point.getRight().getItem());
        }

        System.out.println();
        displayTree(point.getLeft());
        displayTree(point.getRight());
    }

    public void displayTree(){
        displayTree(root);
    }
}
