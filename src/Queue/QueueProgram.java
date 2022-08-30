package Queue;

import java.util.NoSuchElementException;

public class QueueProgram {
    private Node head;
    private Node tail;
    private int length;

    public QueueProgram(){
        head=null;
        tail=null;
        length=0;
    }

    //enqueue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
        }
        tail = newNode;
        length++;
    }

    //dequeue
    public void dequeue() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        head = head.getNext();
        length--;
        if(length == 0) {
            tail = null;
        }
    }


    //traverse
    public void traverse() {
        if(head == null) {
            return;
        }
        Node currentNode = head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null) {
            System.out.print("-->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    //Java main class
    public static void main(String[] args) {
        QueueProgram queue = new QueueProgram();

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
        System.out.print("Dequeue: ");
        queue.dequeue();
        queue.traverse();
        System.out.print("Dequeue: ");
        queue.dequeue();
        queue.traverse();
    }
}
