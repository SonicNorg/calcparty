package org.forstarter.partyplanner.test;

import org.forstarter.partyplanner.partyplanner.FoodListBean;

/**
 * Created by Norg on 07.07.2016.
 */
public class PartyTest {
    public static void main(String[] args) throws Exception{
        FoodListBean foodList = new FoodListBean();
        System.out.println(foodList.getItemList());
    }
}
