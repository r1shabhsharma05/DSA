class Solution {
    static void solve(int [] nums, int i, List<List<Integer>> ans , List<Integer> ds ){
    // base case 
    if(i >= nums.length){
        ans.add(new ArrayList<>(ds));
        return;
    }
    ds.add(nums[i]);
    solve(nums , i+1 , ans ,ds);
    // remove 
    ds.remove(ds.size() -1);
    
    solve(nums, i+1 , ans ,ds);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int i =0;
        solve(nums , i , ans , ds);
        return ans;
    }
}