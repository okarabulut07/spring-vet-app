package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Animal;
import com.app.service.AnimalService;

@Controller
public class AnimalController {

    @Autowired
    AnimalService service;


      // Animal List

    @GetMapping("/list")
    public ModelAndView animalList(){

        ModelAndView model =new ModelAndView();
        List<Animal> animalList = service.getAllAnimal();
          model.addObject("animalLists",animalList);
          model.setViewName("animal_list");
        return model;
    }


    // add animal Page

    @GetMapping("/addAnimalPage")
    public ModelAndView addAnimalPage(){

          Animal animal = new Animal();
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.addObject("animalForm",animal);
          modelAndView.setViewName("form");
        return modelAndView;
    }


    // add Animal

    @PostMapping("/addAnimal")
    public ModelAndView addAnimal(@ModelAttribute("animalForm") Animal animal){

          service.saveAnimal(animal);
        return new ModelAndView("redirect:/list");
    }

    // Delete List

    @GetMapping("/deleteAnimal/{a_id}")
    public ModelAndView deleteAnimal(@PathVariable("a_id") int id){

          service.deleteAnimal(id);
        return new ModelAndView("redirect:/list");
    }

    // Update List

    @GetMapping("/updateAnimal/{a_id}")
    public ModelAndView updateAnimal(@PathVariable("a_id") int id){

          ModelAndView model =new ModelAndView();
          Animal animal = service.getAnimalById(id);
          model.addObject("animalForm", animal);
          model.setViewName("form");

        return model;
    }







}
