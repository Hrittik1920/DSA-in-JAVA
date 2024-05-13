public class arrayQueue {
    //--------------------------------- # Implementing queue using array----------------------------------------------
    // static class Queue {
        // static int arr[];
        // static int size;
        // static int rear = -1;

        // Queue(int size) {
        //     arr = new int[size];
        //     this.size = size;
        // }

        // public static boolean isEmpty() {
        //     return rear == -1;
        // }

        // public static void add(int data) {
        //     if(rear == size - 1) {
        //         System.out.println("Queue is full");
        //         return;
        //     }
        //     arr[++rear] = data;
        // }

        // public static int remove() {
        //     if(isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     int front = arr[0];
        //     for(int i=0;i<rear;i++) {
        //         arr[i] = arr[i+1];
        //     }
        //     rear--;
        //     return front;
        // }

        // public static int peek() {
        //     if(isEmpty()) {
        //         System.out.println("Queue is empty");
        //         return -1;
        //     }
        //     return arr[0];
        // }

    // }

    //------------------------------------ # Implementing queue using Circular array -----------------------------------
    static class Queue {
        static int arr[];
        int size;
        static int front = -1;
        static int rear = -1;
        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if(front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            
            int element = arr[front];
            //condition for single element
            if(front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return element;
        }
        
        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }      
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.add(3);
        q.add(5);
        q.add(2);
        q.add(7);
        q.add(4);
        q.add(4);
        q.remove();
        q.add(4);
        q.add(6);
        while(!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
        
    }
}
