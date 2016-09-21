package org.forstarter.partyplanner;

public class FoodItem {
    private static final int SORT_MAIN = 4;
    private static final int SORT_SNACK = 3;
    private static final int SORT_DRINK = 2;
    private static final int SORT_SPICE = 1;

    private FoodBean foodBean;
    private String foodName;
    private Integer eaters = 8;
    private String unit = "кг";
    private float k = 0.3f;
    private String count;
    private int id;
    private int sort;


    public FoodItem(FoodBean foodBean, String name, String unit, float k, int id, int sort) {
        this.foodBean = foodBean;
        foodName = name;
        this.unit = unit;
        this.k = k;
        this.id = id;
        this.sort = sort;
    }

    public void calcCount() {
        float fCount = calc();
        count = String.format(fCount > 2 ? "%.1f %s" : "%.2f %s", fCount, unit);
    }

    private float calc() {
        float t;
        switch (sort) {
            case SORT_MAIN:
                t = foodBean.getNumerousK() / 2;
                break;
            case SORT_DRINK:
                t = foodBean.getNumerousK() / 3;
                break;
            case SORT_SPICE:
                t = 1;
                break;
            default:
                t = foodBean.getNumerousK();
        }
        return getEaters() * k * getDurK() * getHungerK() / t;
    }

    private float getDurK() {
        return foodBean.getDuration() / 3;
    }

    private float getHungerK() {
        return foodBean.getHunger() / 1.6f;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getEaters() {
        return eaters;
    }

    public void setEaters(Integer eaters) {
        this.eaters = eaters;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
