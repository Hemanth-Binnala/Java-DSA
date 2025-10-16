// import java.util.LinkedList; // inbuilt ; let's create our own linkedList in LinkedList.java

public class Linked {
    public static void main(String[] args) {
        
        LinkedList nums = new LinkedList();

        nums.add(5);
        nums.add(6);
        nums.add(9);
        nums.addFirst(7);
        nums.delete(9);

        // System.out.println(nums);

        nums.printValues();
    }
}
