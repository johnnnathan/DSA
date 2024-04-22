public class Stack {
  private static int top;
  private static int[] stack;
  private static int roof;
  public Stack(int size){
    this.stack = new int[size];
    this.top = 0;
    this.roof = size - 1;
  }
  public static void main(String[] args) {
    Stack stack = new Stack(5);
    stack.push(3);
    stack.push(2);
    stack.printStack();
    stack.push(5);
    stack.push(7);
    stack.printStack();
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.printStack();
  }
  public int pop(){
    if (top >= 0){
      int value = stack[top];
      top--;
      return value;
      
    }
    System.out.println("Stack is empty, you can only add elements");
    return -999;
  }
  public void push(int value){
    if (top < roof){
      top++;
      stack[top] = value;
      return;
    }
    System.out.println("Stack Overflow, cannot exceed " + (roof + 1) + " elements");
  }
  public void printStack(){
    for (int i = roof ; i >= 0; i--){
      
      if(i <= top){System.out.println("|" + stack[i] + "|");}
      else{System.out.println("|" + "-" + "|");}


    }
      System.out.println();
  }
}
