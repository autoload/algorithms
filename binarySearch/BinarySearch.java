public class BinarySearch {
    public static void main(String[] arg) {
        int[] nums = new int[] {1,2,3,6,9,12};
        int target = 9;
        int start = 0;
        int end = nums.length - 1;
        int point = -1;
        int mid;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                point = mid;
                break;
            }else if(nums[mid] < target) {
                start = mid + 1;
            }else if(nums[mid] > target) {
                end = mid - 1;
            }
        }
        System.out.println(point);
    }
}






































/*
public class BinarySearch {
    public static void main(String[] arg) {
        int[] nums = new int[] {5,7,7,7,7,8,8,8,12};
        int target = 1;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        int point = -1;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                end = mid;
            } else if(nums[mid] < target) {
                start = mid;
            } else if(nums[mid] > target){
                end = mid;
            }
            if(nums[start] == target) {
                point = start;
                break;
            }
            if(nums[end] == target) {
                point = end;
                break;
            } 
        }
        System.out.println(point);
    }
}
*/