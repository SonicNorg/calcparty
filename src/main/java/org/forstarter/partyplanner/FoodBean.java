package org.forstarter.partyplanner;

import java.io.Serializable;
import java.util.List;

public class FoodBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int duration = 3;
    private int eaters = 8;
    private float numerousK;
    private float hunger = 1.6f;

    private List<FoodItem> itemList;


    public FoodBean(List<FoodItem> itemList) {
        this.itemList = itemList;
    }

    public List<FoodItem> getItemList() {
        return itemList;
    }

    public void update() {
        int t=0;
        for (FoodItem item : itemList) {
            t += (item.getSort() != 1) ? item.getEaters() : 0;
        }
        numerousK = 1f*t/eaters;
        //System.err.println("Numerous K: "+numerousK);
        itemList.forEach(FoodItem::calcCount);
    }

    public int getEaters() {
        return eaters;
    }

    public void setEaters(int eaters) {
        this.eaters = eaters;
    }

    public float getHunger() {
        return hunger;
    }

    public void setHunger(float hunger) {
        this.hunger = hunger;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getNumerousK() {
        return numerousK;
    }

    @Override
    public String toString() {
        return "FoodBean{" +
                "duration=" + duration +
                ", eaters=" + eaters +
                ", numerousK=" + numerousK +
                ", hunger=" + hunger +
                ", itemList=" + itemList +
                '}';
    }
}
