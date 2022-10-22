package com.kluster.orderstock_2.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
	
	@GetMapping("/recipe")
	public String recipeform(Model model) {
		
		return "recipeform";
	}

}
