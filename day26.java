import java.util.ArrayList;

public class day26 {



    // Description 1026. Maximum Difference Between Node and Ancestor

    private int maxdiff = -1;
    private void calc_max_diff(TreeNode root,TreeNode child){
        if(root==null || child==null) return;

        maxdiff = Math.max(maxdiff,Math.abs(root.val-child.val));

        calc_max_diff(root,child.left);
        calc_max_diff(root,child.right);
    }

    private void helper(TreeNode root){

        if(root==null) return ;
        calc_max_diff(root,root.left);
        calc_max_diff(root,root.right);
    
        helper(root.left);
        helper(root.right);
    }

    // alternate way to solve it
    private int helper(TreeNode root,int minima , int maxima){

        if(root==null) {
            return Math.abs(minima-maxima);
        }

        minima = Math.min(root.val,minima);
        maxima = Math.max(root.val,maxima);

        int left = helper(root.left,minima,maxima);
        int right = helper(root.right,minima,maxima);

        return Math.max(left,right);

    }

    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return maxdiff;
    }


    private void dfs(TreeNode left,TreeNode right , int level){

        if(left == null || right == null) return;
        if(level %2 == 1){

            int value = left.val;
            left.val = right.val;
            right.val = value;
        }
        dfs(left.left,right.right,level+1);
        dfs(left.right,right.left,level+1);

    }

    

    // 2415. Reverse Odd Levels of Binary Tree
    public TreeNode reverseOddLevels(TreeNode root) {
       
            dfs(root.left,root.right,1);
        
        return root;
    }


    // 211. Design Add and Search Words Data Structure
    class WordDictionary {
        private ArrayList<String> dict;
        public WordDictionary() {
            this.dict = new ArrayList<>();
        }
        
        public void addWord(String word) {
            this.dict.add(word);
        }
        
        public boolean search(String word) {
            for(String str : this.dict){
                if(same(str,word)) return true;
            }
            return false;
        }

        private boolean same(String str,String word){
            if(str.length() != word.length()) return false;

            for(int i = 0;i<word.length();i++){
                
                if(word.charAt(i) != '.' && str.charAt(i) != word.charAt(i)) return false;

            }
            return true;
 
        }
    }


    // 1022. Sum of Root To Leaf Binary Numbers
    private int total(TreeNode root,int sum){

        if(root.left == null && root.right == null) return sum;

        sum = sum*2 + root.val;
        int x = total(root.left, sum);
        int y = total(root.right, sum);

        return x+y;

    }


    public int sumRootToLeaf(TreeNode root) {
        int ans = 0;
        total(root,ans);
        return 0;
    }



    private int total(TreeNode root,int sum){
        if(root==null) return 0;
        sum = sum*2 + root.val;
        if(root.left == null && root.right == null) return sum;
        int x = total(root.left, sum);
        int y = total(root.right, sum);

        return x+y;

    }


    public int sumRootToLeaf(TreeNode root) {
        
        return total(root,0);
       
    }

    public static void main(String[] args) {
        System.out.println("let us start");
        String str = "1010";
        System.out.println(Integer.valueOf(str,2));
    }
}
