package me.micartey.fauth;

import lombok.Getter;

public class Authenticator {

    @Getter private final long seed;
    @Getter private final int digits;

    /**
     * Creates a new Authenticator instance to generate a reproducible number sequence depending
     * on the used seed. Much like Google Authenticator
     *
     * @param seed   a unique and distinct number e.g. creation time
     * @param digits the length of the sequence
     */
    public Authenticator(long seed, int digits) {
        this.digits = digits;
        this.seed = seed;
    }

    /**
     * Creates a new Authenticator instance with the seed being the currentTimeMillis
     *
     * @param digits a unique and distinct number e.g. creation time
     */
    public Authenticator(int digits) {
        this(System.currentTimeMillis(), digits);
    }

    /**
     * Generates a new number sequence with the specified amount of digits.
     *
     * @param cicle the n-th (n > 0) generated sequence (should be calculated from the time passed since creation)
     * @return number sequence
     */
    public long generate(int cicle) {
        long result = getReverse((long) (Math.sqrt(seed) * cicle * Math.PI));

        String value = String.valueOf(result);

        if (value.length() <= this.digits)
            return Long.valueOf(value);

        int mid = (int) Math.floor(value.length()) / 2;
        int left = (int) Math.floor(this.digits / 2);
        int right = (int) Math.floor(this.digits / 2);

        String edit = value.substring(mid - left, mid + right);

        for (int i = String.valueOf(Long.valueOf(edit)).length(); i < this.digits; i++)
            edit = edit + "3";

        return Long.valueOf(edit);
    }

    private long getReverse(long value) {
        long result = 0;
        for (long i = value; i != 0; i /= 10)
            result = result * 10 + i % 10;
        return result;
    }


    public static void main(String[] args) {
        Authenticator auth = new Authenticator(6);

        for (int i = 0; i < 10; i++) {
            System.out.println(auth.generateNext(i));
        }
    }
}
