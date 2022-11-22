package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void add(Car userCar) {
        carDao.add(userCar);

    }
    @Transactional
    @Override
    public List<Car> carList() {
        return carDao.carList();
    }
}
