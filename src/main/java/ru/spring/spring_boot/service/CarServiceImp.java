package ru.spring.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.spring_boot.models.Car;
import ru.spring.spring_boot.repositories.CarRepository;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class CarServiceImp implements CarService {
    public CarRepository carRepository;

    @Value("${carService.maxCar}")
    private int maxCar;

    @Autowired
    public CarServiceImp(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findOne(long id) {
        Optional<Car> foundCar = carRepository.findById(id);
        return foundCar.orElse(null);
    }

    @Transactional
    public void save(Car car) {
        carRepository.save(car);
    }

    @Transactional
    public void update(long id, Car updatedCar) {
        updatedCar.setId(id);
        carRepository.save(updatedCar);
    }

    @Transactional
    public void delete(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getCarsByGivenCounter(Integer count) {
        Optional<Integer> countOptional = Optional.ofNullable(count);
        if (countOptional.isPresent() && countOptional.get() > 0 && countOptional.get() < maxCar) {
            return findAll().subList(0, countOptional.get());
        } else {
            return findAll();
        }
    }

    @Override
    public List<Car> sortByField(List<Car> carList, String field) {
        if (Objects.equals(field, "model")) {
            carList.sort(Comparator.comparing(Car::getModel));
        }
        if (Objects.equals(field, "series")) {
            carList.sort(Comparator.comparing(Car::getSeries));
        }
        return carList;
    }


}
