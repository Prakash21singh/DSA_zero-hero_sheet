package LongestConsecutive;

import java.util.HashSet;

public class Index {
    
    public static void main(String[] args) {
        // int arr[] = {100, 200, 1, 3, 2, 4};
        int arr[] = {10, 4, 11, 2, 12,3,5};
        optimalApproach(arr);
        // print(arr);
    }

    public static void optimalApproach(int arr[]){

        HashSet<Integer> set = new HashSet<>();
        
        int finalStreak = 0;

        for(int val : arr){
            set.add(val);
        }

        for(int val : set){
            if(!set.contains(val - 1)){
                int currentNum = val;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                finalStreak = Math.max(currentStreak, finalStreak);
            }
        }

        System.out.println(finalStreak);
    }

    public static void betterApproach(int arr[]){

        sort(arr);

        int longest = 0;

        int count = 0;

        int lastSmaller = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if(arr[i] -1 == lastSmaller){
                lastSmaller = arr[i];
                count++;
            }else if(arr[i] != lastSmaller  ){
                lastSmaller = arr[i];
                count = 1;
                longest =  Math.max(longest, count);
            }

            longest =  Math.max(longest, count);

            // System.out.println(lastSmaller);

        }

        System.out.println(longest);

    }

    /*
     * Brute force will be something like this 
     * 
     * We can keep a max result as 1, because if there's no consecutive there will be 1 for sure.
     * And we have count initialized as 1, If next number is not consecutive then set the count as 1 again for next check.
     * and store the max count in result
     */
    public static void bruteForce(int arr[]){

        int result = 1;
        int count = 1;
        // sorting could be a way to do so 
        sort(arr);

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] + 1 == arr[i + 1]){
                count++;
            }else{
                count=1;
            }

            result = Math.max(result, count);
        }

        System.out.println(result);

    }


    public static void sort(int arr[]){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
             if(arr[i] > arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
             }   
            }
        }
    }
    
    public static void print(int arr[]){
        for(int val : arr){
            System.out.print(val + " ");
        }
    }
}
