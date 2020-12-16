
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@SuppressWarnings("unchecked")
public class Leetcode {

    public static void main(String[] args) {
        String s = "aab";
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            System.out.println(0);
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        backtracking(s, 0, len, stack, res);
        System.out.println(res);
    }

    /**
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    public static void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            
        }

        for (int i = start; i < len; i++) {
            System.out.println("----------------");
            System.out.println(i + "----" + start + "----" + s);
            System.out.println(s.substring(start, i + 1));

            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!checkPalindrome(s, start, i)) {
                System.out.println("continue");
                continue;
            }

            path.addLast(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.removeLast();
        }

    }


    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private static boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


/*

import java.util.ArrayList;
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {1,2,3};
        int pos = 0;
        subsetsHelper(result,list,nums,pos);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums,
        int pos) {
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            if(i-1>=pos ){
                    continue;
            }
            System.out.println(nums[i]);
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

    }
}

*/


/*
Combination2

public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {2,5,2,1,2};
        //int[] nums = new int[] {10,1,2,7,6,1,5};
        int target = 5; 
        int sum = 0;
        int begin = 0;
        Arrays.sort(nums);
        subsetsHelper(result,list,nums,target,sum,begin);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums,
        int target,
        int sum,
        int begin) {
        if(target == sum){
                result.add(new ArrayList<Integer>(list));
        }else if(target > sum){
            for(int i = begin; i < nums.length; i++) {
                if(i-1>=begin && nums[i-1]==nums[i]){
                    continue;
                }
                list.add(nums[i]);
                subsetsHelper(result, list, nums,target,sum+nums[i],i+1);
                list.remove(list.size() - 1);
            }
            
        }

        

    }
}


Combination Sum
public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        //int[] nums = new int[] {2,3,6,7};
        int[] nums = new int[] {2,3,5};
        int target = 8; 
        int sum = 0;
        int begin = 0;
        subsetsHelper(result,list,nums,target,sum,begin);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums,
        int target,
        int sum,
        int begin) {
        if(target == sum){
                result.add(new ArrayList<Integer>(list));
        }else if(target > sum){
            for(int i = begin; i < nums.length; i++) {
                list.add(nums[i]);
                subsetsHelper(result, list, nums,target,sum+nums[i],i);
                list.remove(list.size() - 1);
            }
            
        }

        

    }
}

Permutations2
public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {1,2,3};
        boolean[] used = new boolean[nums.length]; 
        subsetsHelper(result,list,nums,used);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums,
        boolean[] used) {
        if(nums.length == list.size()){
                result.add(new ArrayList<Integer>(list));
        }else{
            for(int i = 0; i < nums.length; i++) {
                if(i>0 && nums[i]==nums[i-1] && used[i-1]==true){
                    continue;
                }
                if(used[i]==false){
                    list.add(nums[i]);
                    used[i] = true;
                    subsetsHelper(result, list, nums,used);
                    list.remove(list.size() - 1);
                    used[i] = false;
                }
            }
        }

        

    }
}


Permutations
public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {1,2,3};
        subsetsHelper(result,list,nums);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums) {
        if(nums.length == list.size()){
                result.add(new ArrayList<Integer>(list));
        }else{
            for(int i = 0; i < nums.length; i++) {
                System.out.println("-----------");
                if(list.contains(nums[i])){
                    System.out.println(list);
                    System.out.println(nums[i]+"退出");
                    continue;
                }else{
                    System.out.println(list);
                    System.out.println(nums[i]+"没有退出");
                }
                list.add(nums[i]);
                subsetsHelper(result, list, nums);
                list.remove(list.size() - 1);
            }
        }

        

    }
}

subsets2
public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {1,2,2};
        int pos = 0;
        subsetsHelper(result,list,nums,pos);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums,
        int pos) {
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            if(i>pos && nums[i] == nums[i-1]){
                //System.out.println(i+"--"+pos);
                continue;
            }
            //System.out.println(nums[i]);
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

    }
}


subsets
public class Leetcode {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        int[] nums = new int[] {1,2,3};
        int pos = 0;
        subsetsHelper(result,list,nums,pos);
        System.out.println(result);
    }

    public static void subsetsHelper(ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> list,
        int[] nums,
        int pos) {
        result.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++) {
            System.out.println(nums[i]);
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

    }
}
*/