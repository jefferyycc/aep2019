package edu.berkeley.aep;

public class Reverser {

    public static String reverse(String toReverse) {
        var length = toReverse.length();
        if (length < 2) {
            return toReverse;
        }
        return toReverse.charAt(length - 1) + reverse(toReverse.substring(0, length - 1));
    }
}
