package com.cs105.project;

import java.util.Random;

public class Rand {
    public static double range = 0.7;

    private final static Random r = new Random();

    public static boolean isCui() {
        return r.nextDouble() > range;
    }
}
