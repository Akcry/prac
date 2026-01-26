package sorting;

// Radix Sort is a non-comparative sorting algorithm that sorts numbers by processing individual digits

import java.util.Arrays;
import java.util.Scanner;

class RadixSort {

    public static void countSort(int[] arr, int n, int mod) {
        int[] temp = new int[n];
        // creating count array for storing number of time elerment repeated
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            count[(arr[i] / mod) % 10]++; 
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = (n - 1); i >= 0; i--) {
            // System.out.print(n);
            temp[--count[(arr[i] / mod) % 10]] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

    }

    public static int findMax(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void radixSort(int[] arr, int n) {
        // finding the maximum number in the array to apply condition on loop
        int max = findMax(arr, n);

        for (int i = 1; (max / i) > 0; i *= 10) {
            countSort(arr, n, i);

            // printing array after each iteration
            System.out.println("Array after Iteration Sorting....");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int[] arr = { 10, 225, 21, 388, 190, 234, 111 };
        System.out.print("Enter the number of element you want to enter: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the " + n + " elements in the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array before Sorting....");
        printArray(arr);
        radixSort(arr, n);

        sc.close();
    }
}
