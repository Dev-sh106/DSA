class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int min_diff=Integer.MAX_VALUE;
        int res_sum=1;
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
            int sum=nums[i]+nums[left]+nums[right];
            int diff=Math.abs(target-sum);
            if(diff<min_diff){
                min_diff=diff;
                res_sum=sum;
            }
            if(target==sum){
                // left++;
                // right--;
                break;
            }else if(target<sum){
                right--;
            }else{
                left++;
            }
            }
        }
        return res_sum;
    }
}