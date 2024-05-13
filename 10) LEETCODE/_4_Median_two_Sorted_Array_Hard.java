public class _4_Median_two_Sorted_Array_Hard {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i=0,j=0,k=0;
        int[] merged = new int[l1 + l2];
        
        while(i < l1  &&  j < l2) {
            if(nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i < l1) {
            merged[k] = nums1[i];
            i++;
            k++;
        }
        while(j < l2) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        
        
        int size = merged.length;
        int median = (merged.length)/2;
        double res;
        if(size % 2 == 0) {
            res = ((double)(merged[median] + merged[median-1])/2);
        } else {
            res = merged[median];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] l1 = {1,2};
        int[] l2 = {3};
        System.out.println(findMedianSortedArrays(l1,l2));
    }
}
