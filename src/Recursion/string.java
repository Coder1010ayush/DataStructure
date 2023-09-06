package Recursion;

public class string {
    public static void main(String[] args) {
        String str = "ayusha";
     //   System.out.println(skipCharacter(str,0,""));
      //  System.out.println(skipCharacter(str,0,""));
      System.out.println(isPresent("", str, 0));
    }


    public static String isPresent(String up,String p,int i){
        if(p.isEmpty()) return up;

        String ch = p.charAt(i)+"";
        isPresent(up.concat(ch), p.substring(1), i+1);
        isPresent(up, p.substring(1), i+1);
        return up;
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
