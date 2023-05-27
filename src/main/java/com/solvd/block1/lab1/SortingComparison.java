package com.solvd.block1.lab1;

/*
In this example, I implemented the Merge Sort algorithm as the second sorting algorithm.
I also added a helper method generateRandomArray() to generate a big array of random numbers.
The main() method measures the execution time (in milliseconds) for both Bubble Sort and Merge Sort on the generated array,
and prints out the results.
*/

import java.util.Arrays;
import java.util.Random;


public class SortingComparison {

    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort implementation
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(left);
            mergeSort(right);
            merge(arr, left, right);
        }
    }

    // Helper method for Merge Sort to merge two sorted arrays
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Helper method to generate a big array of random numbers
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            // Populate array wth random int numbers from 0 to 30000
            arr[i] = random.nextInt(30000);
        }
        return arr;
    }

    public static void main(String[] args) {
        // Generate a big array of random numbers
        int[] arr = generateRandomArray(10000);

        // Create a copy of the array for each sorting algorithm
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        // Measure execution time for Bubble Sort
        long startTime = System.currentTimeMillis();
        bubbleSort(arr1);
        long endTime = System.currentTimeMillis();
        long bubbleSortTime = endTime - startTime;

        // Measure execution time for Merge Sort
        startTime = System.currentTimeMillis();
        mergeSort(arr2);
        endTime = System.currentTimeMillis();
        long mergeSortTime = endTime - startTime;


        // Show outputs

        // Display Original randomly generated array
        System.out.println("Original Array: " + Arrays.toString(arr));

        // Display Bubble Sorted Array
        System.out.println("Sorted Array 1: " + Arrays.toString(arr1));

        // Display Merge Sorted Array
        System.out.println("Sorted Array 2: " + Arrays.toString(arr2));

        // Display time comparison
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ms");
        System.out.println("Merge Sort Time: " + mergeSortTime + " ms");
    }
}

