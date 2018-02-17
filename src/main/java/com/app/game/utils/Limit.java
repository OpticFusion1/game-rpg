package com.app.game.utils;

import java.io.Serializable;
import java.util.Random;

/**
 * 
 * @author deepdozen
 *
 * Class generates random value between lowerBound and upperBound inclusive
 *
 */

public class Limit implements Serializable {
	private static final long serialVersionUID = -1110428886124128547L;
	private final int lowerBound;
    private final int upperBound;

    public Limit(int lowerBound, int upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("Lower bound must be <= upper bound!");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    // upperBound + 1 --> returns inclusive
    public int getRandom() {
    		return (new Random()).nextInt((upperBound - lowerBound) + 1) + lowerBound;
    }
}
