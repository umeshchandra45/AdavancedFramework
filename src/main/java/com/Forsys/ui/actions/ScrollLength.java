package com.Forsys.ui.actions;

/**
 * Represents ScrollLengths.
 * 
 */
public enum ScrollLength {
    SHORT(0.44, 0.50), MEDIUM(0.33, 0.66), LONG(0.25, 0.75);

    private double lowVal, highVal;

    ScrollLength(double low, double high) {
        this.lowVal = low;
        this.highVal = high;
    }

    double getLowVal() {
        return lowVal;
    }

    double getHighVal() {
        return highVal;
    }

}
