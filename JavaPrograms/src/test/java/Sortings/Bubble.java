package Sortings;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] array = {50,25,20,10,5};

        System.out.println("Before Sorting "+ Arrays.toString(array));

        for(int i=0; i<array.length-1;i++){
            int flag=0;

            for(int j=0; j<array.length-1-i;j++){

                if(array[j]>array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                    flag=1;
                }


            }
            if(flag==0){
                break;
            }
        }

        System.out.println("After sorting "+Arrays.toString(array));
    }
}
