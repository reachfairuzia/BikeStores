package com.tutorial.bikestores.production.category;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class CategoryController {

    private final CategoryDbService service;

    @ModelAttribute("category")
    public CategoryDTO findCategory(@PathVariable(required = false) Integer id){
        return id == null? new CategoryDTO() : service.getCategoryById(id);
    }
    @GetMapping("/categories")
    public ModelAndView showAllCategories(){
        ModelAndView modelAndView = new ModelAndView("/categories/categories-index");
        modelAndView.addObject("categories", service.getAllCategories());
        return modelAndView;
    }
    @GetMapping("/categories/{id}")
    public ModelAndView showCategory(){
        ModelAndView modelAndView = new ModelAndView("/categories/category-details");
        return modelAndView;
    }

    @GetMapping("/categories/new")
    public ModelAndView initCreationCategory(){
        ModelAndView modelAndView = new ModelAndView("/categories/upsert-category");
        return modelAndView;
    }

    @PostMapping("/categories/new")
    public String newCategoryCreation(@Valid @ModelAttribute("category") CategoryDTO category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "categories/upsert-category";
        }
        service.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/edit")
    public ModelAndView initEditCategory(){
        ModelAndView modelAndView = new ModelAndView("/categories/upsert-category");
        return modelAndView;
    }

    @PostMapping("/categories/{id}/edit")
    public String editCategory(@Valid @ModelAttribute("category") CategoryDTO category, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "categories/upsert-category";
        }
        service.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/remove")
    public String removeCategory(@PathVariable Integer id){
        service.deleteCategoryById(id);
        return "redirect:/categories";
    }

    @GetMapping("/categories/page")
    public ModelAndView showPageCategories(@RequestParam(defaultValue = "") String name,
                                           @RequestParam(defaultValue = "1") int pageNumber){
        ModelAndView mv = new ModelAndView("/categories/categories-pages");
        Page<CategoryDTO> pageCategories = service.getPageCategories(name, pageNumber);
        mv.addObject("categories", pageCategories);
        return mv;
    }

}
