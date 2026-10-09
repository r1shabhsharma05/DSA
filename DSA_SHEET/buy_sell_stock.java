package dsa_sheet;

public class buy_sell_stock {
    public static void main(String[] args) {
        int x[] = {7,1,5,3,6,4};
        int buyStock = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i =0; i<x.length; i++){
            if(buyStock<x[i]){
                int profit = x[i]-buyStock;
                maxprofit = Math.max(maxprofit, profit);
            }
            else {
                buyStock = x[i];
            }
        }
System.out.println(maxprofit);
    }
}
