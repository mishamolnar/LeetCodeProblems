package LeetCode.graph;

import java.util.*;

//https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, HashSet<String>> recipeToIngredients = new HashMap<>();
        Map<String, HashSet<String>> ingredientToRecipe = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            recipeToIngredients.put(recipes[i], new HashSet<>(ingredients.get(i)));
            for (String ingredient : ingredients.get(i)) {
                ingredientToRecipe.putIfAbsent(ingredient, new HashSet<>());
                ingredientToRecipe.get(ingredient).add(recipes[i]);
            }
        }

        List<String> res = new ArrayList<>();
        Queue<String> cooked = new ArrayDeque<>(Arrays.asList(supplies));
        while (!cooked.isEmpty()) {
            String ing = cooked.poll();
            if (!ingredientToRecipe.containsKey(ing)) continue;
            for (String recipe : ingredientToRecipe.get(ing)) {
                recipeToIngredients.get(recipe).remove(ing);
                if (recipeToIngredients.get(recipe).isEmpty()) {
                    cooked.add(recipe);
                    res.add(recipe);
                }
            }
        }
        return res;
    }
}
