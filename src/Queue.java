public class Queue {
    public static void main(String[] args) {
        Queuer queue = new Queuer();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(40);
        queue.enqueue(11);

        System.out.println(queue.dequeue());
        queue.enqueue(12);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        // queue.show();
        
    }
}
