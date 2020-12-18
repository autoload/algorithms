public class UniquePaths {

    Integer path[][];

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.path = new Integer[m][n];
        int nums = uniquePaths.dfs(0, 0);

        System.out.println(nums);
    }

    public int dfs(int x, int y) {
        if(x == path.length - 1 && y == path[0].length -1) {
            return 1;
        }
        if(x == path.length - 1) {
            return dfs(x, y + 1);
        }
        if(y == path[0].length - 1 ) {
            return dfs(x + 1, y);
        }
        int right = dfs(x, y + 1);
        int left = dfs(x + 1, y);
        return right + left;
    }
}