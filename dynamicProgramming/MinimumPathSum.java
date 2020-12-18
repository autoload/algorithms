public class MinimumPathSum {
    Integer[][] used;

    public static void main(String[] args) {
        int[][] nums = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        MinimumPathSum pathSum = new MinimumPathSum();
        pathSum.used = new Integer[nums.length][nums[0].length];
        int min = pathSum.dfs(0, 0, nums);
        System.out.println(min);

    }

    public int dfs(int x, int y, int[][] nums){
        if(x == nums.length - 1  && y == nums[0].length - 1) {
            return nums[x][y];
        }
        if(x == nums.length - 1) {
            return dfs(x, y + 1, nums) + nums[x][y];
        }
        if(y == nums[0].length - 1) {
            return dfs(x + 1, y, nums) + nums[x][y];
        }
        int right = dfs(x, y + 1, nums);
        int down = dfs(x + 1, y, nums);
        return Math.min(right, down) + nums[x][y];
    }

}