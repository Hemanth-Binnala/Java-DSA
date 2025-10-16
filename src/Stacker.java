
public class Stacker {
    private int[] arr = new int[5];
    int size;
    int top;

    public Stacker(){
        size = arr.length;
        top = -1;
    }

    public void push(int data) {
        top++;
        if(top<size){
            arr[top] = data;
        }
        else{
            System.out.println("Stack overflow");
        }
    }

    public void printStack(){
        for(int n : arr){
            System.out.println(n + " ");
        }
        System.out.println();
    }

    public int pop() {
        return arr[top--];
    }

    public int peek() {
        return arr[top];
    }

}
