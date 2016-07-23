package org.forstarter.partyplanner.partyplanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Norg on 17.06.2016.
 */

public class FoodListBean implements Serializable{
    private static final long serialVersionUID = 1L;

    private static ArrayList<FoodItem> itemList = new ArrayList<>();

    static {
        File dir = null;
        try {
            dir = new File(Thread.currentThread().getContextClassLoader().getResource("org/forstarter/partyplanner/partyplanner/fooditems").toURI());
        }catch (Exception e) {}

        if (dir.exists())
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
        return itemList;
    }

    public void update() {
        itemList.forEach(FoodItem::calcCount);
    }

    public static class FoodItem {
        String foodName;
        Integer eaters = 8;
        String unit = "кг";
        float k = 0.3f;
        String count;
        float fCount;
        int id;

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

        public FoodItem(String name, String unit, float k, int id) {
            foodName = name;
            this.unit = unit;
            this.k = k;
            this.id = id;

            calcCount();
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
                    Integer.parseInt(properties.getProperty("id"))

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
    }
}
