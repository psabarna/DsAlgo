package algo.expert.recursion.easy;


import java.util.List;

/**
 * Given a special array find the product sum, The special array may contain array inside.
 * The sum of inside array are multiplied by their depth
 * Input: [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
 * Output: 12
 * Calculated as 5 + 2 + 2*(7+ -1) + 3 + 2*( 6 + 3*(-13+8) + 4)
 */
public class ProductSum {
    public static int productSum(List<Object> array) {
        // Write your code here.

        return sum(array, 1);
    }
    //O(n) time | O(d) space
    public static int sum(List<Object> array, int depth){
        int sum = 0;
        for(Object e: array){
            if(e instanceof List){
                List<Object> entry = (List<Object>) e ;
                sum += sum(entry, depth+1);
            }else{
                sum += (int) e;
            }

        }
        return depth * sum;
    }

    public static void main(String[] args) {
        List<Object> array = List.of(5, 2, List.of(7, -1), 3, List.of(6, List.of(-13, 8), 4));
        System.out.println(sum(array, 1));

    }
}
