public class MyTest {
    public static void main(String[] args) {
        int[] nums = {5,6,6,8,8,9,10};
        int key = 6;
        int index = findIndex(nums, key);
        System.out.println(index);
    }

    public static int findIndex(int[] nums, int key) {
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right -left) / 2;
            
           
            
    
            /*   
            if(nums[mid] >= key) {
                right = mid;
            }else{
                left = mid + 1; 
            }
            */

            if(nums[mid] <= key) {
                left = mid;
            }else{
                right = mid - 1; 
            }

        }
        return right;

        
    }
}