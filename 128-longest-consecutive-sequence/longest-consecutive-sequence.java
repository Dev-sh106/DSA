class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int n: nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        int c=0,maxc=0;
        for(int n: mp.keySet()){
       if(!mp.containsKey(n-1)){
        c=1;
        int i=n;
        while(mp.containsKey(i+1)){
            c++;
            i++;
        }
        maxc=Math.max(maxc,c);
       }
        }
        return maxc;
    }
}