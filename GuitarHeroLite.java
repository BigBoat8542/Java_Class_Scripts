
public class GuitarHeroLite {

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
        double CONCERT_A = 440.0;
        char button;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);
        GuitarString[] allStrings = new GuitarString[37];
        String keyboard = "q2we4r5ty7u8i9op -[=zxdcfvgbnjmk,.;/";

        for (int i = 0; i < allStrings.length; i++) {
            double noteA = CONCERT_A * Math.pow(2, ((i - 24.0) / 12.0));
            allStrings[i] = new GuitarString(noteA);
        }
        // the main input loop
        while (true) {
            double sample = 0.0;
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);

                // pluck the corresponding string
                if (index == -1) {
                    continue;
                }
                for (int i = 0; i < keyboard.length(); i++) {
                    if (key == keyboard.charAt(index)) {
                        allStrings[index].pluck();
                    }

                    // compute the superposition of the samples
                    for (int j = 0; j < allStrings.length; j++) {
                        sample = stringA.sample() + stringC.sample();
                    }
                    // send the result to standard audio
                    StdAudio.play(sample);

                    // advance the simulation of each guitar string by one step
                    stringA.tic();
                    stringC.tic();
                    for (int l = 0; allStrings.length > l; l++) {
                        allStrings[l].tic();

                    }
                }
            }
        }
    }
}




