package Sortings;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {50,25,20,10,5};

        for(int i=1; i<array.length-1; i++){

            int value= array[i];
            int index=i;

            while (index>0 && array[i-1]>value){

                int temp= array[i-1];
                array[i-1]=array[i];
                array[i]=temp;

            }


        }

        System.out.println(Arrays.toString(array));
    }
}
