package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ArrayvsArrayListLab {

    protected static int listRandomAccess(int indices[], ArrayList<Integer> list) {
        int result = 0;
        for (int i = 0; i < indices.length; i++) {
            result += list.get(indices[i]);
        }
        return result;
    }
    

     
    public static void main(String[] args) throws IOException{
       /* long start = System.nanoTime();
        System.out.println("Hello, World!");
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println("println: " + elapsed + "ns");
        start = System.nanoTime();
        arrayTest(30_000);
        finish = System.nanoTime();
        elapsed = finish - start;
        System.out.println("arrayTest: " + elapsed + "ns"); */
        int arr[] = DataLoader.loadArray("numbers.txt");
        ArrayList<Integer> list = DataLoader.loadArrayList("numbers.txt");
        Random r = new Random();
        int indices[] = new int[100_000];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = r.nextInt(arr.length);
        }

        PrintWriter fileOut = new PrintWriter (new File("results.csv"));
        Target tests[] = new Target[8];
        double testAverages[] = new double[8];

        tests[0] = new ArrayRandom(arr, new ArrayList<>(list), "array,random_access");
        tests[1] = new ListRandom(arr, new ArrayList<>(list), "arraylist, random_access");
        tests[2] = new ArrayAppend(arr, new ArrayList<>(list), "array,append");
        tests[3] = new ListAppend(arr, new ArrayList<>(list), "arraylist, append");
        tests[4] = new ArrayInsert(arr, new ArrayList<>(list), "array,insert");
        tests[5] = new ListInsert(arr, new ArrayList<>(list), "arraylist, insert");
        tests[6] = new ArrayRemove(arr, new ArrayList<>(list), "array,remove");
        tests[7] = new ListRemove(arr, new ArrayList<>(list), "arraylist, remove");
       
        for (int i = 0; i < tests.length; i++) {
            Target target = tests[i];

            if (target != null){
                testAverages[i] = target.runTests(indices)/1000.0;
                target.WriteResults(fileOut);
            }
        }
    

        //output all the results use an ENUM
        if (testAverages[0]<testAverages[1]) {
            System.out.println("array wins: on random access " + testAverages[0]);
        } else {
            System.out.println("arraylist wins: on random access " + testAverages[1]);
        }
        if (testAverages[2]<testAverages[3]) {
            System.out.println("array wins: on append " + testAverages[2]);
        } else {
            System.out.println("arraylist wins: on append " + testAverages[3]);
        }
        if (testAverages[4]<testAverages[5]) {
            System.out.println("array wins: on insert " + testAverages[4]);
        } else {
            System.out.println("arraylist wins: on insert " + testAverages[5]);
        }
        if (testAverages[6]<testAverages[7]) {
            System.out.println("array wins: on remove  " + testAverages[6]);
        } else {
            System.out.println("arraylist wins: on remove " + testAverages[7]);
        }
        fileOut.close();
    }
}