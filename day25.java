import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

/**
 * day25
 */
public class day25 {


    // 2385. Amount of Time for Binary Tree to Be Infected
    public void convert(TreeNode current, int parent, Map<Integer, List<Integer>> adj) {
        if (current == null) {
            return;
        }

        if (parent != -1) {
            adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(parent);
        }

        if (current.left != null) {
            adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(current.left.val);
        }
        if (current.right != null) {
            adj.computeIfAbsent(current.val, k -> new ArrayList<>()).add(current.right.val);
        }
        convert(current.left, current.val, adj);
        convert(current.right, current.val, adj);
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        convert(root,-1,adj);

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int minutes = 0;

        while (!que.isEmpty()) {
            int n = que.size();

            while (n-- > 0) {
                int curr = que.poll();

                for (int ngbr : adj.getOrDefault(curr, Collections.emptyList())) {
                    if (!visited.contains(ngbr)) {
                        que.add(ngbr);
                        visited.add(ngbr);
                    }
                }
            }
            minutes++;
        }

        return minutes - 1;
    }

    // 8. String to Integer (atoi)
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
        s = s.strip();
        if(s.length()==0) return 0;
        int sign = 0;
        if(Character.isDigit(s.charAt(0))) sign = 1;
        else if(s.charAt(0)=='-'){
            sign = -1;
            s = s.substring(1);
        } 
        else if(s.charAt(0)=='+') {
            sign = 1;
            s = s.substring(1);
        }
        
        long ans = 0;

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)) break;
            ans = ans*10 +(ch-'0');

            if(ans*sign<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(ans*sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }


        return sign*(int) ans;
    }


    // 2042. Check if Numbers Are Ascending in a Sentence
    public boolean areNumbersAscending(String s) {
        boolean ans = true;
        int prev = -1;
        for(int i = 0 ;i<s.length();i++){

            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                
                int local = ch-'0';
                int start = i+1;
                while(start<s.length() && Character.isDigit(s.charAt(start))){
                    local = local*10 + s.charAt(start)-'0';
                    start++;
                    i++;
                }
              //  System.out.println(local);
                if(prev==-1){
                    prev = local;
                    continue;
                }else{
                    if(local<=prev) return false;
                    else{
                        prev = local;
                    }
                }
            }

        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println("let us start!");
        String a = "100";
        System.out.println();
    }
}