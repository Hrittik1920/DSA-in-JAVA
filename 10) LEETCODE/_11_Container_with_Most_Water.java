public class _11_Container_with_Most_Water {
    public static int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int area = 0;
        int sum = 0;
        while(i<j) {
            sum = Math.min(height[i],height[j])*(j-i);
            if(sum > area) {
                area = sum;
            }
            if(height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int height[] = {1,1};
        System.out.println(maxArea(height));
    }
}
