package ru.hbsolutions.partyplanner.rest.controller;

import ru.hbsolutions.partyplanner.entity.Food;
import ru.hbsolutions.partyplanner.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/food")
public class FoodRestController {

    @Autowired
    private FoodService foodService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Food> getFoods() {
        return foodService.getFoods();
    }
}
