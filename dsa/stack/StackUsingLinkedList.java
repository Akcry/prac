package stack;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {

    Node head;

    StackUsingLinkedList() {
        head = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("popped element is : " + head.data);

            head = head.next;
        }
    }

    public void display() {
        Node temp = head;
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack is as follows : ");
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Peek element is " + head.data);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StackUsingLinkedList stack = new StackUsingLinkedList();

        int choice;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Stack empty");
            System.out.println("5. Display Stack");
            System.out.println("6. Exit");

            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter element to push into the stack : ");
                    int data = sc.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    System.out.println(stack.isEmpty());
                    break;
                case 5:
                    stack.display();
                    break;
                default:
                    System.out.println("Exiting...");
                    break;
            }
        } while (choice < 6);

    }
}