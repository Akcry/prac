package sorting;

// Quick Sort is a divide-and-conquer sorting algorithm that picks a pivot element, partitions the array into two parts (smaller and larger than the pivot), and then sorts those parts recursively.

import java.util.Scanner;

class QuickSort {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low - 1;
        for (int i = low; i <= high; i++) {
            if (arr[i] <= pivot) {
                index++;

                // System.out.println("Value of j and index is " + i + " " + index);
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
        System.out.println("Array after  iteration : ");
        printArray(arr);
        // System.out.println("Value of index is " + index);
        return index;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            sort(arr, low, pivotIndex - 1);
            // System.out.println("After lef half..........." + high);
            sort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        System.out.print("Enter the elements of the array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // int[] arr = { 2, 4, 7, 3, 1, 5, 10 };
        System.out.println("The unsorted array is : ");
        printArray(arr);
        sort(arr, 0, arr.length - 1);

        sc.close();

    }
}