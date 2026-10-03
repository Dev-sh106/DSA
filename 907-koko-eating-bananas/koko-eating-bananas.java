class Solution {
    public long hourFunc(int[] arr,int n, int speed){
        long hr=0;
        for(int i=0;i<n;i++){
            hr=hr+arr[i]/speed;
            if(arr[i]%speed!=0){
                hr++;
            }
        }
        return hr;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int max=piles[0];
        for(int i=1;i<n;i++){
            if(piles[i]>max)
            max=piles[i];
        }
        int low=1,high=max,res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            long hour=hourFunc(piles,n,guess);
            if(hour>h){
                low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
}