package algo.expert.recursion.veryhard;

/**
 * Given a number return the number of possible binary topologies that can be created with exactly n nodes
 * note: when n=0 or 1 it is 1.
 */
public class BinaryTreeTopologies {

    public static int numberOfBinaryTreeTopologies(int n) {
        if(n==1){
            return 1;
        }
        int topologies = 0;
        for(int l =0; l<n; l++){
            int r = n-l-1;
            int leftTop = numberOfBinaryTreeTopologies(l);
            int rightTop = numberOfBinaryTreeTopologies(r);
            topologies += leftTop*rightTop;
        }
        return topologies;
    }

    //using Memoization
    //O(n^2) time O(n) space
    public static int numberOfBinaryTreeTopologies2(int n){
        int[] tops = new int[n+1];
        tops[0] =1;
        return numberOfBinaryTreeTopologies(n, tops);
    }
    public static int numberOfBinaryTreeTopologies(int n, int[] tops) {
        if(tops[n]>0){
            return tops[n];
        }
        int topologies = 0;
        for(int l =0; l<n; l++){
            int r = n-l-1;
            int leftTop = numberOfBinaryTreeTopologies(l, tops);
            int rightTop = numberOfBinaryTreeTopologies(r, tops);
            topologies += leftTop*rightTop;
        }

        tops[n]= topologies;
        return topologies;
    }

    //using loop
    //O(n^2) time O(n) space
    public static int numberOfBinaryTreeTopologies3(int n) {

        int[] tops = new int[n+1];
        tops[0] =1;
        for(int i =1;i<=n; i++){
            int topologies = 0;
            for(int l =0; l<i; l++){
                int r = i-l-1;
                int leftTop = numberOfBinaryTreeTopologies3(l);
                int rightTop = numberOfBinaryTreeTopologies3(r);
                topologies += leftTop*rightTop;
            }

            tops[i]= topologies;
        }

        return tops[n];
    }


    public static void main(String[] args) {
        System.out.println(numberOfBinaryTreeTopologies(3));
    }
}
