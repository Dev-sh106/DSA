class Solution {
    public int findMin(int[] nums) {
    //     int pivot=findPivot(nums);
    //     if(pivot==-1){
    //         return nums[0];
    //     }
    //     int min=nums[0];
    //     int ans=binarySearch(nums,min,pivot+1,nums.length-1);
    //     if(min<ans)
    //     return min;
    //     return ans;
    // }
    // public int findPivot(int[] nums){
    //     int s=0;
    //     int e=nums.length-1;
    //     while(s<=e){
    //         int m=s+(e-s)/2;
    //         if(m<e&&nums[m]>nums[m+1])
    //         return m;
    //         if(m>s&& nums[m]<nums[m-1])
    //         return m-1;
    //         if(nums[m]<=nums[s])
    //         e=m-1;
    //         else s=m+1;
    //     }
    //     return -1;
    // }
    // public int binarySearch(int []nums,int min,int low,int high){
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         if(nums[mid]<min){
    //             min=nums[mid];
    //             high=mid-1;
    //         }else if(nums[mid]>min){
    //             high=mid-1;
    //         }
    //     }
    //     return min;
    int n=nums.length;
    int low=0,high=n-1,res=-1;
    while(low<=high){
        int guess=low+(high-low)/2;
        if(nums[guess]>nums[n-1]){
            low=guess+1;
        }else{
            res=guess;
            high=guess-1;
        }
    }
    return nums[res];
    }
}