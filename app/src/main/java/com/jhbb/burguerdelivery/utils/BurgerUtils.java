package com.jhbb.burguerdelivery.utils;

import com.jhbb.burguerdelivery.models.IngredientModel;

import java.util.List;

public class BurgerUtils {

    public static String getFormattedIngredientsList(List<IngredientModel> ingredients) {
        String formattedText = "";

        for (IngredientModel item : ingredients) {
            formattedText = formattedText.concat(item.getName()).concat(" ");
        }

        return formattedText;
    }

    public static double getBurgerPrice(List<IngredientModel> ingredients) {
        double price = 0;

        for (IngredientModel item : ingredients) {
            price = price + item.getPrice();
        }

        return price;
    }
}
