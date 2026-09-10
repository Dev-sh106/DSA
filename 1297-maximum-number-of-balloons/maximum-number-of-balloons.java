class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> have=new HashMap<>();
         HashMap<Character,Integer> need=new HashMap<>();
         for(int i=0;i<text.length();i++){
            have.put(text.charAt(i),have.getOrDefault(text.charAt(i),0)+1);
         }
         need.put('b',1);
         need.put('a',1);
         need.put('l',2);
         need.put('o',2);
         need.put('n',1);
        int res=Integer.MAX_VALUE;
        for(char i: need.keySet()){
            int fneed=need.getOrDefault(i,0);
            int fhave=have.getOrDefault(i,0);
            int times=fhave/fneed;
            res=Math.min(res,times);
        }
        return res;
    }
}