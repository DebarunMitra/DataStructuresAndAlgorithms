package Stack;

import java.util.EmptyStackException;

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
    public int pop(){
        if(length==0){
            throw new EmptyStackException();
        }

        Node stackTopNode = top;
        top = top.getNext();
        length--;
        if(length==0){
            bottom=null;
        }

        return stackTopNode.getValue();
    }

    //peek
    public int peek() {
        if(length == 0) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

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

        //stack push
        System.out.print("push: ");
        stack.push(1);
        stack.traverse();
        System.out.print("push: ");
        stack.push(2);
        stack.traverse();
        System.out.print("push: ");
        stack.push(3);
        stack.traverse();
        System.out.print("push: ");
        stack.push(4);
        stack.traverse();

        //stack pop
        System.out.print("pop: ");
        stack.pop();
        stack.traverse();

        //stack pop
        System.out.println("peek: "+ stack.peek());
        stack.traverse();
    }
}
