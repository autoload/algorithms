public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {1, 4, 0, 0, 4};
        System.out.println(findWay(nums));

    }

    public static boolean findWay(int[] nums) {
        int end = nums.length;
        int max = 0;
        int iLen = 0;
        for(int i = 0; i < end; i++){
            iLen = i + nums[i];
            if(iLen > end) {
                return true;
            }
            if(iLen > max) {
                max = iLen;
            }
            if(i >= max) {
                return false;
            }
        }
        return true;
    }
}

/*
    public static boolean findWay(int[] nums, int end) {
        if(end < 1) {
            System.out.println(end);
            return true;
        }
        for(int i = end - 1; i >= 0; i--){
            if(i + nums[i] >= end) {
                return findWay(nums, i);
            }
        }
        return false;
    }
*/