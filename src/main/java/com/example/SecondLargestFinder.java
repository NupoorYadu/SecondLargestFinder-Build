package com.example;

/**
 * Program to find the second largest element in an array without sorting.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SecondLargestFinder {

    /**
     * Finds the second largest element in an array in a single pass.
     * 
     * @param arr the input array
     * @return the second largest element
     * @throws IllegalArgumentException if array has less than 2 elements
     */
    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Array must have at least 2 distinct elements");
        }

        return secondLargest;
    }

    /**
     * Main method to demonstrate the functionality.
     */
    public static void main(String[] args) {
        int[] testArray = {12, 35, 1, 10, 34, 1, 45, 23};
        System.out.println("Array: " + java.util.Arrays.toString(testArray));
        System.out.println("Second Largest Element: " + findSecondLargest(testArray));

        int[] testArray2 = {100, 50, 75, 25, 90};
        System.out.println("\nArray: " + java.util.Arrays.toString(testArray2));
        System.out.println("Second Largest Element: " + findSecondLargest(testArray2));

        int[] testArray3 = {-5, -10, -1, -20};
        System.out.println("\nArray: " + java.util.Arrays.toString(testArray3));
        System.out.println("Second Largest Element: " + findSecondLargest(testArray3));
    }
}
