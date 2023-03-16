package grokking.twopointers.challenge;

public class StringWithBackSpaceCompare {
    //This is bruteforce, make final String applying backspace and then compare
    public static  boolean compareStringsWithBackSpace(String str1, String str2){
    if(stringAfterBackSpace(str1).equals(stringAfterBackSpace(str2)))
        return true;

    return false;
    }
    public static String stringAfterBackSpace(String str){
        int currIdx=0;
        String finalString = "";
        while(currIdx<str.length()){
            char c = str.charAt(currIdx);
            Character next =null;
            currIdx++;
            if(currIdx<str.length()){
                next = str.charAt(currIdx);
            }
            if(next==null || next!='#'){
                finalString+=c;
            }else{
                currIdx++;
            }

        }
        System.out.println(finalString);
        return finalString;
    }

    /**
     * Start from end keep comparing for valid characters
     *
     */
    public static  boolean compareStringsWithBackSpace1(String str1, String str2){
        int idx1 = str1.length()-1;
        int idx2 = str2.length()-1;
        while(idx1>=0 && idx2>=0){
            idx1 = getNextValidCharIndex(str1, idx1);
            idx2 = getNextValidCharIndex(str2, idx2);
            if(idx1 < 0 && idx2 < 0){
                return true;
            }
            if(idx1<0 || idx2 <0){
                return false;
            }
            if(str1.charAt(idx1)!=str2.charAt(idx2)){
                return false;
            }
            idx1--;
            idx2--;
        }
        return true;

    }

    public static int getNextValidCharIndex(String str, int idx){
        int noOfBackSpace = 0;
        while(idx>=0){
            if(str.charAt(idx) == '#'){
                noOfBackSpace++;

            }else if(noOfBackSpace>0){
                noOfBackSpace--;

            }else{
                break;
            }
            idx --;
        }
        return idx;
    }
    public static void main(String[] args) {
        System.out.println(compareStringsWithBackSpace1("xy#z","xzz#"));
    }
}
