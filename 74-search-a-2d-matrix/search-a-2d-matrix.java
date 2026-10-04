class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int row=-1;
        // int low=0,high=matrix.length-1;
        // while(low<=high){
        //     int guess=low+(high-low)/2;
        //     if(matrix[guess][0]==target){
        //         return true;
        //     }else if(matrix[guess][0]<target){
        //         row=guess;
        //         low=guess+1;
        //     }else{
        //         high=guess-1;
        //     }
        // }
        // if(row==-1) return false;
        // int l=0,h=matrix[row].length-1;
        // while(l<=h){
        //     int mid=l+(h-l)/2;
        //     if(matrix[row][mid]==target){
        //         return true;
        //     }else if(matrix[row][mid]<target){
        //         l=mid+1;
        //     }else{
        //         h=mid-1;
        //     }
        // }
        // return false;

        //more optimize in which we use binary search only one time;
        int n=matrix.length,m=matrix[0].length;
        int low=0,high=n*m-1;
        while(low<=high){
            int guess=low+(high-low)/2;
            int row=guess/m,col=guess%m;
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                low=guess+1;
            }else{
                high=guess-1;
            }
        }
        return false;
    }
}