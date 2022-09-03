package Queue.QueueUsingStack;

import Queue.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> firstStack = new Stack<>(),
                    secondStack = new Stack<>();

    public void enqueue(int value) {
        firstStack.push(value);
    }

    public int dequeue() {
        fillSecondStackUsingFirstStack();
        int popValue = secondStack.pop();
        fillFirstStackUsingSecondStack();

        return popValue;
    }


    public int peek() {
        fillSecondStackUsingFirstStack();
        int peekValue = secondStack.peek();
        fillFirstStackUsingSecondStack();

        return peekValue;
    }

    public void traverse() {
        if (firstStack.empty()) {
            return;
        }

        fillSecondStackUsingFirstStack();
        Object[] list = secondStack.toArray();
        for (Object obj : list) {
            System.out.print("-->" + obj);
        }
        System.out.println();
        fillFirstStackUsingSecondStack();
    }


    public void fillSecondStackUsingFirstStack(){
        while (!firstStack.isEmpty()){
            secondStack.push(firstStack.pop());
        }
    }

    public void fillFirstStackUsingSecondStack(){
        while (!secondStack.isEmpty()){
            firstStack.push(secondStack.pop());
        }
    }



    //Java main class
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        //Enqueue
        System.out.print("Enqueue: ");
        queue.enqueue(1);
        queue.traverse();
        System.out.print("Enqueue: ");
        queue.enqueue(2);
        queue.traverse();
        System.out.print("Enqueue: ");
        queue.enqueue(3);
        queue.traverse();

        //Dequeue
        System.out.println("Dequeue: "+queue.dequeue());
        queue.traverse();
        System.out.println("Dequeue: "+queue.dequeue());
        queue.traverse();
    }
}
