package codingpractice;

import java.util.Arrays;

public class CodingPractice {
	
	public static void printHelloWorld(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%5==0) 
				System.out.println("Hello");
				
			if(nums[i]%7==0) 
				System.out.println("World");
			
			if(nums[i]%5==0 && nums[i]%7==0)
				System.out.println("Hello World");
		}
	}
	
	public static void findSecondBiggest(int[] nums) {
		Arrays.sort(nums);
		System.out.println(nums[nums.length-2]);
	}
	
	public static void main(String[] args) {
		int[] nums1= {1,2,4,6,14,10,35};
		int[] nums2= {1,2,3,4,5};
		int[] nums3= {19,9,11,0,12};
		
		printHelloWorld(nums1);
		findSecondBiggest(nums2);
		findSecondBiggest(nums3);

	}

}
