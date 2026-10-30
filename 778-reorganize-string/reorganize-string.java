class Solution {
    class Pair{
        int first;
        char second;
        Pair(int f,char s){
            this.first=f;
            this.second=s;
        }
    }
    public String reorganizeString(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)-> b.first-a.first
        );
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                pq.add(new Pair(arr[i],(char)(i+'a')));
            }
        }
        StringBuilder sb=new StringBuilder();
        Pair prev=null;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            sb.append(curr.second);
            curr.first--;
            if(prev!=null && prev.first>0){
                pq.add(prev);
            }
            prev=curr;
        }
        if(sb.length()!=s.length()){
            return "";
        }
        return sb.toString();
    }
}