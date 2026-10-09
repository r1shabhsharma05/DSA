package dsa_sheet;

public class traping_rain {
    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        int n = height.length; 
        // 1. calculate the leftMax boundry
         int leftMax[] = new int[n];
         leftMax[0] = height[0];
         for(int i =1; i<n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
         }
        // 2. calculate right max bound 
        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int trappedWater = 0;
        //loop
        for(int i =0; i<n; i++){
         // water level = min(left max bound , right max bound)
         int waterlevel = Math.min(leftMax[i], rightMax[i]);
         //traped water = water level - height 
         trappedWater += waterlevel - height[i];

        }
        System.out.println(trappedWater);
        
        
    }
}
