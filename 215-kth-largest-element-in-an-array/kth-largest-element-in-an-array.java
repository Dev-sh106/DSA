class Solution {
    public int findKthLargest(int[] nums, int k) {
       int n=nums.length;
    //   quickSort(nums,0,n-1);  
    //   return nums[n-k];
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    for(int i=n-1;i>=n-k;i--){
        pq.add(nums[i]);
    }
    for(int i=n-k-1;i>=0;i--){
        if(nums[i]<pq.peek()){
            continue;
        }
        pq.poll();
        pq.add(nums[i]);
    }
    return pq.peek();

    }
    // public int partition(int[]nums,int low,int high){
    //     int i=low-1,j=high+1,pivot=nums[low];
    //     while(true){
    //         do{
    //             i++;
    //         }while(nums[i]<pivot);
    //         do{
    //             j--;
    //         }while(nums[j]>pivot);
    //         if(i<j){
    //             int temp=nums[i];
    //             nums[i]=nums[j];
    //             nums[j]=temp;
    //         }else{
    //             break;
    //         }
    //     }
    //     return j;
    // }
    // public void quickSort(int []nums,int l,int h){
    //     if(l<h){
    //         int p=partition(nums,l,h);
    //         quickSort(nums,l,p);
    //         quickSort(nums,p+1,h);
    //     }
    // }
}