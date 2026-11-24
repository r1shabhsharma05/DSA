class Solution {
     private void fc(int[] arr , int target, List<Integer> ds, int i, List<List<Integer>> ans){
       
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            return;
        }
        for(int ind =i; ind<arr.length; ind++){
            if(ind>i && arr[ind] == arr[ind-1]) continue ;
            if(arr[ind]>target) break;
    
            ds.add(arr[ind]);
            fc(arr, target-arr[ind], ds, ind+1, ans);
            ds.remove(ds.size()-1);
    }
     }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        fc(candidates, target,new ArrayList<>(), 0 , ans);
        return ans;
    }
}