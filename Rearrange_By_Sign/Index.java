package Rearrange_By_Sign;

import java.util.ArrayList;

public class Index {
    public static void main(String[] args) {
        int arr[] = {-1,-8,-1,2,3,-2,};

        morePosThanNeg(arr);

        for(int val :arr){
            System.out.println(val);
        }
    }

    public static void morePosThanNeg(int arr[]){

        /**
         * This serves :
         * Time Complexity as O(n) for partition then O(n) in worst case if all are +ve and if all are -ve Hence it becomes O(2n);
         * Space complexity is O(n) cause we're storing the +Ve as well as -ve;
         */
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                pos.add(arr[i]);
            }else{
                neg.add(arr[i]);
            }
        }

        if(pos.size() > neg.size()){
            for (int i = 0; i < neg.size(); i++) {
                arr[2*i] = pos.get(i);  
                arr[2*i + 1] = neg.get(i);
            }
            int index = neg.size();

            for (int i = index * 2; i < arr.length; i++) {
                arr[i] = pos.get(index);
                index++;
            }

        }else{
            for (int i = 0; i < pos.size(); i++) {
                arr[2*i] = pos.get(i);  
                arr[2*i + 1] = neg.get(i);
            }

            int index = pos.size();


            for (int i = index * 2; i < arr.length; i++) {
                arr[i] = neg.get(index);
                index++;
            }
        }


    }

    public static int[] optimal(int arr[]){
        int res[] = new int[arr.length];
        int posIndex = 0;
        int negIndex = 1;


        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                res[posIndex] = arr[i];
                posIndex+=2;
            }else{
                res[negIndex]=arr[i];
                negIndex+=2;
            }
        }

        return res;
    }


    public static void bruteForce(int arr[]){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();


        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0){
                pos.add(arr[i]);
            }else{
                neg.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            arr[2*i] = pos.get(i);
            arr[2*i+1] = neg.get(i);
        }

    }
}