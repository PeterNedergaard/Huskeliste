package com.example.huskelistetomcat;

public class Emne {

    private int id;
    private String navn;

    public Emne(String navn){
        this.navn = navn;
    }

    public Emne(int id,String navn){
        this.id = id;
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
