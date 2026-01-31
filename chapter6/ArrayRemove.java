package chapter6;

public class ArrayRemove extends Target{
    public ArrayRemove(int arr[], java.util.ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }
    //indicesOrnums is ignored!
    //removing the first 20,000 items from array 
    // returns the number of items removed 
    @Override
    public int method(int[] indicesOrnums) {
       int result = 0;
       int smallerarray[] = new int[arr.length - 20_000];
       for (int i = 20_000; i < arr.length; i++) {
           smallerarray[i - 20_000] = arr[i];
           result += arr[i];
       }
       return result;
    }
    
}
