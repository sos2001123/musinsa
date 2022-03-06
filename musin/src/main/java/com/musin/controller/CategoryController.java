package com.musin.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.musin.domain.Category;
import com.musin.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/")
	public String category(Model model, Long categoryId) {
		if(categoryId == null) {
			categoryId = (long) 0;
		}
		List<Category> categoryList = null;
		List<Category> categoryListSelect = null;
		categoryListSelect = categoryService.categoryDiv(0);
		if (categoryId == 0) {
			categoryList = categoryService.findAll();
		} else {
			categoryList = categoryService.subCategoryId(categoryId);
		}

		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryListSelect", categoryListSelect);
		return "category";
	}

	@RequestMapping(value = "/insert")
	public String insertView(Model model, Long categoryId) {
		model.addAttribute("subCategoryId", categoryId);
		int categoryDiv = 0;
		if(categoryId != 0) {
			categoryDiv = 1;
		}
		model.addAttribute("subCategoryId", categoryId);
		model.addAttribute("categoryDiv", categoryDiv);
		return "insertView";
	}

	@RequestMapping(value = "/insertCategory", method = RequestMethod.POST)
	public String insertCategory(Category category) {

		categoryService.insert(category);
		return "redirect:/";
	}

	@RequestMapping("/delete/{categoryId}")
	public String delete(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteById(categoryId);
		return "redirect:/";
	}

	@RequestMapping("/post/{categoryId}")
	public String post(@PathVariable("categoryId") Long categoryId, Model model) {
		Category category = categoryService.findByCategoryId(categoryId);

		model.addAttribute("category", category);
		return "updateView";
	}
}
