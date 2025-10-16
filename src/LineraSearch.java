public class LineraSearch {
            public static void main(String[] args) {
                int nums[] = {2,4,5,6,7,9};
                int target = 6;

                int r = linearSearch(nums,target);
                int r1 = binarysearch(nums, target,0,nums.length-1);
                if(r == -1){
                    System.out.println("Element not found");
                }
                else{
                    System.out.println("Element found at " + r +" " + r1);
                }
                
            }

            public static int linearSearch(int[] nums, int target) {
                for(int i=0;i<nums.length;i++){
                    if(nums[i]==target){
                        return i;
                    }
                }
                return -1;
            }

            public static int binarysearch(int[] nums, int target, int s, int l){
                if(s <= l){
                    int mid = (s+l)/2;
                    if(nums[mid] == target){
                    return mid;
                }
                else if(nums[mid] < target){
                    return binarysearch(nums, target, mid+1, l);
                }
                else{
                    return binarysearch(nums, target, s, mid-1);
                }
                }
                
                return -1;
            }
}
