
public class Tree{
    public static void main(String[] args) {
        BinaryTree binary = new BinaryTree();
        binary.insert(8);
        binary.insert(7);
        binary.insert(12);
        binary.insert(15);
        binary.insert(2);
        binary.insert(5);

        binary.inorder();
    }
}