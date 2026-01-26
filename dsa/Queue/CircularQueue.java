package Queue;

import java.util.*;

class CircularQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int count;

    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is Full. Cannot enqueue " + element);
            return;
        }
        queue[rear] = element;
        rear = (rear + 1) % size;
        count++;
        System.out.println("Enqueued: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % size;
        count--;
        System.out.println("Dequeued: " + element);
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        for (int c = 0; c < count; c++) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = sc.nextInt();
                    cq.enqueue(element);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    int frontElement = cq.peek();
                    if (frontElement != -1) {
                        System.out.println("Front Element: " + frontElement);
                    }
                    break;
                case 4:
                    cq.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Input. Try Again.");
            }
        }
    }
}
