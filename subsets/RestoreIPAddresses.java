import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIPAddresses {

    static final int SEG_COUNT = 4;
    List<String> list = new ArrayList<>();
    int[] seg = new int[SEG_COUNT];

    public static void main(String[] arg) {

        RestoreIPAddresses rs = new RestoreIPAddresses();
        /*
        String s = "1111";
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            nums[i] = Integer.parseInt( String.valueOf(s.charAt(i)));
        }
        ArrayList<String> reslut = new ArrayList<String>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int sum = 0;
        restoreHelper(reslut, nums, temp, sum);
        System.out.println(Arrays.toString(nums));
        */
        String s = "25525511135";
        rs.restoreIpAddresses(s);
        System.out.println(rs.list);

    }

    public void restoreIpAddresses(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        dfs(arr, 0, 0, len);
    }

    private void dfs(char[] arr, int depth, int start, int len) {
        if(depth == SEG_COUNT) {
            StringBuilder sb = new StringBuilder();
            if(start == len) {
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(seg[i]);
                    if(i != SEG_COUNT-1) {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if(start == len) return;

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if(arr[start] == '0') {
            seg[depth] = 0;
            dfs(arr, depth+1, start+1, len);
        }
        
        //枚举一般情况
        int tmp = 0;
        for (int j = start; j < len; j++) {
            tmp = tmp * 10 + (arr[j] - '0');
            System.out.println(tmp);
            if(tmp > 0 && tmp <= 255) {
                seg[depth] = tmp;
                dfs(arr, depth+1, j+1, len);
            } else {
                break;
            }
        }
        
    }
}