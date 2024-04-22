public class DoubleNode {
    private DoubleNode previous;
    private DoubleNode next;
    private int data;

    public DoubleNode(int data, DoubleNode next, DoubleNode previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public DoubleNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;

    }

    public void setPrevious(DoubleNode previous) {
        this.previous = previous;
    }

    public void setNext(DoubleNode node) {
        this.next = node;
    }

    public boolean hasNext() {
        if (this.getNext() != null) {
            return true;
        }
        return false;
    }

    public boolean hasPrevious() {
        if (this.getPrevious() != null) {
            return true;
        }
        return false;
    }

    public int getData() {
        return this.data;
    }

    public DoubleNode getNext() {
        return this.next;
    }

    public DoubleNode getPrevious() {
        return this.previous;
    }

}
