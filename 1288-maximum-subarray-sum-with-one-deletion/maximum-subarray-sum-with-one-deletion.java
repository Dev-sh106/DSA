class Solution {
    public int maximumSum(int[] arr) {
       int nodelete=arr[0];
       int onedelete=Integer.MIN_VALUE; 
       int ans=arr[0];
       for(int i=1;i<arr.length;i++){
        int prevnodelete=nodelete;
        int prevonedelete=onedelete;
        nodelete=Math.max(prevnodelete+arr[i],arr[i]);
        int v;
        if(prevonedelete==Integer.MIN_VALUE){
            v=arr[i];
        }else{
            v=prevonedelete+arr[i];
        }
        onedelete=Math.max(v,prevnodelete);
        ans=Math.max(ans,Math.max(onedelete,nodelete));
       }
       return ans;
    }
}