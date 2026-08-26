class Solution {
    public int maxAbsoluteSum(int[] nums) {
    //    int currsum=nums[0];
    //    int maxsum=nums[0];
    //    int minend=nums[0];
    //    int minsum=nums[0];
    //    for(int i=1;i<nums.length;i++){
    //     currsum=Math.max(nums[i],currsum+nums[i]);
    //     maxsum=Math.max(maxsum,currsum);
    //     minend=Math.min(nums[i],minend+nums[i]);
    //     minsum=Math.min(minend,minsum);
    //    }
    //    return Math.max(maxsum,(Math.abs(minsum)));
    int bestmax=nums[0];
    int bestmin=nums[0];
    int ans=Math.abs(nums[0]);
    for(int i=1;i<nums.length;i++){
        int v1=bestmax+nums[i];
        int v2=bestmin+nums[i];
        int v3=nums[i];
        bestmax=Math.max(v1,v3);
        bestmin=Math.min(v2,v3);
        ans=Math.max(ans,Math.max(Math.abs(bestmax),Math.abs(bestmin)));
    }
    return ans;
    }
}