/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucket.sort;

import java.util.*;

/**
 *
 * @author Nred
 */
public class BucketSort {

    /**
     * @param args the command line arguments
     */
    public static void sort(int[] array, int max) {
        int[] bucket = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int b = 0; b < bucket[i]; b++) {
                array[outPos++] = i;
            }
        }
    }

    public static void main(String[] args) {
        long t1, t2, t3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Maximium Value");
        int max = sc.nextInt();
        System.out.println("Amount of numbers");
        int[] nums = new int[sc.nextInt()];
        t1 = System.currentTimeMillis();
        System.out.println("Random Order: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.ceil(Math.random() * max);
            System.out.print(nums[i] + " ");
        }
        t2 = System.currentTimeMillis();
        sort(nums, max);
        System.out.println("\n\nSorted: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        t3 = System.currentTimeMillis();
        System.out.print("\nRandomizing and Displaying " + (t2 - t1) + "ms\nDisplaying Sorted: " + (t3 - t2) + "ms");
    }
}
