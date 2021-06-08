package Sortings;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        int[] array ={180,165,150,170,145};

        for(int i=0; i<array.length-1;i++){

            for(int j=i+1; j<array.length;j++){

                if(array[i]>array[j]){
                    int temp= array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
