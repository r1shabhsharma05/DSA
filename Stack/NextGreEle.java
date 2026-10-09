import java.util.*;
public class NextGreEle {
     
    public static void main(String[]args){
        int arr[] = {6,8,0,1,3};
        Stack <Integer> s = new Stack<>();
        int nextGre[] = new int[arr.length];
        for(int i =arr.length-1; i>=0; i--){
         while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
           s.pop();
         }
         if(s.isEmpty()){
            nextGre[i] = -1;
         }
         else{
            nextGre[i] = arr[s.peek()];
         }
         s.push(i);
        }
        for(int i =0; i<nextGre.length; i++){
            System.out.print(nextGre[i] + " ");
        }
        System.out.println();
        // next greater right
        //next greater left :- loop chnage 
        //next samaller right :- while condition chnage 
        // next smaller left :- loop chnage and condition chnage ;
        
    }
}
