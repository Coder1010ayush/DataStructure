package Leetcode;
import java.util.*;
public class day35 {

    public String frequencySort(String s) {
        if(s.length()==0 || s.length()==1) return s;
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(treeMap.containsKey(ch)){
                int a = treeMap.get(ch);
                treeMap.put(ch,a+1);
            }
            else{
                treeMap.put(ch,1);
            }
        }

        Comparator<Character> valueComparator = (key1, key2) -> {
            int valueCompare = treeMap.get(key2).compareTo(treeMap.get(key1));
            return valueCompare == 0 ? 1 : valueCompare;
        };

        TreeMap<Character, Integer> sortedTreeMap = new TreeMap<>(valueComparator);
        sortedTreeMap.putAll(treeMap);
        String ans = "";
        for (Map.Entry<Character, Integer> entry : sortedTreeMap.entrySet()) {
            char ch = entry.getKey();
            int a = entry.getValue();
            for(int i=0;i<a;i++){
                ans = ans + ch+"";
            }
        }
        return ans;

    }



    public static void main(String[] args) {
        // Creating a TreeMap
        TreeMap<Character, Integer> treeMap = new TreeMap<>();

        // Adding elements to the TreeMap
        treeMap.put('a', 10);
        treeMap.put('b', 5);
        treeMap.put('c', 8);
        treeMap.put('d', 12);

        // Displaying the original TreeMap
        System.out.println("Original TreeMap: " + treeMap);

        // Sorting the TreeMap by values using a custom comparator
        Comparator<Character> valueComparator = (key1, key2) -> {
            int valueCompare = treeMap.get(key2).compareTo(treeMap.get(key1));
            return valueCompare == 0 ? 1 : valueCompare;
        };

        TreeMap<Character, Integer> sortedTreeMap = new TreeMap<>(valueComparator);
        sortedTreeMap.putAll(treeMap);

        // Displaying the sorted TreeMap by values
        System.out.println("Sorted TreeMap by values: " + sortedTreeMap);
        
        
    }
}
