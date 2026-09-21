import java.util.*;

class Solution {
    public String reversePrefix(String word, char ch) {
        Stack <Character> s = new Stack<>();
        int idx = 0;
        while(idx<word.length()){
            char curr = word.charAt(idx);
            s.push(curr);

        if(curr == ch){
            break;
        }
        idx++;
        }
    
    // if ch is not found
     if(idx==word.length()){
        return word;
     }
        StringBuilder result = new StringBuilder("");
        while(!s.isEmpty()){
           char curr = s.pop();
            result.append(curr);
        }
        idx++;
        while(idx<word.length()){
            result.append(word.charAt(idx));
            idx++;
        }
        return result.toString();

    }
}