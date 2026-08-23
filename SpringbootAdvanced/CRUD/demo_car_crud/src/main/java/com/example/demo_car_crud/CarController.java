package com.example.demo_car_crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // CREATE
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    // READ ALL
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {

        if (carRepository.existsById(id)) {
            return carRepository.findById(id).get();
        }

        return new Car();
    }

    // UPDATE TYPE
    @PutMapping("/{id}")
    public Car updateType(
            @PathVariable Long id,
            @RequestParam String type) {

        if (carRepository.existsById(id)) {
            Car car = carRepository.findById(id).get();
            car.setType(type);
            return carRepository.save(car);
        }

        return new Car();
    }

    // DELETE ONE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {

        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    // DELETE ALL
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCars() {
        carRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}