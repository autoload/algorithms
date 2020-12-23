import java.util.Arrays;
import java.util.ArrayList;

public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        dfs(nums, res, temp, 0);
        System.out.println(res);        
    }

    public static void dfs(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int point) {
        res.add(new ArrayList<Integer>(temp));
        for(int i = point; i < nums.length; i++) {
            if( i > point && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}