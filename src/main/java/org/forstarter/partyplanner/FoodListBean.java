package org.forstarter.partyplanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

/**
 * Created by Norg on 17.06.2016.
 */

public class FoodListBean implements Serializable{
    private static final long serialVersionUID = 1L;
    private int duration = 3;

    private static ArrayList<FoodItem> itemList = new ArrayList<>();

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    static {
        File dir = null;
        try {
            dir = new File(Thread.currentThread().getContextClassLoader().getResource("/fooditems").toURI());
        }catch (Exception e) {}

        if (dir.exists()) //todo add null-check
            try {
                File[] files = dir.listFiles();

                for (File f : files) {
                    if(f.getName().endsWith(".fi")) {
                        Properties item = new Properties();
                        item.load(new InputStreamReader(new FileInputStream(f), "utf-8"));
                        itemList.add(new FoodItem(item));
                    }
                }
            }catch (IOException e) {}
    }

    public ArrayList<FoodItem> getItemList() {
        Collections.sort(itemList);
        return itemList;
    }

    public void update() {
        itemList.forEach(FoodItem::calcCount);
    }

    public static class FoodItem implements Comparable<FoodItem>{
        public static final int SORT_MAIN = 4;
        public static final int SORT_SNACK = 3;
        public static final int SORT_DRINK = 2;
        public static final int SORT_SPICE = 1;

        String foodName;
        Integer eaters = 8;
        String unit = "кг";
        float k = 0.3f;
        String count;
        float fCount;
        int id;
        int sort;

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
            calcCount();
        }

        public FoodItem(String name, String unit, float k, int id, int sort) {
            foodName = name;
            this.unit = unit;
            this.k = k;
            this.id = id;
            this.sort = sort;

            calcCount();
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

        public FoodItem(Properties properties) {
            this(
                    properties.getProperty("name"),
                    properties.getProperty("unit"),
                    Float.parseFloat(properties.getProperty("k")),
                    Integer.parseInt(properties.getProperty("id")),
                    Integer.parseInt(properties.getProperty("sort"))
            );
        }

        public String getCount() {
            calcCount();
            return count;
        }

        public void setCount(String s) {
            calcCount();
        }

        private void calcCount() {
            fCount = getEaters()*k;
            count = String.format(fCount > 2 ? "%.1f %s" : "%.2f %s", fCount, unit);
        }


        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public int compareTo(FoodItem o) {
            return o.getSort()-getSort();
        }
    }
}
