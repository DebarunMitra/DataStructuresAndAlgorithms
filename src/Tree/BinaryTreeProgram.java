package Tree;

public class BinaryTreeProgram {

    private BinaryTreeNode root;

    public BinaryTreeProgram() {
        root = null;
    }

    public void insert(int value){
        if(root==null){
            root = new BinaryTreeNode(value);
            return;
        }

        BinaryTreeNode currentNode = root;
        while(true){
            if(currentNode.getValue() > value){
                if(currentNode.getLeft() == null){
                    currentNode.setLeft(new BinaryTreeNode(value));
                    return;
                }
                currentNode = currentNode.getLeft();
            }else{
                if(currentNode.getRight() == null){
                    currentNode.setRight(new BinaryTreeNode(value));
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    public void remove(int value) {
        if(root==null){
            return;
        }

        BinaryTreeNode removingNode = root,
                        parentNode = null;

        //Find the parent node
        while (removingNode.getValue() != value){
            parentNode = removingNode;
            if(removingNode.getValue() > value){
                removingNode = removingNode.getLeft();
            }else if(removingNode.getValue() < value){
                removingNode = removingNode.getRight();
            }
        }

        BinaryTreeNode replacementNode = null;
        if(removingNode.getRight() != null){
            replacementNode = removingNode.getRight();
            if(replacementNode.getLeft() == null){
                replacementNode.setLeft(removingNode.getLeft());
            }else{
                BinaryTreeNode replacementParentNode = removingNode;
                while(replacementNode.getLeft() != null){
                    replacementParentNode = replacementNode;
                    replacementNode = removingNode.getLeft();
                }

                replacementParentNode.setLeft(null);
                replacementNode.setLeft(removingNode.getLeft());
                replacementNode.setRight(removingNode.getRight());
            }
        } else if (removingNode.getLeft() != null) {
            replacementNode = removingNode.getLeft();
        }

        if(parentNode == null) {
            root = replacementNode;
        } else if(parentNode.getLeft() == removingNode) { //We are a left child
            parentNode.setLeft(replacementNode);
        } else { //We are a right child
            parentNode.setRight(replacementNode);
        }
    }

    int count = 0;
    public void printTree() {
        count = 0;
        printTree(root);
    }
    private void printTree(BinaryTreeNode node) {
        System.out.print(node.getValue());
        System.out.println();
        count++;
        if(node.getLeft() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) + "Left: ");
            printTree(node.getLeft());
        }
        if(node.getRight() != null) {
            System.out.print("\t".repeat(Math.max(0, count)) +"Right: ");
            printTree(node.getRight());
        }
        count--;
    }

    public static void main(String args[]){
        BinaryTreeProgram tree = new BinaryTreeProgram();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);

        tree.printTree();
//        tree.remove(15);
//        tree.printTree();
    }
}
