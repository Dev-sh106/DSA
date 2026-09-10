class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        boolean odd=false;
        int res=0;
        for(char i:mp.keySet()){
            int val=mp.get(i);
            if(val%2==0){
                res+=val;
            }else{
                odd=true;
                res+=val-1;
            }
        }
        if(odd){
            return res+1;
        }else{
            return res;
        }
    }
}