public class ClimbingStairs {
    public static void main(String[] args) {
        int stairs = 4;

        System.out.println(dfs(stairs));

    }

    public static int dfs(int i) {
        if(i == 1) {
            return 1;
        }
        if(i == 2) {
            return 2;
        }
        return dfs(i - 1) + dfs(i - 2);
    }
}