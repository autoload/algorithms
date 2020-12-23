import java.util.Arrays;
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, temp, 0, used);
        System.out.println(res);   
    }

    public static void dfs(int[] nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int point, boolean[] used) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(used[i] == false) {
                used[i] = true;
                temp.add(nums[i]);
                dfs(nums, res, temp, i, used);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}