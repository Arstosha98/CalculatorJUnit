package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;
    public CalculatorController(CalculatorService calculator){
        this.service = calculator;
    }
    @GetMapping()
    public String creating(){
        return "<b>Добро пожаловать в калькулятор</b>";
    }
    @GetMapping("/plus")
    public String plus (@RequestParam(name = "num1") int a, @RequestParam(name = "num2") int b){
        return String.format("%s + %s = %s", a,b, service.plus(a,b));
    }
    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1") int a, @RequestParam(name = "num2") int b){
        int result = service.minus(a,b);
        return String.format("%s - %s = %s",a,b, result);
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1") int a,@RequestParam(name = "num2") int b){
        int result = service.multiply(a,b);
        return String.format("%s * %s = %s",a,b, result);
    }
    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1") int a,@RequestParam(name = "num2") int b){
        try {
            int result = service.divide(a,b);
            return String.format("%s / %s = %s",a,b, result);
        } catch (Exception e){
            return "на ноль делить нельзя";
        }
    }
}