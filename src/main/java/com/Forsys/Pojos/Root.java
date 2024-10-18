package com.Forsys.Pojos;

public class Root {

    private Installed installed;

    public Root(Installed installed) {
        this.installed = installed;
    }

    public Installed getInstalled() {
        return installed;
    }

    public void setInstalled(Installed installed) {
        this.installed = installed;
    }
}
