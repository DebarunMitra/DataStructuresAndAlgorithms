package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public int[] sort(int[] array) {
        int temp = 0, i = 0, j = 0;
        for (i = 0; i < array.length; i++) {
            temp = array[i];
            System.out.println("temp: "+temp);
            for (j = i-1; j >= 0 && temp < array[j]; j--) {
                System.out.println(array[j + 1]+" <--> "+array[j]);
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }

        return array;
    }

    public static void main(String args[]){
        int[] array= {43,60,20,1,0,99,21,33,40};

        InsertionSort is = new InsertionSort();
        array = is.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
