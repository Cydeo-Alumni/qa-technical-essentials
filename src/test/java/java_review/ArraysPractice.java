package java_review;

public class ArraysPractice {
    public static void main(String[] args) {
        //Declare int array with values 1 to 5
        //print each one with space in between
        int[] nums = {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        //print each element in reverse with space in between
        for (int i = nums.length-1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        int[] nums2 = {4, 9, 2, 15, 7};
        System.out.println(getMax(nums2));
    }

    /*
    Method getMax() accepts array of ints and return max number
     */
    public static int getMax(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}
