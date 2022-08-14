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
    }
}
