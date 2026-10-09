class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Integer> s = new Stack<>();
        int nextgre [] = new int[temperatures.length];
        for(int i = temperatures.length-1;i>=0; i--){
             while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextgre[i] = 0;
            }else {
                nextgre[i] = s.peek()-i;
            }
            s.push(i);
        }
        return nextgre;
    }
}