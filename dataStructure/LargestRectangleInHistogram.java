public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};   
        int point = 2;
        
        int height = maxRectangle(nums);
        System.out.println(height);
    }

    public static int maxRectangle(int[] nums) {
        int i = 0;
        int max = 0;
        int len = nums.length;
        int heigh = 0;
        while(i < len) {
            heigh = findLeft(nums, i) + nums[i] + findRight(nums,i);; 
            if(heigh > max) {
                max = heigh;
            }
            i++;
        }
        return max;
    }

    public static int findLeft(int[] nums, int point) {
        int len = nums.length;
        if(point <= 0  || point == len - 1) {
            return 0;
        }
        int mid = point;
        int s = 1;
        while(point > 0 && nums[mid] <= nums[point]) {
            point--;
            if(point == 0) {
                s = 0;
            }
        }
        return (mid - point - s) * nums[mid];

    }

    public static int findRight(int[] nums, int point) {
        int len = nums.length;
        if(point <=0  || point == len - 1) {
            return 0;
        }
        int mid = point;
        int s = 1;
        while(point < len && nums[mid] <= nums[point]) {
            point++;

        }
        return (point - mid - s) * nums[mid];
    } 


}