package grokking.cyclicsort.easy;

public class CyclicSort {

    public static void sort(int[] objects){
        int i=0;
        while(i<objects.length){
            int num = objects[i];
            if(num != i+1){
                objects[i] = objects[num-1];
                objects[num-1] = num;
            }else{
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] objects = {3,1,5,4,2};
        sort(objects);
        for(int i : objects) {
            System.out.print(i+" ");
        }
    }
}
