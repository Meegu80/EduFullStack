package com.javalab.sec03;

public class Audio {
    private String model;

    public Audio() {
    }

    public Audio(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "model='" + model + '\'' +
                '}';
    }
}
