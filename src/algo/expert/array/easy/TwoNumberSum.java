package algo.expert.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
Given a nonempty array of distinct integers and a number representing
the target sum,  return an array of any two numbers in the input that sum up to the target sum.
If no match return empty.
 */
//AlgoExpert
public class TwoNumberSum {

    //Using bruteforce
    //O(n^2) time, O(1) space
    public static int[] twoNumberSumBrute(int[] array, int targetSum){
        for(int i=0; i< array.length; i++){
            for(int j=i+1; j<array.length;j++){
                if(array[i]+array[j] == targetSum){
                    return new int[]{array[i], array[j]};
                }
            }

        }
        return new int[0];
    }
    //Using HashSet
    //O(n) time, O(n) space
    public static int[] twoNumberSumSet(int[] array, int targetSum){
        Set<Integer> visited =  new HashSet<>();
        for (int num: array){
            if(visited.contains(targetSum-num)){
                return new int[]{targetSum-num, num};
            }
            visited.add(num);
        }
        return new int[0];
    }

    //Using Sort
    //O(nlogn(n)) time, o(1) space
    public static int[] twoNumberSumUsingSort(int[] array, int targetSum){
        Arrays.sort(array);
        int i=0, j=array.length-1;
        while( i< j){

                if(array[i]+array[j] == targetSum){
                    return new int[]{array[i], array[j]};
                }else if(array[i]+array[j] > targetSum){
                    j--;
                }else{
                    i++;
                }
            }

        return new int[0];
    }

    public static int[] twoNumberSumUsingThread(int[] arr, int targetSum){
        int cores =  Runtime.getRuntime().availableProcessors();
        Set<Integer> values = ConcurrentHashMap.newKeySet();
        Searcher.foundValue = null;
        Searcher[] searchers = new Searcher[cores];
        int interval = 0;
        int intervalLength =  arr.length/cores;
        while(interval<cores-1){
            searchers[interval] = new Searcher(arr, interval*intervalLength, interval*(intervalLength+1) - 1, values, targetSum, interval+1 )  ;
            interval++;
        }
        searchers[cores - 1] = new Searcher(arr, interval * intervalLength, arr.length - 1, values, targetSum, interval + 1);
        Arrays.stream(searchers).forEach(Searcher::start);

        Arrays.stream(searchers).forEach(searcher -> {
            try {
                searcher.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;
        });

        if(Searcher.foundValue!=null){
            return new int[]{Searcher.foundValue, targetSum-Searcher.foundValue};
        }else{
            return new int[0];
        }
    }
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        int[] arr =  new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        //printArray(twoNumberSumBrute(arr, 10));
        //printArray(twoNumberSumSet(arr, 10));
        //printArray(twoNumberSumUsingSort(arr, 10));
        printArray(twoNumberSumUsingThread(arr, 10));
    }


}

class Searcher extends Thread {
    static Integer foundValue;
    int[] array;
    int start, end;
    Set<Integer> values;
    int targetSum;
    int threadNum;
    public Searcher(int[] array, int start, int end, Set<Integer> values, int targetSum, int threadNum){
        this.array = array;
        this.start = start;
        this.end = end;
        this.values = values;
        this.targetSum = targetSum;
        this.threadNum = threadNum;
    }

    public synchronized void setFoundValue(int value){
        foundValue = value;
    }

    @Override
    public void run() {
        while(start<end && foundValue==null){
            if(values.contains(targetSum - array[start])){
                setFoundValue(array[start]);
            }
            values.add(array[start]);
            start++;
        }

    }
}
