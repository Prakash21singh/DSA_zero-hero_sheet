package Max_sum_subarray;

public class Index {
 
    public static void main(String[] args) {
        int arr[] = {4,-1,2,1};

        int result = optimalApproach(arr);
        System.out.println(result);
    }
    /*
     * Follow up question 
     * Can you print the subarray that's returning the maximum sum?
     * You can do this
     */

    // Optimal Approach using kadane's algorithm 
    /**
     * Time complexity is O(n)
     * Space complexity is O(1) 
     */
    public static int optimalApproach(int arr[]){

        int maxSubArr = Integer.MIN_VALUE;

        int sum = 0;

        // For returning the starting and ending element
        int start = 0;
        int resStart = -1;
        int resEnd = -1;

        for (int i = 0; i < arr.length; i++) {
            if(sum == 0) {
                start = i;
            }

            sum += arr[i];

            if(sum > maxSubArr){
                resStart = start;resEnd = i;
                maxSubArr = Math.max(maxSubArr, sum);
            }

            if(sum < 0) sum = 0;
        }

        for (int i = resStart; i <= resEnd; i++) {
            System.out.print(arr[i] + " ");
            
        }
        return maxSubArr;
    }




    // Better appoach to get the max sum of subarray;
    public static int betterApproach(int arr[]){
        /**
         * Time complexity and Space complexity here is:
         * Time Complexity = O(n^2) Because we're running two loops here anyhow
         * Space Complexity = O(n) [sum]
         */
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum+= arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    // This is brute force approach that uses
    // Time Complexity of O(n*3) 
    // Space complexity is O(n)
    public static int bruteForce(int arr[]){
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    sum+= arr[j2];
                }
                max = Math.max(max, sum);
            }
        }

        return max; 
    }
}
