import java.util.*;
class Solution {
    public String removeDuplicates(String s) {
        Stack <Character> a = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!a.isEmpty() && a.peek() == ch){
                a.pop();
            }else {
                a.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(char ch : a){
            sb.append(ch);
        }
        return sb.toString();
    }
}