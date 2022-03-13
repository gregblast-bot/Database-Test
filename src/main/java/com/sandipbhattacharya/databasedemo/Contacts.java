package com.sandipbhattacharya.databasedemo;

public class Contacts {
    private String latin_name;
    private String family;
    private String common_name;

    public Contacts(String latin_name, String family, String common_name) {
        this.latin_name = latin_name;
        this.family = family;
        this.common_name = common_name;
    }

    public String getLatinName() {
        return latin_name;
    }

    public String getFamily() {
        return family;
    }

    public String getCommonName() {
        return common_name;
    }
}