class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)
                return a.first-b.first;
                return a.second-b.second;
            }
        );
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        for(int num: mp.keySet()){
            int element=num;
            int freq=mp.getOrDefault(num,0);
            Pair curr=new Pair(freq,element);
            if(pq.size()<k){
                pq.add(curr);
                continue;
            }
            if(curr.first<pq.peek().first){
                continue;
            }
            pq.poll();
            pq.add(curr);
        }
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.peek().second;
            pq.poll();
        }
        return arr;
    }
}