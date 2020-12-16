import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Combination {
    public static void main(String[] arg) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int[] nums = new int[] {10,1,2,7,6,1,5};
        Arrays.sort(nums);
        int sum = 0;
        int target = 8;
        int point = 0;

        CombinationHelper(result, temp, nums, sum, target, point);
        System.out.println(result);
    }

    public static void CombinationHelper(
        ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> temp, 
        int[] nums,
        int sum,
        int target, 
        int point
        ) {
        if(sum == target) {
            result.add(new ArrayList<Integer>(temp));
        }else if(sum < target) {
            for(int i = point; i < nums.length; i++) {
                if(i - 1 >= point && nums[i] == nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                CombinationHelper(result, temp, nums, sum + nums[i], target,i+1);
                temp.remove(temp.size() - 1);   
            }
        }

    }
}