package ru.hbsolutions.partyplanner.entity;

public enum Unit {
    KILOGRAMS("кг"), LITERS("л"), MILLILITERS("мл");

    private String value;

    Unit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
