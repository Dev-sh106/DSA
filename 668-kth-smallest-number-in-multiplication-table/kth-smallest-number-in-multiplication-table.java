class Solution {
    public int func(int m,int n,int guess){
        // int row=m;int col=1;
        // int count=0;
        // while(row>=0&& col<n){
        //     if(row*col<=guess){
        //         count=count+row;
        //         col++;
        //     }else{
        //         row--;
        //     }
        // }
        // return count;
          int count = 0;

        for (int row = 1; row <= m; row++) {
            count += Math.min(n, guess / row);
        }

        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low=1,high=m*n;
        int res=-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            int ans=func(m,n,guess);
            if(ans<k){
               low=guess+1;
            }else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
}