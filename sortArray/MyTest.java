import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if(left > right) {
            return;
        }      
        int temp = nums[left];
        int i = left;
        int j = right;
        int s = 0;
        
        while(i < j) {
            while(nums[j] >= temp && i < j) {
                j--;
            }
            while(nums[i] <= temp && i < j) {
                i++;
            }
            s = nums[i];
            nums[i] = nums[j];
            nums[j] = s;
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);

    }


}