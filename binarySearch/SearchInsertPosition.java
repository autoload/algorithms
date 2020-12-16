public class SearchInsertPosition {
    public static void main(String[] arg) {
        int[] nums = new int[] {1,2,3,3,3,5,6};
        int target = 2;

        int len = nums.length;

        if(len == 0){
            System.out.println(0);
        }else if(nums[len - 1] < target) {
            System.out.println(len);
        }else{
            int start = 0;
            int end = len - 1;
            while(start < end) {
                int mid = start + (end - start) / 2;
                if(nums[mid] < target) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(start + 1);
        }
    }
}


/*
public class SearchInsertPosition {
    public static void main(String[] arg) {
        int[] nums = new int[] {1,2,3,3,3,5,6};
        int target = 2;

        int len = nums.length;
        if (len == 0) {
            System.out.println(0);
        } else if (nums[len - 1] < target) {
            System.out.println(len);
        } else {
            int left = 0;
            int right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 严格小于 target 的元素一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                } else {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                }
            }
            System.out.println(left);
        }
    }
}

*/

/*
public class SearchInsertPosition {
    public static void main(String[] arg) {
        int[] nums = new int[] {1,3,3,3,5,6};
        int target = 3;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        int point = -1;

        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                start = mid;
                break;
            } else if(nums[mid] < target) {
                start = mid;
            } else if(nums[mid] > target){
                end = mid;
            }
        }

        if(nums[start] >= target) {
            point = start;
        }else if(nums[end] >= target) {
            point = end;
        }else{
            point = end + 1;
        }

        System.out.println(point);
    }
}
*/