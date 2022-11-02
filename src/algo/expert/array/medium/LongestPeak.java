package algo.expert.array.medium;

/**
 * Given an array return the length of the longest peak.
 * A peak is defined as adjacent integers that are strictly increasing till it
 * reaches a peak and then becomes strictly decreasing.
 * Ex: [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
 * Longest peak is [0, 10, 6, 5, -1, -3] i.e of length 6
 */
public class LongestPeak {
    public static int longestPeak(int[] array) {

        int longestPeakLength = 0;


        int i =1;
        while(i <array.length-1){
            boolean isPeak = array[i]>array[i-1] && array[i]> array[i+1] ;

            if(!isPeak){
                i+=1;
                continue;
            }

            int leftIdx = i-2;
            int rightIdx = i+2;

            while(leftIdx>=0 && array[leftIdx]< array[leftIdx+1]){
                leftIdx-=1;
            }

            while(rightIdx<=array.length-1 && array[rightIdx]< array[rightIdx-1]){
                rightIdx+=1;
            }

            int peakLength = rightIdx-leftIdx-1;
            if(peakLength>longestPeakLength){
                longestPeakLength = peakLength;
            }
            i = rightIdx;


        }

        return longestPeakLength;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(input));
    }
}
