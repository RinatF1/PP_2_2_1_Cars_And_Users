package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {

    void addCar (Car userCar);
    List<Car> carListForTable();

}
