package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public int[] sort(int[] array){
        int temp=0;
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]) {
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }

//        for(int element: array){
//            System.out.print(element+" ,");
//        }

        return array;
    }

    public static void main(String args[]){
        int[] array= {43,60,20,1,0,99,21,33,40};

        BubbleSort bs = new BubbleSort();
        array = bs.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
