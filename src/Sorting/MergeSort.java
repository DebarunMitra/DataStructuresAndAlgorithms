package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Arrays To List:
//List<Integer> list=Arrays.stream(intArray).boxed().collect(Collectors.toList());
//Arrays.stream(intArray):
// This will take input as an arrays (here intArray) and return a stream of elements present in array.
//.boxed() :
// Boxing and unboxing in java is conversion of primitive data type to Wrapper(reference data type) and
// vice-versa. now this methos boxed() works on stream of input data and return an stream of Integer
// after boxing each element in the stream to Integer.
//collect(Collectors.toList()):
//now that you have got stream of Integer from boxed() you need to store it to some collection.
// collect() works on stream of data and the paramter passed to it tells the type collections to
// which data of the stream should be mapped to. in your case it is list so Collector.toList() is used.


public class MergeSort {

    // TODO: merge leftArray and rightArray
   public static int[] merge(int[] leftArray, int[] rightArray) {
       int[] resultArray = {};

       // compare left and right arrays
       List<Integer> mergeList = new ArrayList<>();
       int rightIndex=0 ,leftIndex=0;

       while(rightIndex<rightArray.length && leftIndex<leftArray.length){
           if(leftArray[leftIndex]<rightArray[rightIndex]){
               mergeList.add(leftArray[leftIndex]);
               leftIndex++;
           }else {
               mergeList.add((rightArray[rightIndex]));
               rightIndex++;
           }
       }

       // TODO : merge the left over elements into the list
       List<Integer> remainingLeftValuesList =
               Arrays.stream(Arrays.copyOfRange(leftArray,leftIndex,leftArray.length)).boxed().collect(Collectors.toList());

       List<Integer> remainingRightValuesList =
               Arrays.stream(Arrays.copyOfRange(rightArray,rightIndex,rightArray.length)).boxed().collect(Collectors.toList());

       mergeList.addAll(remainingLeftValuesList);
       mergeList.addAll(remainingRightValuesList);

       return mergeList.stream().mapToInt(i->i).toArray();
    }

    public int[] sort(int[] array){

        if(array.length==1){
            return array;
        }

        // TODO : split array into rightArray and leftArray
        int arrayLen =array.length;

        int[] leftArray = Arrays.copyOfRange(array,0,(arrayLen+1)/2);
        int[] rightArray =  Arrays.copyOfRange(array,(arrayLen+1)/2,arrayLen);

        int[] leftSortedArray = sort(leftArray);
        int[] rightSortArray =  sort(rightArray);

        return merge(leftSortedArray, rightSortArray);
    }

    public static void main(String args[]){
        int[] array= {43,60,20,1,0,99,21,33,40};

        MergeSort ms = new MergeSort();
        array = ms.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
