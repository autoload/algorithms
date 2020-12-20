public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {9,1,2,1,4};
        findMinJump(nums);        
    }

    public static void findMinJump(int[] nums) {
        int max = 0;
        int iLen = 0;
        int min = 0;
        for(int i = 0; i < nums.length; i++) {
            iLen = i + nums[i];
            if(iLen > max) {
                max = iLen;
                min++;
            }
            if(i >= max) {
                System.out.println("I am at " + nums[i] + "here no way");
                break;
            }
            if(iLen >= nums.length -1) {
                System.out.println("passed:" + min);
                break;        
            }
        }

    }
}