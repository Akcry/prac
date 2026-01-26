package LinkedList;

import java.util.*;

public class SinglyLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted: " + data);
    }

    // Delete the first occurrence of a value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted: " + data);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Element not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted: " + data);
        }
    }

    // Search an element
    public void search(int key) {
        Node temp = head;
        int position = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Element " + key + " found at position " + position);
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Element not found.");
    }

    // Count number of nodes
    public void count() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Number of nodes in the list: " + count);
    }

    // Traverse and display
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Singly Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Search");
            System.out.println("5. Count");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = scanner.nextInt();
                    sll.insert(data);
                    break;

                case 2:
                    System.out.print("Enter data to delete: ");
                    int deleteData = scanner.nextInt();
                    sll.delete(deleteData);
                    break;

                case 3:
                    sll.display();
                    break;

                case 4:
                    System.out.print("Enter element to search: ");
                    int key = scanner.nextInt();
                    sll.search(key);
                    break;

                case 5:
                    sll.count();
                    break;

                case 6:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
