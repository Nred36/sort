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

    static boolean aToZ;

    /**
     * @param args the command line arguments
     */
    public static void sort(int[] array, int max) {
        int[] bucket = new int[max + 1];//creats the max number of buckets
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;//adds 1 to the the number of array in bucket
        }

        int outPos = 0;
        if (aToZ) {
            for (int i = 0; i < bucket.length; i++) {
                for (int b = 0; b < bucket[i]; b++) {//runs for the number of items in the bucket
                    array[outPos] = i;//updates the array                 
                    outPos++;//adds 1 to the out postion so to do not output in the same spot

                }
            }
        } else {
            for (int i = bucket.length - 1; i > 0; i--) {
                for (int b = 0; b < bucket[i]; b++) {//runs for the number of items in the bucket
                    array[outPos] = i;//updates the array                 
                    outPos++;//adds 1 to the out postion so to do not output in the same spot

                }
            }
        }
    }

    public static void main(String[] args) {
        long t1, t2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Maximium Value");
        int max = sc.nextInt();
        System.out.println("Amount of numbers");
        int num = sc.nextInt();
        System.out.println("A to Z (true) or Z to A (false)");
        aToZ = sc.nextBoolean();
        int[] nums = new int[num];
        System.out.println("Random Order: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.ceil(Math.random() * max);
            System.out.print(nums[i] + ", ");
        }
        t1 = System.currentTimeMillis();
        sort(nums, max);
        System.out.println("\n\nSorted: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        t2 = System.currentTimeMillis();
        System.out.print("\nSorting Time " + (double) (t2 - t1) / 1000 + "s");
    }
}
