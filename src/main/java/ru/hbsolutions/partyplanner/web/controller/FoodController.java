package ru.hbsolutions.partyplanner.web.controller;

import com.google.common.collect.Lists;
import org.forstarter.partyplanner.FoodBean;
import org.forstarter.partyplanner.FoodItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.hbsolutions.partyplanner.entity.Food;
import ru.hbsolutions.partyplanner.service.FoodService;
import ru.hbsolutions.partyplanner.web.model.FoodModel;

import java.util.List;

@Controller
@RequestMapping(value = "")
@SessionAttributes({"foodBean"})
public class FoodController {
    private static final Logger logger = LoggerFactory.getLogger(FoodController.class);

    @Autowired
    private FoodService foodService;

    @ModelAttribute("foodBean")
    public FoodBean getFoodBean() {

        List<FoodItem> foodItems = Lists.newArrayList();
        FoodBean foodBean = new FoodBean(foodItems);

        List<Food> foodEntities = foodService.getFoods();

        foodEntities
                .forEach(v ->
                        foodItems.add(
                                new FoodItem(
                                        foodBean,
                                        v.getName(),
                                        v.getUnit().getValue(),
                                        v.getCoefficient(),
                                        v.getId().intValue(),
                                        v.getSort())
                        )
                );

        foodBean.update();

        return foodBean;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String calculate(FoodModel foodModel, @ModelAttribute("foodBean") FoodBean foodBean) {

        foodBean.setEaters(foodModel.getEaters());
        foodBean.setDuration(Math.round(foodModel.getDuration() * 1.5f));
        foodBean.setHunger(foodModel.getHunger());

        foodModel.getItemMap().forEach((id, eats) -> foodBean.getItemList()
                .stream()
                .filter(foodItem -> foodItem.getId() == id)
                .findAny()
                .ifPresent(foodItem -> {
                    foodItem.setEaters(eats);
                    if (eats > foodBean.getEaters()) {
                        foodBean.setEaters(eats);
                    }
                }));

        foodBean.update();

        return "index";
    }
}
