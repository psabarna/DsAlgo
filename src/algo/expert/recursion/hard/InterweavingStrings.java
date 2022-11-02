package algo.expert.recursion.hard;

/**
 * Write a function that takes three Strings and returns if third string can be formed by interweaving first two strings
 * Eg: "uuv-mca", "classy-students", "uuv-classy-mcastudents"
 * out put: True
 * note: Strings mantain their order in 3rd string
 */
public class InterweavingStrings {

    //With Recursion
    //O(2^(n+m))  time, O(n+m) space
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if(three.length()!= one.length()+two.length()){
            return false;
        }
        return helper(one, two, three, 0,0,0);
    }
    // With DP Memoization
    // O(n*m) time O(n*m)) space
    public static boolean interweavingStrings2(String one, String two, String three) {
        // Write your code here.
        if(three.length()!= one.length()+two.length()){
            return false;
        }
        Boolean[][] cache =  new Boolean[one.length()+1][two.length()+1];
        return helper2(one, two, three, 0,0,0, cache);
    }

    public static boolean helper2(String one, String two, String three, int idx1, int idx2, int idx3, Boolean[][] cache){
        if(cache[idx1][idx2]!=null){
            return cache[idx1][idx2];
        }
        if(idx3==three.length()){
            return true;
        }

        if(idx1<one.length() && one.charAt(idx1) == three.charAt(idx3)){
            cache[idx1][idx2] = helper2(one, two, three, idx1+1, idx2, idx3+1, cache);
            if(cache[idx1][idx2]) {
                return true;
            }
        }
        if(idx2<two.length() && two.charAt(idx2) == three.charAt(idx3)){
            cache[idx1][idx2] = helper2(one, two, three, idx1, idx2+1, idx3+1, cache);
            return cache[idx1][idx2];
            //return helper(two, one, three, idx2+1,idx1 , idx3+1);
        }
        cache[idx1][idx2] = false;
        return false;

    }

    public static boolean helper(String one, String two, String three, int idx1, int idx2, int idx3){
        if(idx3==three.length()){
            return true;
        }

        if(idx1<one.length() && one.charAt(idx1) == three.charAt(idx3)){
            if(helper(one, two, three, idx1+1, idx2, idx3+1))
                return true;
        }
        if(idx2<two.length() && two.charAt(idx2) == three.charAt(idx3)){
            return helper(one, two, three, idx1, idx2+1, idx3+1);
            //return helper(two, one, three, idx2+1,idx1 , idx3+1);
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(interweavingStrings("algoexpert", "your-dream-job", "your-algodream-expertjob" ));
    }
}
