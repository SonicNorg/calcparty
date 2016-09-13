package ru.hbsolutions.partyplanner.dao;

import com.google.common.collect.Maps;
import java.util.Map;

public class Query {

    Map<String, OrderType> orders = Maps.newHashMap();

    public void addOrder(String field) {
        addOrder(field, OrderType.ASC);
    }

    public void addOrder(String field, OrderType orderType) {
        orders.put(field, orderType);
    }
}
