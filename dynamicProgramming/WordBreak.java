import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

@SuppressWarnings("unchecked")
public class WordBreak {
    public static void main(String[] args) {
        String s = "leetccode";
        List<String> wordDict = Arrays.asList("leet", "code","leetccod","e");
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(i + "-----" + j);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
