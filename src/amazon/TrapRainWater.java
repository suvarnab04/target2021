package amazon;
/*
https://www.youtube.com/watch?v=ECbgLWIXeMo
https://www.youtube.com/watch?v=ECbgLWIXeMo
 */
public class TrapRainWater {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int leftMax =0;
        for(int i=0;i< height.length;i++){
            left[i] = Math.max(leftMax, height[i]);
            leftMax = left[i];
        }
        int rightMax =0;
        for(int i=height.length-1;i>=0;i--){
            right[i] = Math.max(rightMax, height[i]);
            rightMax = right[i];
        }

        for(int i=0;i< height.length;i++){
            System.out.print(left[i] + ",");
        }
        System.out.println();
        for(int i=0;i< height.length;i++){
            System.out.print(right[i] + ",");
        }

        //we will resume our left to store the min of left and right
        int waterTrapped =0;

        for(int i=0;i< height.length;i++){
            int mincapacity = Math.min(left[i], right[i]);
            waterTrapped += (mincapacity - height[i]) > 0 ? (mincapacity - height[i]) : 0;
        }
        return waterTrapped;

    }
}
