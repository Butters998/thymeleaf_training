package com.example.thymeleaf_cw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private final List<Car> cars;

    public CarController() {
        Car car1 = new Car("BMW", "i8");
        Car car2 = new Car("Fiat", "126p");
        Car car3 = new Car("Polonez", "Caro");
        Car car4 = new Car("Hyundai", "i30");
        cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @GetMapping("/car")
    public String getCar(Model model) {

        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @GetMapping("/add-car")
    public String addCar(@RequestParam String mark, @RequestParam String model) {
        cars.add(new Car(mark, model));
        //return "redirect:/car";
        return "car"; // tutaj żeby już nas nie przenosiło ale będzie sypało błędem
    }
}
