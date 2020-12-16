import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] arg) {
        int[] nums = new int[] {6,6,6,6,7,9,9,9,9,0,1,2,4,5};

        System.out.println(FindSort(nums));

    }

    public static int FindSort(int[] nums) {
        int rs = -1;
        int left = 0;
        int right = nums.length - 1;

        if(nums[left] <= nums[right]) {
            return rs;
        }

        while(nums[left] > nums[right]) {

            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if(nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if(nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1; 
            }
        }

        return rs;  


    }
    
}

