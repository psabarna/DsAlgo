package algo.expert.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class DivTags {
    public static ArrayList<String> generateDivTags(int numberOfTags) {
        // Write your code here.
        ArrayList<String> tags = new ArrayList<>();
        generateDivTags(numberOfTags,  numberOfTags, "",  tags);
        return tags;
    }

    public static void generateDivTags(int tagsToOpen, int tagsToClose, String curr, ArrayList<String> tags) {
        if(tagsToOpen==0 && tagsToClose==0){
            tags.add(curr);
        }
        if(tagsToOpen>0){
            generateDivTags(tagsToOpen-1,  tagsToClose, curr+"<div>",  tags);
        }
        if(tagsToClose>0 && tagsToClose>tagsToOpen){
            generateDivTags(tagsToOpen,  tagsToClose-1, curr+"</div>",  tags);
        }
    }
    public static void main(String[] args) {
        List<String> tags = generateDivTags(3);
        for(String tag: tags){
            System.out.println(tag);
        }
    }
}
