package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car userCar);
    List<Car> carListForTable();
}
