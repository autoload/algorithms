import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    
    public static void main(String[] arg) {
        int[] nums = new int[] {0,1,1,1,2,2,3,3,4};
        int len = nums.length;
        int temp = 0;
        for(int i = 1; i < len; i++) {
            if(nums[temp] != nums[i]){
                nums[temp + 1] = nums[i];
                temp++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}