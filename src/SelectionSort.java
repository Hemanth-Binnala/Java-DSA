public class SelectionSort {
    public static void main(String[] args) {
        int nums[] = {8,10,33,6,25,7,5,9,20};
        int temp = 0;
        int minIndex = -1;

        for(int i=0;i<nums.length-1;i++){
            minIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[minIndex] > nums[j]){
                    minIndex = j;
                }
            }
            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}
