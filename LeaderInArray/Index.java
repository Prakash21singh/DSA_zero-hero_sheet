package LeaderInArray;

import java.util.ArrayList;

public class Index {

    public static void main(String[] args) {
        int arr[] = {10, 22, 12, 3, 0, 6};
        optimalApproach(arr);
        
    }


    public static void optimalApproach(int arr[]){
        // {10, 22, 12, 3, 0, 6}
        // Think that if 12 is greator than the max element within this [3, 0, 6] means that 12 is greator
        
        ArrayList<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        /*
         * Check the board for explanation
         */
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > max){
                list.add(arr[i]);
            }

            max = Math.max(max, arr[i]);   
        }

        for(int val :list){
            System.out.print(val + " ");
        }

    }
    
    
    public static void bruteForce(int arr[]){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean isGreater = false;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    isGreater = true;
                }
            }

            if(isGreater == false){
                list.add(arr[i]);
            }
        }


       
    }


}