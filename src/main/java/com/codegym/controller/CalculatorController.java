package com.codegym.controller;

import com.codegym.persistence.CalculatorPersistenceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showForm(Model model){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("number1") float number1, @RequestParam("number2") float number2, @RequestParam("operator") String operator, Model model) {
        CalculatorPersistenceImpl calculatorPersistence = new CalculatorPersistenceImpl();
        float result = 0;
        String message = null;
        switch (operator){
            case "+":
                result = calculatorPersistence.add(number1,number2);
                break;
            case "-":
                result = calculatorPersistence.sub(number1,number2);
                break;
            case "*":
                result = calculatorPersistence.mul(number1,number2);
                break;
            case "/":
                if(number2 == 0) {
                   message = "loi mau so = 0";
                } else {
                    result = calculatorPersistence.div(number1,number2);
                        }
                break;
        }

        model.addAttribute("result", result);
        model.addAttribute("number2", number2);
        model.addAttribute("operator", operator);
        model.addAttribute("message", message);
        return "/index";
    }
}
