package com.bookcross;

public class DataClass {
    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public void setDataAuhtor(String dataAuhtor) {
        this.dataAuhtor = dataAuhtor;
    }

    private String dataName;
    private String dataAuhtor;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getdataName() {
        return dataName;
    }
    public String getdataAuhtor() {
        return dataAuhtor;
    }

    public DataClass(String dataName, String dataAuhtor, String key) {
        this.dataName = dataName;
        this.dataAuhtor = dataAuhtor;
        this.key = key;

    }
    public DataClass(){
    }
}
