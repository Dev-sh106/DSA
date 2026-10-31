class Solution {
    class Pair{
        int first;
        char second;
        Pair(int f,char s){
            this.first=f;
            this.second=s;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int l=tasks.length;
        HashMap<Character,Integer> freq=new HashMap<>();
        HashMap<Character,Integer> free=new HashMap<>();
        for(int i=0;i<l;i++){
            freq.put(tasks[i],freq.getOrDefault(tasks[i],0)+1);
            free.put(tasks[i],1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->b.first-a.first
        );
        for(char key: freq.keySet()){
            pq.add(new Pair(freq.get(key),key));
        }
        int seat=1;
        while(!pq.isEmpty()){
            List<Pair> pulled=new ArrayList<>();
            while(!pq.isEmpty()){
                Pair p=pq.poll();
                int fr=p.first;
                char child=p.second;
                if(free.get(child)<=seat){
                    if(p.first>1){
                        pq.add(new Pair(p.first-1,p.second));
                    }
                    free.put(p.second,seat+n+1);
                    break;
                }
                else{
                    pulled.add(p);
                }
            }
            for(int i=0;i<pulled.size();i++){
                pq.add(pulled.get(i));
            }
            seat++;
        }
        return seat-1;
    }
}