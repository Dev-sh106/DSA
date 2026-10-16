class Solution {
    class Pair{
        int first;
        String second;
        Pair(int f,String s){
            this.first=f;
            this.second=s;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        int n=words.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first){
                    return a.first-b.first;
                }
                return b.second.compareTo(a.second);
            }
        );
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        for(String str: mp.keySet()){
            String ele=str;
            int freq=mp.getOrDefault(ele,0);
            Pair curr=new Pair(freq,ele);
            if(pq.size()<k){
                pq.add(curr);
                continue;
            }
           Pair top = pq.peek();

            if (curr.first < top.first ||
                (curr.first == top.first &&
                curr.second.compareTo(top.second) > 0)) {
                    continue;
                }
            pq.poll();
            pq.add(curr);
        }
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.addFirst(pq.peek().second);
            pq.poll();
        }
        return ans;
    }
}