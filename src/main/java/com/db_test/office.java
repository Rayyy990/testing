package com.db_test;

public class office {
    private int officecode;
    private String city;
    private String state;

    public office(int officecode, String city, String state) {
        this.officecode = officecode;
        this.city = city;
        this.state = state;
    }

    public int getOfficecode() {
        return officecode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "office{" +
                "officecode=" + officecode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}'+"\n";
    }
}
