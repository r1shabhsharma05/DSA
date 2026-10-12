class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack <Integer> s = new Stack<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        int ng[] = new int[nums1.length];
        for(int i= 0; i<nums2.length; i++){
            while(!s.isEmpty() && nums2[i] > s.peek()){
                map.put(s.pop() , nums2[i]);
            }
            s.push(nums2[i]);
        }
        for(int i : s){
            map.put(i , -1);
        }
        for(int i =0; i<nums1.length; i++){
            ng[i]= map.get(nums1[i]);
        }
        return ng;
    }
}