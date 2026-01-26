package Queue;

import java.util.Scanner;

public class DoubleEndedQueue {

    // Node class for linked list
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node front;
    private Node back;

    // Insert at front
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = back = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        System.out.println("Inserted " + data + " at front");
    }

    // Insert at back
    public void insertBack(int data) {
        Node newNode = new Node(data);
        if (back == null) {
            front = back = newNode;
        } else {
            back.next = newNode;
            newNode.prev = back;
            back = newNode;
        }
        System.out.println("Inserted " + data + " at back");
    }

    // Display the deque from front to back
    public void display() {
        if (front == null) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque elements: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleEndedQueue deque = new DoubleEndedQueue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert at front");
            System.out.println("2. Insert at back");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to insert at front: ");
                    int frontData = scanner.nextInt();
                    deque.insertFront(frontData);
                    break;
                case 2:
                    System.out.print("Enter element to insert at back: ");
                    int backData = scanner.nextInt();
                    deque.insertBack(backData);
                    break;
                case 3:
                    deque.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

