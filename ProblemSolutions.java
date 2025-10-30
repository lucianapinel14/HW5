******************************************************************
 *
 *   Luciana Pinel / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        // Create a hash set that can store all elements from list1
        Set<Integer> set = new HashSet<>();

        for (int num : list1) {
            set.add(num);
        }

        // Check if every element in list2 is in the set
        for (int num : list2) {
            if (!set.contains(num)) {
                return false;   // If any element of B is missing it is not a subset
            }
        }

        return true;  // All elements of B found in A
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // Create a min-heap (natural ordering)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : array) {
            pq.offer(num);         // add element
            if (pq.size() > k) {
                pq.poll();         // remove smallest to keep only k largest
            }
        }

        // The root now holds the kth largest element
        return pq.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // Create a min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements from both arrays
        for (int num : array1) {
            pq.offer(num);
        }
        for (int num : array2) {
            pq.offer(num);
        }

        // Prepare result array of combined size
        int[] sorted = new int[pq.size()];
        int index = 0;

        // Remove elements in ascending order
        while (!pq.isEmpty()) {
            sorted[index++] = pq.poll();
        }

        return sorted;
    }

}
