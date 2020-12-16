import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Binarysearch {
     public static void main(String[] args) {
        int[] nums = new int[] {1,3,6,7,8,9,};
        int target = 13;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}