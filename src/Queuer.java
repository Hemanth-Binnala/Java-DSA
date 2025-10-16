
public class Queuer {

    private int front=0;
    private int rear=-1;
    private int size=0;
    private int[] arr = new int[4];

    public void enqueue(int data) {
        if(!isFull()){
            rear = (rear + 1) %4;
            arr[rear] = data;
            size++;
        }
        else{
            System.out.println("Queue is full");
        }
            
        
    }

    public int dequeue() {

        if(isEmpty()){
            throw new Error("queue is empty");
        }

        int data = arr[front];
        front= (front + 1) % 4;
        size--;
        return data;
    }

    public void show() {
        for(int i=front;i<size;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public boolean isFull(){
        return size ==4;
    }
    public boolean isEmpty(){
        return size ==0;
    }

}
