package LinkedList.SingleLinkedListProgram;

public class SingleLinkedList {
    Node head; // Head contains a node
    static class Node { // Node Contains: [data | next-node-address]

        int data;
        Node next;

        // Constructor with node data-part value parameter
        // Default Node Type: [Some Value | null]
        Node(int value)
        {
            data = value;
            next = null;
        }
    }

    // Method to insert a new node
    public static SingleLinkedList insert(SingleLinkedList list, int data) {
        // Create a new node with given data
        Node newNode = new Node(data);

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = newNode;
        }else {
            // Else traverse till the last node and insert the new node there
            //Last node address value will be always null, its not pointing to any node.
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = newNode;
        }

        return list;
    }

    // Method to insert a new node
    public static SingleLinkedList insertByPosition(SingleLinkedList list, int value, int position) {
        // Create a new node with given data
        Node newNode = new Node(value);

        // If the Linked List is empty, then make the new node as head
        if (list.head == null) {
            list.head = newNode;
        }else {
            System.out.println("Insert:"+ value);
            Node currentNode = list.head, nextNode = null;
            int counter=1;

            while(currentNode != null && position>=counter){
                nextNode = currentNode.next;
                if(position == 1){
                    System.out.println("Replace Value:"+ currentNode.data);
                    newNode.next = currentNode;
                    list.head = newNode;
                    break;
                }else if(position-1==counter || position == 1){
                    System.out.println("Replace Value:"+ currentNode.data);
                    currentNode.next = newNode;
                    newNode.next = nextNode;
                    break;
                }
                currentNode = currentNode.next;
                counter++;
            }
        }

        return list;
    }

    // Method to remove an element from a single linked list
    public static SingleLinkedList remove(SingleLinkedList list, int value) {

        Node currentNode = list.head, nextNode = null;

        while(currentNode != null){
            System.out.println("Current Value:"+ currentNode.data);
            nextNode = currentNode.next;
            if(nextNode == null) {
                System.out.println("Key Not Found!");
                break;
            }else if(currentNode.data == value){
                System.out.println("Found Head:"+ currentNode.next);
                list.head = currentNode.next;
                return list;
            }else if(nextNode.data == value){
                System.out.println("Found Head:"+ nextNode.next);
                currentNode.next = nextNode.next;
                break;
            }
            currentNode = currentNode.next;
        }
        return list;
    }

    // Method to traverse a single linked list
    public static void traverse(SingleLinkedList list) {
        Node node = list.head;
        System.out.println("Single Linked List: ");

        //Loop till last node
        while(node != null){
            System.out.println("["+node.data+" | "+node.next+"]->");
            node = node.next;
        }
    }

    // Method to traverse a single linked list
    public static SingleLinkedList reverse(SingleLinkedList list) {
        Node firstNode = list.head,
             secondNode = firstNode.next;
        System.out.println("Reverse Single Linked List: ");

        //Loop till last node
        while(secondNode != null){
//            System.out.println("["+secondNode.data+" | "+secondNode.next+"]->");
            Node tempNode = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = tempNode;
        }

        list.head.next = null;
        list.head = firstNode;

        return list;
    }

    //Main method
    public static void main(String[] args)
    {
        //Create a empty list
        SingleLinkedList list = new SingleLinkedList();

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        traverse(list);

//        //remove an element
//        remove(list, 1);
//        // Print the LinkedList after one element removal
//        traverse(list);

        //insert by position start from 1
//        insertByPosition(list, 100, 1);
        // Print the LinkedList after one element insertion by position


        //reverse the linked list
        list = reverse(list);
        traverse(list);
    }
}
