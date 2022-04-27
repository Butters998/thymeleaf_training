package com.example.thymeleaf_cw;

public class Car {
    private String mark;
    private String model;
    private long id;

    public Car(long id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;

    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", id=" + id +
                '}';
    }
}
