import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,2,2};
        int point = 0;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        SubsetsHelper(result, temp, nums, point);
        System.out.println(result); 
    }

    public static void SubsetsHelper(
        ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> temp, 
        int[] nums,
        int point) {
        result.add(new ArrayList<Integer>(temp));

        for(int i = point; i < nums.length; i++){
            if(i > point && nums[i] == nums[i-1]) {
                System.out.println(i);
                continue;
            }
            temp.add(nums[i]);
            SubsetsHelper(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }

    }


}





/*
public class Subsets {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {1,2,3};
        int pos = 0;
        subsetsHelper(result, list, nums, pos);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result, 
        ArrayList<Integer> list, 
        int[] nums, 
        int pos) {
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
*/