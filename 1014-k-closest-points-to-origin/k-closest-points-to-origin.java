class Solution {
    class Pair{
        int x;
        int y;
        int dist;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
            this.dist=x*x+y*y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                return b.dist-a.dist;
            }
        );
        for(int[] point:points){
            pq.add(new Pair(point[0],point[1]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            Pair curr=pq.poll();
            ans[i][0]=curr.x;
            ans[i][1]=curr.y;
        }
        return ans;
    }
}