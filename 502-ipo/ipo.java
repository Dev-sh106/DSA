class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f,int s){
            this.first=f;
            this.second=s;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        ArrayList<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(capital[i],profits[i]));
        }
        list.sort((a,b)->a.first-b.first);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int idx=0;
        while(k!=0){
            while(idx<n){
                if(list.get(idx).first>w){
                    break;
                }
                pq.add(list.get(idx).second);
                idx++;
            }
            if(pq.isEmpty()){
                return w;
            }
            w=w+pq.poll();
            k--;
        }
        return w;
    }
}