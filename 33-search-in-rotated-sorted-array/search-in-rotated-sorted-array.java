class Solution {
    public int search(int[] nums, int target) {
        // int pivot = findPivot(nums);
        // if (pivot == -1) {
        //     return binarySearch(nums, target, 0, nums.length - 1);
        // }
        // if (nums[pivot] == target) {
        //     return pivot;
        // }
        // if (target >= nums[0]) {
        //     return binarySearch(nums, target, 0, pivot - 1);
        // }
        // return binarySearch(nums, target, pivot + 1, nums.length - 1);

        int n=nums.length;
        int low=0,high=n-1;

        while(low<=high){
            int guess=low+(high-low)/2;
            if(nums[guess]==target){
                return guess;
            }
            if(nums[guess]>nums[n-1]){
                if(nums[guess]<target){
                    low=guess+1;
                }else{
                    if(nums[0]>target){
                        low=guess+1;
                    }else{
                        high=guess-1;
                    }
                }
            }else{
                if(nums[guess]>target){
                    high=guess-1;
                }else{
                    if(nums[n-1]>=target){
                        low=guess+1;
                    }else{
                        high=guess-1;
                    }
                }
            }
        }

    return -1;

    }

    // int findPivot(int[] nums) {
    //     int start = 0;
    //     int end = nums.length - 1;
    //     while (start <= end) {
    //         int mid = start + (end - start) / 2;
    //         if (mid < end && nums[mid] > nums[mid + 1]) {
    //             return mid;
    //         }
    //         if (mid > start && nums[mid] < nums[mid - 1])
    //             return mid - 1;
    //         if (nums[mid] <= nums[start]) {
    //             end = mid - 1;
    //         } else {
    //             start = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    // int binarySearch(int[] nums, int target, int low, int high) {
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         if (nums[mid] == target) {
    //             return mid;
    //         } else if (nums[mid] > target) {
    //             high = mid - 1;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

}
