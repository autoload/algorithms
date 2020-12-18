import java.util.Arrays;

public class Triangle {
    Integer[][] memo;
    public static void main(String[] args) {
        int nums[][] = {
            {2},
            {3,4},
            {6,5,7},
            {4,1,8,3}
        };
        Triangle triangle = new Triangle();
        triangle.memo = new Integer[nums.length][nums.length];
        System.out.println(triangle.dfs(0, 0, nums));

    }

    public int dfs(int x, int y, int[][] nums) {
        if(x == nums.length) {
            return 0;
        }
        if(memo[x][y] != null) {
            return memo[x][y];
        }
        return memo[x][y] = Math.min(dfs(x + 1, y, nums), dfs(x + 1, y + 1, nums)) + nums[x][y];
    }
}