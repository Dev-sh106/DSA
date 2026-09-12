class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        int[] patternfreq=new int[26];
        int[] windowfreq=new int[26];

        if(m>n){
            return ans;
        }

        for(char ch: p.toCharArray()){
            patternfreq[ch-'a']++;
        }
        for(int i=0;i<m;i++){
            windowfreq[s.charAt(i)-'a']++;
        }

        if(Arrays.equals(patternfreq,windowfreq)){
            ans.add(0);
        }

        for(int i=m;i<n;i++){
            windowfreq[s.charAt(i-m)-'a']--;
            windowfreq[s.charAt(i)-'a']++;
            if(Arrays.equals(patternfreq,windowfreq)){
                ans.add(i-m+1);
            }
        }
        return ans;
    }
}