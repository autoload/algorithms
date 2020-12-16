import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Permutations {
    public static void main(String[] arg) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList();
        int[] nums = new int[] {1, 1, 2};
        boolean[] used = new boolean[nums.length];

        PermutationsHelper(result,temp,nums,used);
        System.out.println(result);
    }

    public static void PermutationsHelper(
        ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> temp, 
        int[] nums, 
        boolean[] used
        ) {
        if(nums.length == temp.size()) {
            result.add(new ArrayList<Integer>(temp));
        }else{
            for(int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i-1] == nums[i] && used[i-1] == false) {
                    continue;
                }
                if(used[i] == false){
                    used[i] = true;
                    temp.add(nums[i]);
                    PermutationsHelper(result,temp,nums,used);
                    temp.remove(temp.size() - 1);
                    used[i] = false;
                }
                
            }
        }

    }
}