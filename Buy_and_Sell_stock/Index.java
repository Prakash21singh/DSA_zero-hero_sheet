package Buy_and_Sell_stock;

public class Index {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int result = optimalApproach(arr);
        System.out.println(result);
        
    }

    public static int optimalApproach(int arr[]){
      int minimum = arr[0];
      int maxProfit = 0;

      for (int i = 1; i < arr.length; i++) {
        int profit = arr[i] - minimum;
        maxProfit = Math.max(maxProfit, profit);
        minimum = Math.min(minimum, arr[i]);
      }

      return maxProfit;
    }

    /**
     * This is brute force approach that takes: 
     * Time complexity of O(2n)
     * Space complexity of O(1) 
     */
    public static int bruteForce(int arr[]){

       int maxProfit = 0;

       for (int i = 0; i < arr.length; i++) {
        for (int j = i+ 1; j < arr.length; j++) {
         maxProfit =   Math.max(maxProfit, arr[j] - arr[i]);
        }
       }

       return maxProfit;
    }
    
}
