import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MyTest {
    /*
Stack的基本使用
初始化
Stack stack=new Stack
判断是否为空
stack.empty()
取栈顶值（不出栈）
stack.peek()
进栈
stack.push(Object);
出栈
stack.pop()
    */

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int k = 8;
        int sum = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int point = 0;   
        // 关键步骤
        Arrays.sort(nums); 
        combinationSum(nums, k, sum, res, temp, point);
        System.out.println(res);
    }

    public static void combinationSum(
        int[] nums,
        int k,
        int sum,
        ArrayList<ArrayList<Integer>> res,
        ArrayList<Integer> temp,
        int point
        ) {
        if(sum > k) {
            return;
        }else if(sum == k) {
            res.add(new ArrayList(temp));
            return;
        }else{
            int len = nums.length;
            for(int i = point; i < len; i++) {
                if(i - 1 >= point && nums[i] == nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                sum += nums[i];
                System.out.println(temp);
                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                combinationSum(nums, k, sum, res, temp, i + 1);
                sum -= nums[i];
                temp.remove(temp.size() - 1);
            }
        }

    }
}

/*

i=0 s=false,false,false temp=null res=null
i=0 s=true,false,false temp=1 res=null
    i=0 false
    i=1 s=true,true,false temp=11 res=null
        i=0 false
        i=1 false
        i=2 s=true,true,true temp=112 res=null
            temp==len res=112
        <-i=2 s=true,true,false temp=11 res=112
        for end
    <-i=1 s=true,false,false temp=1 res=112
    i=2 s=true,true,false temp=12 res=112


public static void combinationSum(
        int[] nums,
        int k,
        int sum,
        ArrayList<ArrayList<Integer>> res,
        ArrayList<Integer> temp,
        int point
        ) {
        if(sum > k) {
            return;
        }else if(sum == k) {
            res.add(new ArrayList(temp));
            return;
        }else{
            int len = nums.length;
            for(int i = point; i < len; i++) {
                temp.add(nums[i]);
                sum += nums[i];
                System.out.println(temp);
                // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                combinationSum(nums, k, sum, res, temp, i);
                sum -= nums[i];
                temp.remove(temp.size() - 1);
            }
        }

    }



*/























