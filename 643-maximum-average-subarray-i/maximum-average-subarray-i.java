class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        int low=0,high=k-1;
        for(int i=low;i<=high;i++){
            sum+=nums[i];
        }
        double avg=sum/k;
        while(high<nums.length){
            low++;
            high++;
            if(high>=nums.length){
                break;
            }
            sum-=nums[low-1];
            sum+=nums[high];
            avg=Math.max(avg,sum/k);
        }
        return avg;
    }
}