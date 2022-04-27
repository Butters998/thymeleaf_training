package com.example.thymeleaf_cw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
public class CarController {
    private final List<Car> cars;

    public CarController() {
        Car car1 = new Car(1L,"BMW", "i8");
        Car car2 = new Car(2L,"Fiat", "126p");
        Car car3 = new Car(3L,"Polonez", "Caro");
        Car car4 = new Car(4L,"Hyundai", "i30");
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
        model.addAttribute("newCar2", new Car());
        model.addAttribute("newCar3", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        Optional<Car> findId = cars.stream().filter(e -> e.getId() == car.getId()).findFirst();
        if (findId.isPresent()) {
            return "redirect:/car";
        }
        else
        cars.add(car);
        return "redirect:/car";
    }

    @PostMapping("/remove-car")
    public String deleteCar(@ModelAttribute Car car) {
        Optional<Car> findId = cars.stream().filter(e -> e.getId() == car.getId()).findFirst();
        if (findId.isPresent()) {
            cars.remove(findId.get());
            return "redirect:/car";
        }
        else
        return "redirect:/car";
    }
    @PostMapping("/change-car")
    public String changeCar(@ModelAttribute Car car) {
        Optional<Car> findId = cars.stream().filter(e -> e.getId() == car.getId()).findFirst();
        if (findId.isPresent()) {
            cars.remove(findId.get());
            cars.add(car);
            return "redirect:/car";
        }
        else
            return "redirect:/car";
    }
}
