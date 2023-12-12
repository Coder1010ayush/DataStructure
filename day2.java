package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;

public class day2 {

    // LeetCode 1464 
    public int maxProduct(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] arr = nums.clone();
        Arrays.sort(arr);
        if(arr.length==2){
            return (arr[1]-1)*(arr[0]-1);
        }
        int f1 = arr[arr.length-1];
        int f2 = arr[arr.length-2];
        int ans = 0;
        int idx1 = -1;
        int idx2 = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==f1){
                idx1 = i;
            }
            if(nums[i]==f2){
                idx2 = i;
            }
        }
        ans = (nums[idx1]-1)*(nums[idx2]-1);
        
        return ans;
    }


    // LeetCode 2644
    private static int maxDivScore(int[] nums, int[] divisors) {
        int ans = 0;
        int local_count = 0;
        int maxima = -1;
        Arrays.sort(divisors);
        for(int x : divisors){
            local_count = 0;
            for(int y : nums){
                if(y%x==0) local_count++;
            }
            if(local_count>maxima){
                maxima = local_count;
                ans = x;
            }
        }
        if(ans != 0) return ans;
        ans = Integer.MAX_VALUE;
        for (int i : divisors) {
            ans = Math.min(ans, i);
        }
        return ans;
    }

    // LeetCode 109
    private static TreeNode helper(ArrayList<Integer> arr,int start,int end){
        if(start> end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = helper(arr, start, mid);
        root.right = helper(arr, mid+1, end);
        return root;
    }

    private static TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        TreeNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        int start = 0;
        int end = arr.size()-1;
        TreeNode tree = helper(arr,start,end);
        return tree;
    }


    // Leetcode 1018
    private static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int x = nums[0];
        if(x%5==0) ans.add(true);
        else ans.add(false);

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                x = x*2 +1;
            }else{
                x = x*2;
            }
            if(x%5 ==0) ans.add(true);
            if(x%5 != 0) ans.add(false);
            x = x%5 ;
        }
        return ans;

    }

    // another way to do this problem
    private static List<Boolean> prefix1(int[] nums){
        int val = 0;
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i=0;i<nums.length;i++){
            val = (val*2+nums[i])%5;
            if(val==0) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }


    // LeetCode 173. Binary Search Tree Iterator

    class BSTIterator {
        private ArrayList<Integer> arr;
        private int count= 0;

        public void inOrderTraversal(TreeNode root,ArrayList<Integer> sor){

            if(root==null) return;
            inOrderTraversal(root.left, sor);
            sor.add(root.val);
            inOrderTraversal(root.right, sor);

        }

        public BSTIterator(TreeNode root) {
            ArrayList<Integer> sor = new ArrayList<>();
            inOrderTraversal(root,sor);
            arr = sor.clone();
        }
        
        public int next() {
            
                int ans = arr.get(count);
                count++;
                return ans;    
            
        }
        
        public boolean hasNext() {
            if(count==arr.size()) return false;
            return true;
        }
    }

    // Leetcode : 341. Flatten Nested List Iterator
    public class NestedIterator implements Iterator<Integer> {
        private ArrayList<Integer> list = new ArrayList<>();
        private int idx = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            for(int i=0;i<nestedList.size();i++){
                ripel(nestedList.get(i));

            }
        }
        public void ripel(NestedInteger f1){
            if(f1.isInteger()){
                list.add(f1.getInteger());
            }else{
                for(NestedInteger i:f1.getList()){
                    ripel(i);
                }
            }
        }
    
        @Override
        public Integer next() {
            return list.get(idx++);
        }
    
        @Override
        public boolean hasNext() {
            if(idx>= list.size()) return false;
            return true; 
        }
    }
    
    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList);
     * while (i.hasNext()) v[f()] = i.next();
     */


     // LeetCode : 284. Peeking Iterator
     class PeekingIterator implements Iterator<Integer> {
        private ArrayList<Integer> list = new ArrayList<>();
        private int idx = 0;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while(iterator.hasNext()){
                list.add(iterator.next());
            }
        }
        
        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {

            return list.get(idx2);
        }
        
        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.get(idx++);
        }
        
        @Override
        public boolean hasNext() {
            if(idx>=list.size()) return false;
            return true;
        }
    }

    // LeetCode : 2455. Average Value of Even Numbers That Are Divisible by Three
    private static int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        int avg = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%6==0){
                sum += nums[i];
                count++;
            }
        }
        if(count==0) return 0;
        avg = sum/count;
        return avg;
    }

    // LeetCode 2593
    private static int findMin(int[] nums){
        int mini = Integer.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<nums.length;i++){
            if(mini>nums[i] && nums[i] != 0){
                idx = i;
                mini = Math.min(mini, nums[i]);
            }
        }
        return idx;
    }
    private static long findScore(int[] nums) {
        int[] arr = nums.clone();
        int count = 1;
        long sum = 0;
        int fmin = findMin(arr);
        sum += arr[fmin];
        arr[fmin] = 0;
        if(fmin==0){
            arr[1] = 0;
            count++;
        }
        if(fmin==arr.length-1 &&fmin != 0) {
            arr[fmin-1] = 0;
            count++;
        }
        while(count<=arr.length){
            int fmin1 = findMin(arr);
            if(fmin1==0){
                arr[1] = 0;
                count++;
            }
            if(fmin1 == arr.length-1 && fmin1 != 0){
                arr[fmin-1] = 0;
                count++;
            }
            sum += arr[fmin1];
            arr[fmin1] = 0;
            count++;
        }
        return sum;
    }

    // 53. Maximum Subarray
    private static int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int ans = Integer.MIN_VALUE;
        int extra = 0;
        for(int num : nums){
            extra += num;
            ans = Math.max(ans,extra);
            extra = Math.max(extra,0);
        }
        return ans;
    }
    // LeetCode 1837. Sum of Digits in Base K
    private static int calculate_sum(int x){
        int sum =0;
        while(x>0){
            int rem = x%10;
            sum += rem;
            x = x/10;
        }
        return sum;
    }

    private static int calculate_sum_String(String str){
        int sum = 0;
        for(int i=0;i<str.length();i++){
            int a = str.charAt(i)-'0';
            sum += a;
        }
        return sum;
    }
    private static String convertBase(int n,int k,String new_var){

        if(n<=0) return new_var;
        int a = n%k;
        new_var = new_var.concat(a+"");
        return convertBase(n/k, k, new_var);

    }
    private static int sumBase(int n, int k) {
        String st = "";
        String str = convertBase(n, k, st);
        int ans = calculate_sum_String(str);
        return ans;
    }
    
    // LeetCode : 1838. Frequency of the Most Frequent Element
    private static long[] prefixSum(int[] nums){
        long[] arr = new long[nusm.length];
        arr[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            arr[i] = arr[i-1]+nums[i];
        }
        return arr;
    }

    private static int bSearch(int[] nums,int k,int target_idx,long[] prefix){
        int result = 0;
        int l = 0;
        int r = target_idx;
        while(l<=r){
            int mid = l+(r-l)/2;
            long count = target_idx-mid+1;
            long sum_of_window = count*nums[target_idx];
            long current_sum = prefix[target_idx]-prefix[mid]+nums[mid];
            long remaining = sum_of_window-current_sum;
            if(remaining>k){
                l = mid+1;
            }else{
                result = mid;
                r = mid-1;
            }
        }
        return (int) target_idx-result+1;
    }

    private static int maxFrequency(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        long[] prefix = prefixSum(nums);
        for(int i=0;i<nums.length;i++){
            int res = bSearch(nums,k,i,prefix);
            ans = Math.max(ans, res);
        }
        return ans;
    }
    // 2150. Find All Lonely Numbers in the Array
    private static List<Integer> findLonely(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mapp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!mapp.containsKey(nums[i])){
                mapp.put(nums[i], 1);
            }
            else{
                int  x = mapp.get(nums[i]);
                mapp.remove(nums[i]);
                mapp.put(nums[i], x+1);
            }
        }
        for(int i=0;i<nums.length;i++){
            int x = nums[i];
            int n1 = x+1;
            int n2 = x-1;
            if(mapp.get(x)==1){
                if(!mapp.containsKey(n1) && !mapp.containsKey(n2)){
                    ans.add(nums[i]);
                }
            }
        }
        
        return ans;
    }

    // 2643. Row With Maximum Ones
    private static int[] rowAndMaximumOnes(int[][] mat) {
        int mini_row = Integer.MAX_VALUE;
        int max_count = Integer.MIN_VALUE;
        for(int row = 0;row<mat.length;row++){
            int[] a = mat[row];
            int count = 0;
            for(int i=0;i<a.length;i++){
                if(a[i]==1){
                    count++;
                }
            }
            if(max_count<count){
                max_count = count;
                mini_row = row;
            }
            if(max_count == count){
                mini_row = Math.min(row,mini_row);
            }


        }
        int[] ans = {mini_row,max_count};
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,5,6};
      //  System.out.println(Arrays.toString(arr));
        // String a = "";
        // convertBase(16,2,a);
        // System.out.println(convertBase(16,2,a));
        System.out.println('9'-'0');
        
    }
}
