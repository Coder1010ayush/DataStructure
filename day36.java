import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class day36 {

   public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> ans = new ArrayList<>();
       HashMap<String,ArrayList<String>> map = new HashMap<>();
       for(String s : strs){

           char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String abs = new String(ch);
            if(map.containsKey(abs)){
                ArrayList<String> list = map.get(abs);
                list.add(s);
                map.put(abs,list);
            }else{
                ArrayList<String> ls = new ArrayList<>();
                ls.add(s);
                map.put(abs,ls);
            }
       }
     //  System.out.println(map);
       for(String str : map.keySet()){
           ans.add(map.get(str));
       }

       return ans; 
    }
   

     public static void main(String[] args) {

         System.out.println("let us start");
         String s = "ayush";
         char[] arr = s.toCharArray();
         Arrays.sort(arr);
         String ans = new String(arr);
         System.out.println(ans);
         ArrayList<Integer> ls = new ArrayList<>(){
            {
               add(5);
               add(10);
            }
         };
         System.out.println(ls);
      }
}