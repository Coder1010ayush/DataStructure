package Recursion;

import java.util.ArrayList;

public class workingWithString {
    public static String remove(String str,char ch,String ans){
        if(str.isEmpty()){
            return ans;
        }
        if(str.charAt(0)!= ch){
            ans += str.charAt(0);
        }
        return remove(str.substring(1),ch,ans);
    }

    public static void subset(String str,String sub){
        if(str.isEmpty()){
            System.out.println(sub);
            return;
        }
        subset(str.substring(1),sub);
        subset(str.substring(1),sub+=str.charAt(0));
    }

    public static String longestMathcing(String str,String ans){
        if(str.isEmpty()){
            return ans;
        }
        if(!ans.contains(""+str.charAt(0))){
           ans += str.charAt(0)+"";

        }
        return longestMathcing(str.substring(1),ans);

    }
    public static void permutation(String str,String st){
        if(str.isEmpty()) {
            System.out.println(st);
            return;
        }
            String ch = str.charAt(0)+"";
            for (int i = 0; i <= st.length(); i++) {
               String one = st.substring(0,i);
               String two = st.substring(i,st.length());
               permutation(str.substring(1),one+ch+two);

            }

    }

   public static ArrayList<String> subseq(String given,String ans){
        if(given.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(ans.length()==0) list.add("{}");
            else list.add(ans);
            return  list;
        }

        char ch = given.charAt(0);
        ArrayList<String> one = subseq(given.substring(1),ans+ch);
        ArrayList<String> two = subseq(given.substring(1),ans);
        one.addAll(two);
        return one;
   }

    public static ArrayList<String> subsequence(String given,String ans,ArrayList<String> res){
        if(given.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(ans.length()==0) list.add("{}");
            else list.add(ans);
            return  list;
        }

        char ch = given.charAt(0);
        ArrayList<String> one = subseq(given.substring(1),ans+ch);
        ArrayList<String> two = subseq(given.substring(1),ans);
        one.addAll(two);
        res.addAll(one);
        return res;
    }

    public static void main(String[] args) {
//        ArrayList<String> res = new ArrayList<>();
//        //res = subseq("abc","");
//        subsequence("abc","",res);
//        System.out.println(res);
        String ans = "ved";
        System.out.println(ans.contains("ev"));
    }


}
