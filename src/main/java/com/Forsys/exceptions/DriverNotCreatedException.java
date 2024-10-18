package com.Forsys.exceptions;

/**
 * 
 */
public class DriverNotCreatedException
    extends
    RuntimeException {

    private static final long serialVersionUID = 2148522970791699364L;

    public DriverNotCreatedException() {
        super("The driver is null. Please pass a valid driver to webautil.");
    }

}
