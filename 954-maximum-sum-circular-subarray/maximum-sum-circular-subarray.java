class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currmax=nums[0];
        int currmin=nums[0];
        int maxsum=nums[0];
        int minsum=nums[0];
        int totalsum=nums[0];
       
        for(int i=1;i<nums.length;i++){
            totalsum+=nums[i];
            currmax=Math.max(nums[i],currmax+nums[i]);
            currmin=Math.min(nums[i],currmin+nums[i]);

            maxsum=Math.max(currmax,maxsum);
            minsum=Math.min(currmin,minsum);
        }
        if(maxsum<0){
            return maxsum;
        }
      int finalmax=Math.max(maxsum,(totalsum-minsum));
      return finalmax;
    }
}