package stack;

import java.util.*;

class StackUsingArray {

    static int top = -1;

    public static boolean isEmpty() {
        return top == -1;
    }

    public static boolean isFull(int size) {
        return top == size - 1;
    }

    public static void push(int[] arr, int size) {
        if (isFull(size)) {
            System.out.println("You cannot enter element, Stack is full");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter element to be insert : ");
            int elem = sc.nextInt();
            arr[++top] = elem;
            System.out.println("Element inserted Successfully");
        }
    }

    // Display The Stack
    public static void displayStack(int[] arr) {
        if (isEmpty()) {
            System.out.println("Stack is Empty please enter some value");
        } else {
            System.out.println("Elements of array is");
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    // Pop elemnt from stack
    public static void pop(int[] arr) {
        if (isEmpty()) {
            System.out.println("Cannot pop as Stack is Empty please enter some value");
        } else {
            top--;
        }
    }

    // finding peek element
    public static void peek(int[] arr) {
        if (isEmpty()) {
            System.out.println("Cannot show peek element as Stack is Empty please enter some value");
        } else {
            System.out.println("Top Element of the stack is " + arr[top]);
        }
    }

    // finding if stack is full or not
    public static void isStackFull(int size) {
        if (isFull(size)) {
            System.out.println("Stack is full you can not enter elments");
        } else {
            System.out.println("Stack is not full you can enter elments");
        }
    }

    public static void isStackEmpty() {
        if (!isEmpty()) {
            System.out.println("Stack is Empty you can insert values ");
        } else {
            System.out.println("Stack is not full");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of the stack : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        int action;

        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Stack full");
            System.out.println("5. Stack empty");
            System.out.println("6. Display Stack");
            System.out.println("7. Display Top value");
            System.out.println("8. Exit");
            System.out.println("Enter number of operation you want to perform");

            action = sc.nextInt();

            switch (action) {
                case 1:
                    push(arr, size);
                    break;
                case 2:
                    pop(arr);
                    break;
                case 3:
                    peek(arr);
                    break;
                case 4:
                    isStackFull(size);
                    break;
                case 5:
                    isStackEmpty();
                    break;
                case 6:
                    displayStack(arr);
                    break;
                case 7:
                    System.out.println("The value of top is " + top);
                    break;
                case 8:
                    System.out.println("Exiting from Application");
                    break;
            }
        } while (action < 8 || action == 0);

        sc.close();
    }

}
