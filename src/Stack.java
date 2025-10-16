public class Stack {
    public static void main(String[] args) {
        Stacker nums = new Stacker();
        nums.push(10);
        nums.push(20);
        System.out.println(nums.pop());
        nums.push(30);
        nums.push(50);
        nums.push(40);
        nums.push(60);
        System.out.println(nums.peek());
        nums.printStack();
    }
}
