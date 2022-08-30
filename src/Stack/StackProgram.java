package Stack;

public class StackProgram {

    private Node top;
    private Node bottom;
    private int length;

    public StackProgram(){
        top = null;
        bottom = null;
        length = 0;
    }

    //Push
    public void push(int value){
        top = new Node(value, top);

        if(length==0){
            bottom=top;
        }

        length++;
    }

    //pop

    //peek

    //traverse
    public void traverse(){
        if(top == null){
            return;
        }

        Node currentNode = top;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    //java main function
    public static void main(String[] args) {
        StackProgram stack = new StackProgram();
        stack.push(1);
        stack.traverse();
        stack.push(2);
        stack.traverse();
        stack.push(3);
        stack.traverse();
        stack.push(4);
        stack.traverse();
    }
}
