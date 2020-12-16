public class FirstBadVersion {
    public static void main(String[] arg) {
        int left = 1;
        int right = 30;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    public static boolean isBadVersion(int mid) {
        System.out.println(mid);
        if(mid >20) {
            return true;
        } else {
            return false;
        }
    }
}