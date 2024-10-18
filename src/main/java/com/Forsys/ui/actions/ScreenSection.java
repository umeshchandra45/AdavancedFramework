package com.Forsys.ui.actions;

public enum ScreenSection {

    _1(0.1), _25(0.25), _33(0.33), _44(0.44), _50(0.50), _66(0.66), _75(0.75), _96(0.96);

    private double val;

    private ScreenSection(double val) {
        this.val = val;
    }

    double get() {
        return val;
    }
}
