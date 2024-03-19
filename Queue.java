public class Queue {

  private static int front;
  private static int rear;
  private static int[] queue;
  private static int roof;

  public Queue(int size) {
    queue = new int[size];
    rear = 0;
    front = 0;
    roof = size;
  }
  public static void main(String[] args) {
    Queue q = new Queue(5);
    q.enqueue(3);
    q.enqueue(2);
    q.enqueue(7);
    q.printQueue();
    q.dequeue();
    q.printQueue();
    q.enqueue(7);
    q.enqueue(7);
    q.enqueue(7);
    q.printQueue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.printQueue();
  }


  public void enqueue(int value) {
    if (rear == roof) {
      System.out.println("Queue is full.");
      if (front != 0){
        for (int i = front; i < rear; i++) {
          queue[i - front] = queue[i];
        }
        rear -= front;
        front = 0;
        enqueue(value);
      }
      return;
    }

    queue[rear] = value;
    rear++;
  }


  public void dequeue(){
    if(front == rear){
      System.out.println("The stack is empty, restarting...");
      front = 0;
      rear = 0;
      return;

    }
    front++;


  }

  public void printQueue(){

    for (int i = 0; i < roof; i++){
      System.out.print("-");
    }
    System.out.println();
    for (int i = roof - 1; i >= rear; i--){
      System.out.print("-");
    }
    for (int i = rear - 1; i >= front; i--){
      System.out.print(queue[i]);
    }
    if (front > 0){
      for ( int i = front - 1; i > -1; i--){
        System.out.print("-");
      }
      
    }
    System.out.println();
    for (int i = 0; i < roof; i++){
      System.out.print("-");
    }
  }
}
