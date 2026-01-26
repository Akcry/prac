package sorting;

// Shell Sort is an improved version of insertion sort that compares and sorts elements far apart first, or compares elements at a specific gap, then gradually reduces the gap between elements, making the list sorted more quickly.

import java.util.*;

public class ShellSort {

    public static void shellSort(int[] arr){
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap/=2) {
            for (int j = gap; j < n; j++) {
                for (int i = j-gap; i >= 0; i-=gap) {
                    if (arr[i+gap] < arr[i]) {
                        int temp = arr[i+gap];
                        arr[i+gap] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
            
            System.out.println("Array after Iteration: ");
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
        // int[] arr = {24, 54, 12, 52, 73, 6, 10, 23};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        System.out.print("Enter the elements of the array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array before Sorting....");
        printArray(arr);

        shellSort(arr);

        sc.close();
    }
}
