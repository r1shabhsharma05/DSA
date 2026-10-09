public class printdecre{
    public static void printdec{
        if(n ==1 ){
            System.out.println(n);
            return;
        }
      System.out.println(n+" ");
      printdec(n-1);
    }
       public static void main(String[] args){
        int n =10;
       printdec(n);
       }
}