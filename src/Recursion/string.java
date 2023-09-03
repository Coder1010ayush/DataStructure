package Recursion;

public class string {
    public static void main(String[] args) {
        String str = "ayusha";
     //   System.out.println(skipCharacter(str,0,""));
        System.out.println(skipCharacter(str,0,""));
    }
    public static String skipCharacter(String str,int i,String ans){
        if(i==str.length()) return ans;
        char ch = str.charAt(i);
        if(ch!='a') {
            ans += ch;
        }
        return skipCharacter(str,i+1,ans);
    }

}
