package com.Forsys.exceptions;

/**
 * 
 * 
 */
public class LocatorNotSetException
    extends
    RuntimeException {

    private static final long serialVersionUID = 597130888688896786L;

    public LocatorNotSetException(String msg) {
        super(
              "Illegal attempt to access locator that is not set.\n" + msg);
    }

}
