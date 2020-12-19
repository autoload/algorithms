public class UniquePaths {

    Integer path[][];
    int s = 0;

    public static void main(String[] args) {
        int m = 3;
        int n = 8;
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.path = new Integer[m][n];
        int nums = uniquePaths.dfs(0, 0);

        System.out.println(nums);
        System.out.println(uniquePaths.s);
    }

    public int dfs(int x, int y) {
        s++;
        if(x == path.length - 1 && y == path[0].length -1) {
            return 1;
        }
        if(path[x][y] != null) {
            return path[x][y];
        }
        if(x == path.length - 1) {
            return path[x][y] = dfs(x, y + 1);
        }
        if(y == path[0].length - 1 ) {
            return path[x][y] =  dfs(x + 1, y);
        }
        int right = dfs(x, y + 1);
        int left = dfs(x + 1, y);
        return path[x][y] = right + left;
    }
}