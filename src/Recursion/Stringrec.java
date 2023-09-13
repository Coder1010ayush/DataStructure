package Recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Stringrec {

    public static void subsequence(String str,String ans){
        if(str.isEmpty()){
            
            System.out.print(ans+" ");
            return;
        }
        String ch = str.charAt(0)+"";
        subsequence(str.substring(1), ans+ch);
        subsequence(str.substring(1), ans);
    }
     public static void subsequence1(String str,String ans,ArrayList<String> result){
        if(str.isEmpty()){
            if(result.size()==0) result.add("null");
            result.add(ans);
            return;
        }
        String ch = str.charAt(0)+"";
        subsequence1(str.substring(1), ans+ch,result);
        subsequence1(str.substring(1), ans,result);
    }
    public static int numMatchingSubseq(String s, String[] words) {
        ArrayList<String> result = new ArrayList<>();
        
        subsequence1(s,"",result);
        int count =0;
        for(int i=0;i<words.length;i++){
            String str = words[i];
            for(int j=0;j<result.size();j++){
                if(str.equals(result.get(j))) count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
       System.out.println("hello world");
    }
    
}
