public class BubbleSort {
    public static void main(String[] args) {
        int nums[] = {23,43,1,9,45,30,6,7,31};
        int temp = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j] > nums[j+1]){
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                }       
            }
        }
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}
