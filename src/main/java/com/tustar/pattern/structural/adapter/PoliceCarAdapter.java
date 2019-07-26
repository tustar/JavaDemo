package com.tustar.pattern.structural.adapter;

public class PoliceCarAdapter extends CarController {

    private PoliceSound sound;
    private PoliceLamp lamp;

    public PoliceCarAdapter() {
        sound = new PoliceSound();
        lamp = new PoliceLamp();
    }

    @Override
    public void phonate() {
        sound.alarmSound();
    }

    @Override
    public void twinkle() {
        lamp.alarmLamp();
    }
}
