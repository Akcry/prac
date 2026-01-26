package sorting;

import java.util.*;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int shiftCount = 0;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                shiftCount++;
                j--;
            }
            arr[j + 1] = key;

            System.out.println("Array after " + i + " pass:");
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("\nTotal number of shifts: " + shiftCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of the array: ");
        int n = sc.nextInt();

        System.out.println("Enter elements of the array:");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray before sorting:");
        System.out.println(Arrays.toString(arr) + "\n");

        insertionSort(arr);

        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}

