package Next_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Index {

    public static void main(String[] args) {
        int arr[] =  {2, 1, 5, 4, 3, 0, 0};
        int result[] = findNextPermutation(arr);
        
        for(int val : result){
            System.out.print(val + " ");
        }
    }

    public static int[] findNextPermutation(int arr[]){


        int index = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] < arr[i + 1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(arr, 0, arr.length - 1);
            return arr;
        }

        for(int i = arr.length - 1; i > index; i--){
            if(arr[i] > arr[index]){
                swap(arr, i, index);
                break;
            }
        }

        reverse(arr, index + 1, arr.length - 1);

        
        return arr; 
        
    }


    public static void swap(int arr[],int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void reverse(int arr[],int start, int end){
        int i = start;
        int j = end;

        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}