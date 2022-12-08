/**
 * Created on 2022-12-08
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description
 */
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        char[] ch=s.toCharArray();
        int maxLength=0;
        String maxStr="";
        for(int i=0;i<n-1;i++){
            if(expandFromCenter(i,i,ch,n)>maxLength){
                maxLength=expandFromCenter(i,i,ch,n);
                maxStr=s.substring(i-maxLength/2,i+maxLength/2+1);
            }
            if(expandFromCenter(i,i+1,ch,n)>maxLength){
                maxLength=expandFromCenter(i,i+1,ch,n);
                maxStr=s.substring(i+1-maxLength/2,i+1+maxLength/2);
            }
        }
        return maxStr;
    }
    private int expandFromCenter(int left,int right,char[] ch,int n){
        int cnt=0;
        if(left==right){
            cnt=-1;
        }
        while(left>=0 && right<n && ch[left]==ch[right]){
            cnt+=2;
            left--;
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}
