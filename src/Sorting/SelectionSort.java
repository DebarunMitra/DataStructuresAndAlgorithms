package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public int[] sort(int[] array){
        int min=0, temp=0;
        for(int i=0;i< array.length-1;i++){
            min = i;
            for(int j=i+1;j< array.length;j++){
                if(array[min]>array[j]){
                    min = j;
                }
            }
            temp = array[min];
            array[min] = array[i];
            array[i]=temp;
        }

        return array;
    }

    public static void main(String args[]){
        int[] array= {43,60,20,1,0,99,21,33,40};

        SelectionSort ss = new SelectionSort();
        array = ss.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
