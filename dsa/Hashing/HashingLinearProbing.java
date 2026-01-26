package Hashing;

import java.util.Scanner;

public class HashingLinearProbing {

    static int[] table;
    static int size;
    static final int EMPTY = -1;


    static int divisionMethod(int key) {
        return key % size;
    }

    static int midSquareMethod(int key) {
        int square = key * key;
        return (square / 10) % size;
    }

    static int foldingMethod(int key) {
        int sum = 0;
        while (key > 0) {
            sum += key % 100;
            key /= 100;
        }
        return sum % size;
    }

    static int multiplicationMethod(int key) {
        double A = 0.618;
        return (int) (size * ((key * A) % 1));
    }


    static void insert(int key, int choice) {
        int index;

        switch (choice) {
            case 1:
                index = divisionMethod(key);
                break;
            case 2:
                index = midSquareMethod(key);
                break;
            case 3:
                index = foldingMethod(key);
                break;
            case 4:
                index = multiplicationMethod(key);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        int startIndex = index;
        while (table[index] != EMPTY) {
            index = (index + 1) % size;
            if (index == startIndex) {
                System.out.println("Hash table is full!");
                return;
            }
        }

        table[index] = key;
    }


    static void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            if (table[i] == EMPTY)
                System.out.println(i + " : empty");
            else
                System.out.println(i + " : " + table[i]);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter hash table size: ");
        size = sc.nextInt();

        table = new int[size];
        for (int i = 0; i < size; i++)
            table[i] = EMPTY;

        int choice, key;

        do {
            System.out.println("\n--- HASHING MENU ---");
            System.out.println("1. Division Method");
            System.out.println("2. Mid-Square Method");
            System.out.println("3. Folding Method");
            System.out.println("4. Multiplication Method");
            System.out.println("5. Display Hash Table");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                System.out.print("Enter key to insert: ");
                key = sc.nextInt();
                insert(key, choice);
            } else if (choice == 5) {
                display();
            }

        } while (choice != 6);

        sc.close();
    }
}

