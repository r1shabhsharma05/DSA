package Array;

public class largest {
    public static int largestNumber(int number[]){
        int largest = Integer.MIN_VALUE;
        for(int i =0; i<number.length; i++){
            if(largest<number[i]){
                largest = number[i];

            }
        }
        return largest;
    }
    public static void main(String[] args) {
        int number[] = {1,2,6,3,4,2};
        System.out.println(largestNumber(number));

    }
}
