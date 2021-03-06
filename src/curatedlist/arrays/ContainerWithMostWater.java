package curatedlist.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * https://www.youtube.com/watch?v=TI3e-17YAlc
 *
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start=0;
        int end =height.length-1;
        int water = 0;

        while(start< end){
            water = Math.max(water, (end-start) *Math.min(height[start], height[end]));
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return water;

    }
}
