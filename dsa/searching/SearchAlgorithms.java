package searching;


import java.util.*;

public class SearchAlgorithms {

    // Linear Search Method
    public static void linearSearch(int[] arr, int val) {
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                System.out.println("Linear Search: Element found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear Search: Element not found");
        }
    }

    // Binary Search Method (Array must be sorted)
    public static void binarySearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == val) {
                System.out.println("Binary Search: Element found at index " + mid);
                found = true;
                break;
            } else if (val < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!found) {
            System.out.println("Binary Search: Element not found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements of array (sorted for Binary Search):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int val = sc.nextInt();

        // Perform searches
        linearSearch(arr, val);
        binarySearch(arr, val);

        sc.close();
    }
}

