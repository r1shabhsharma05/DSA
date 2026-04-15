package Sortingg;

public class bubble {
    public static void bubblesort(int arr[]) {
    for (int n = 0; n < arr.length - 1; n++) {
        boolean swapped = false;

        for (int i = 0; i < arr.length - 1 - n; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                swapped = true;
            }
        }

        if (!swapped) {
            break;   // array already sorted → O(n)
        }
    }
}
    public static void print(int arr[]){
        for(int j = 0; j<arr.length; j++){
           
            System.out.print(arr[j]+" ");
        }
        // System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,3,4,2,1};
        bubblesort(arr);
        print(arr);
    }
}



