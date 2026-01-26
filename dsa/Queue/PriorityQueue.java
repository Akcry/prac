package Queue;

import java.util.Scanner;

class Queue {
    int data;
    int priority;
}

public class PriorityQueue {

    static Queue[] queue;
    static int top = 0;

    static void enqueue(int data, int priority){
        if (top == queue.length) {
            System.out.println("Priority Queue Overflow");
            return;
        }

        Queue newNode = new Queue();
        newNode.data = data;
        newNode.priority = priority;

        int i = top - 1;

        while (i >= 0 && queue[i].priority < priority) {
            queue[i + 1] = queue[i];
            i--;
        }

        queue[i + 1] = newNode;
        top++;

        System.out.println("Element inserted successfully");
    }

    static void dequeue() {
        if (top == 0) {
            System.out.println("Priority Queue Underflow");
            return;
        }

        System.out.println("Deleted element: " + queue[0].data + " with priority: " + queue[0].priority);

        for (int i = 0; i < top - 1; i++) {
            queue[i] = queue[i + 1];
        }

        top--;
    }

    static void display() {
        if (top == 0) {
            System.out.println("Priority Queue is empty");
            return;
        }

        System.out.println("Element  Priority");
        for (int i = 0; i < top; i++) {
            System.out.println(queue[i].data + "        " + queue[i].priority);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the Queue : ");
        int size = sc.nextInt();
        queue = new Queue[size];

        int choice;

        do {
            System.out.println("\n--- Priority Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int data = sc.nextInt();
                    System.out.print("Enter priority: ");
                    int priority = sc.nextInt();
                    enqueue(data, priority);
                    break;
                
                case 2: 
                    dequeue();
                    break;

                case 3: 
                    display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;
                    
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);

    }
}
