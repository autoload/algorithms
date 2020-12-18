import java.util.Arrays;

public class MyTest {
    Integer[][] used;
    public static void main(String[] args) {
        int[][] nums = {
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3}
        };

        MyTest myTest = new MyTest();
        myTest.used = new Integer[nums.length][nums.length];
        int min = myTest.dfs(0, 0, nums);
        System.out.println(min);
    }

    public int dfs(int x, int y, int[][] nums) {
        if(x == nums.length) {
            return 0;
        }
        if(used[x][y] != null) {
            return used[x][y];
        }
        int left = dfs(x + 1, y, nums);
        int right = dfs(x + 1, y + 1 ,nums);
        return used[x][y] = Math.min(left,right) + nums[x][y];
    }
}