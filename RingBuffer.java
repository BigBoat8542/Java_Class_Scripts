
public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    //YOU'RE GOING TO NEED AN ARRAY!!!!!!!
    private int first = 0; //first item
    private int last = -1; // last item
    private int size = 0; //total of objects
    private int capacity;
    private double buff[]; //items in buffer

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        first = 0;
        last = 0;
        buff = new double[capacity];
    }

    // return the capacity of this ring buffer
    public int capacity() {
        // YOUR CODE HERE
        return capacity;
    }

    // return number of items currently in this ring buffer
    public int size() {
        // YOUR CODE HERE
        return size;

    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        // YOUR CODE HERE
        // boolean isEmpty() {
        if (size == capacity) {
            return true;
        }
        else {
            return false;
        }
    }

    // }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        // YOUR CODE HERE
        //boolean isFull (); {
        if (size == capacity)
            return true;
        else
            return false;
    }


    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        // YOUR CODE HERE
        //increment
        buff[last] = x;
        last++;
        if (last == capacity())
            last = 0;
        size++;
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        // YOUR CODE HERE
        double act = buff[first];
        buff[first] = 0;
        first++;
        if (first == capacity())
            first = 0;
        size--;
        return act;

    }

    // returns the item at the front of this ring buffer
    public double peek() {
        // YOUR CODE HERE
        return buff[first];
    }


    // tests and calls every instance method in this class

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);
        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());
    }
}
