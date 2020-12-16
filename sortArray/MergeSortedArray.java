import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] arg) {
        int[] nums1 = {1,2,3,10,0,0,0};
        int[] nums2 = {2,5,6};
        
        int len1 = nums1.length;
        int len2 = nums2.length;

        int p = len1 - 1;
        int p1 = len1 - 1;
        int p2 = len2 - 1;
        while(nums1[p1] == 0){
            p1--;
        }
        System.out.println(p1);
        while(p > 0 && p2 >= 0) {
            if(nums2[p2] >= nums1[p1]) {
                nums1[p] = nums2[p2];
                p2--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }

            p--;
        }

        System.out.println(Arrays.toString(nums1));

    }
}