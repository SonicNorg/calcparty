package ru.hbsolutions.partyplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.hbsolutions.partyplanner.dao.FoodDao;
import ru.hbsolutions.partyplanner.dao.OrderType;
import ru.hbsolutions.partyplanner.dao.Query;
import ru.hbsolutions.partyplanner.entity.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodDao foodDao;


    public List<Food> getFoods() {
        Query query = new Query();
        query.addOrder("sort", OrderType.DESC);

        return foodDao.list(query);
    }
}
