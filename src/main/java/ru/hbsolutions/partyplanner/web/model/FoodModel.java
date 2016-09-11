package ru.hbsolutions.partyplanner.web.model;

import java.util.Map;

public class FoodModel {
    private Integer eaters;
    private Integer duration;
    private Float hunger;
    private Map<Long, Integer> itemMap;


    public Integer getEaters() {
        return eaters;
    }

    public void setEaters(Integer eaters) {
        this.eaters = eaters;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getHunger() {
        return hunger;
    }

    public void setHunger(Float hunger) {
        this.hunger = hunger;
    }

    public Map<Long, Integer> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Long, Integer> itemMap) {
        this.itemMap = itemMap;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "eaters=" + eaters +
                ", duration=" + duration +
                ", hunger=" + hunger +
                ", itemMap=" + itemMap +
                '}';
    }
}
