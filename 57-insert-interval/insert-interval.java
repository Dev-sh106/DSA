class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int [][] arr=new int[n+1][2];
        boolean insert=false;
        int j=0;
        for(int i=0;i<n;i++){
            if(insert==false&&intervals[i][0]>=newInterval[0]){
                arr[j][0]=newInterval[0];
                arr[j][1]=newInterval[1];
                j++;
                insert=true;
            }
            arr[j][0]=intervals[i][0];
            arr[j][1]=intervals[i][1];
                j++;
        }
           if (!insert) {
            arr[j][0] = newInterval[0];
            arr[j][1] = newInterval[1];
            j++;
        }
        List<int[]>res=new ArrayList<>();
        int start1=arr[0][0];
        int end1=arr[0][1];
        for(int i=1;i<j;i++){
            int start2=arr[i][0];
            int end2=arr[i][1];
            if(end1>=start2){
                end1=Math.max(end1,end2);
                continue;
            }
            res.add(new int[]{start1,end1});
            start1=start2;
            end1=end2;
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }
}