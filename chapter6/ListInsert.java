package chapter6;

public class ListInsert extends Target {
    public ListInsert(int arr[], java.util.ArrayList<Integer> list, String name) {
        super(arr, list, name);
    }

    @Override
    public int method(int[] indicesOrnums) {
        int sum = 0;
        int largerarray[] = new int[arr.length + indicesOrnums.length];
        for (int i = 0; i < indicesOrnums.length; i++) {
            largerarray[i] = indicesOrnums[i];
            sum += largerarray[i];
        }   
        for (int i = 0; i < arr.length; i++) {
            largerarray[i + indicesOrnums.length] = arr[i];
            sum += arr[i];
        }
        return sum;
    }

    
}
