package com.sabahattin.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {

    String name;
    String country;
    String info;
    int image;


    //Constructor


    public Landmark(String name, String country, String info, int image) {
        this.name = name;
        this.country = country;
        this.info = info;
        this.image = image;

    }


}
