import java.util.*;
public class validParentheses {
    public static boolean isValid(String str){
        Stack <Character>stack = new Stack<>();
        for(char c : str.toCharArray()){
           if(c == '(') 
            stack.push(')');
           else if(c == '{' )
            stack.push('}');
          else if(c == '[')
            stack.push(']');
            else if(stack.isEmpty() || stack.pop() !=c)
            return false;
        }
        if(stack.isEmpty()){
            return true; 
        } else {
            return false;
        }

    }
    public static void main(String[] args) {
        
        String str = "({})[]";
        System.out.println(isValid(str));

    }
}
