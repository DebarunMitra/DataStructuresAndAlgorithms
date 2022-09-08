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

        tree.insert(20);
        tree.insert(12);
        tree.insert(25);
        tree.insert(15);
        tree.insert(30);
        tree.insert(23);

        tree.printTree();
    }
}
