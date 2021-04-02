
public class GuitarString {
    //     // YOUR INSTANCE VARIABLES HERE
    public int instance;
    public RingBuffer buff;

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        // YOUR CODE HERE
        int cap = (int) (44100 / frequency);
        this.buff = new RingBuffer(cap);
        this.instance = 0;
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        // YOUR CODE HERE
        int cap = init.length;
        buff = new RingBuffer(cap);
        for (int i = 0; i < init.length; i++)
            buff.enqueue(init[i]);

    }

    // returns the number of samples in the ring buffer
    public int length() {
        // YOUR CODE HERE
        return this.buff.capacity();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        // YOUR CODE HERE
        //empty buffer
        while (!buff.isEmpty()) {
            buff.dequeue();
        }

        int n = this.buff.capacity();
        for (int i = 0; i < n; i++) {
            double min = -0.5;
            double max = 0.5;
            double s = StdRandom.uniform(min, max);
            buff.enqueue(s);
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        // YOUR CODE HERE
        //no loop
        //int previousInstance = this.instance;
        //int p = this.buff.capacity;
        //set thing in front = 0 and set thing in back to what was in the front
        double initial = buff.dequeue();
        double next = buff.peek();
        buff.enqueue((((initial + next) / 2) * .996));

    }

    // returns the current sample
    public double sample() {
        // YOUR CODE HERE
        return this.buff.peek();
    }

    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
        GuitarString testString = new GuitarString(samples);
        int m = 25; // 25 tics
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();
        }
    }

}

