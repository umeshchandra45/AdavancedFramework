
package com.Forsys.api.core;

public class Cookie {
    private String name;
    private String value;

    public Cookie(String name, String value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return name + "=" + value;
    }
}
