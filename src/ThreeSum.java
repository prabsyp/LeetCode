import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

/**
 * 
 * @author prabsy
 * 
 *	We iterate over the list using two for loops,
 *  selecting one number at a time in the list.
 *  We get the third number by adding the numbers to a set
 *  and check if the sum of the first two numbers and any of 
 *  the numbers added to the set is 0
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> finalSet = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++) {
            Set<Integer> set = new HashSet<Integer>();
            for(int j = i+1; j< nums.length; j++) {
                if(set.contains(0 - nums[i] - nums[j])) {
                    List<Integer> subList = new ArrayList<Integer>();
                    subList.add(nums[j]);
                    subList.add(nums[i]);
                    subList.add(0 - nums[j] - nums[i]);
                    finalSet.add(subList);
                }
                set.add(nums[j]);
            }
        }
        List<List<Integer>> finalList = new LinkedList<List<Integer>>();
        finalList.addAll(finalSet);
        return finalList;
    }
	
	public static void main(String[] args) {
		ThreeSum ts1 = new ThreeSum();
		int[] input = {-1, 0, 1, 2, -1, -4};
		System.out.println(ts1.threeSum(input));
	}
}
