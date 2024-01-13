import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class day28 {
    
    // 1347. Minimum Number of Steps to Make Two Strings Anagram
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> os = new HashMap<Character,Integer>();


        for(int i = 0;i<s.length();i++){

            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                int a = map.get(ch);
                map.put(ch,a+1);
            }else{
                map.put(ch,1);
            }

        }

        for(int i = 0;i<t.length();i++){

            char ch = t.charAt(i);
            if(os.containsKey(ch)) {
                int a = os.get(ch);
                os.put(ch,a+1);
            }else{
                os.put(ch,1);
            }

        }

        int cnt = 0;
        for(char ch : map.keySet()){

            if(os.containsKey(ch)){
                cnt += Math.abs(os.get(ch)-map.get(ch));
            }

            else{

                cnt += map.get(ch);

            }

        }

        for(char ch : os.keySet()){

            if(!map.containsKey(ch)){
                
                cnt+= os.get(ch);

            }

        }

        return cnt/2;

    }

    // 2186. Minimum Number of Steps to Make Two Strings Anagram II
    public int minSteps1(String s, String t) {
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        HashMap<Character,Integer> os = new HashMap<Character, Integer>();

        for(int i = 0;i<s.length();i++){

            char ch = s.charAt(i);
            if(map.containsKey(ch)){

                int a = map.get(ch);
                map.put(ch,a+1);

            }else{

                map.put(ch,1);

            }

        }

        for(int i = 0;i<t.length();i++){

            char ch = t.charAt(i);
            if(os.containsKey(ch)){

                int a = os.get(ch);
                os.put(ch,a+1);

            }else{

                os.put(ch,1);

            }

        }

        int cnt = 0;
        for(char ch : map.keySet()){

            if(os.containsKey(ch)){

                cnt += Math.abs(os.get(ch)-map.get(ch));

            }else{

                cnt += map.get(ch);

            }

        }


        for(char ch : os.keySet())
        {
            if(!map.containsKey(ch)) {

                cnt += os.get(ch);

            }

        }

        return cnt;

    }


    public static void main(String[] args) {
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(10);
        a.remove(a.get(a.size()-1));
        System.out.println(a);
        int b = a.get(0);
        System.out.println(b);
    }

}
