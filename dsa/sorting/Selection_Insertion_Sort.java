package sorting;

import java.util.*;

public class Selection_Insertion_Sort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;

            while (j >= 0 && arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }

            System.out.println("Array after " + i + " pass:");
            printArray(arr);
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;

            System.out.println("Array after " + (i + 1) + " pass:");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nChoose Sorting Algorithm:");
        System.out.println("1. Insertion Sort");
        System.out.println("2. Selection Sort");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.println("\nArray before sorting:");
        printArray(arr);

        switch (choice) {
            case 1:
                System.out.println("\nPerforming Insertion Sort...");
                insertionSort(arr);
                break;

            case 2:
                System.out.println("\nPerforming Selection Sort...");
                selectionSort(arr);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

        sc.close();
    }
}

