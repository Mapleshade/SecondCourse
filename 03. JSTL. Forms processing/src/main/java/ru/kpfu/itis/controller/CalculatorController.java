package ru.kpfu.itis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.CalculatorService;
import ru.kpfu.itis.util.CalculateValidator;

/**
 * Created by Elina on 22.03.2017.
 */
@Controller
//@RequestMapping(value = "/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    CalculateValidator validator = new CalculateValidator();


    @RequestMapping(value = "/calculator", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("add-user", "command",new Operation());
        modelAndView.addObject("result",0);
        return modelAndView;
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("command") Operation operation, BindingResult result) {
        validator.validate(operation, result);
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("add-user", "command",new Operation());
            modelAndView.addObject("result",0);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("add-user", "command",new Operation());
            modelAndView.addObject("result", calculatorService.Calculate(operation));
            return modelAndView;
        }
    }


}