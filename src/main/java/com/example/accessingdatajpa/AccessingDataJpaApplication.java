package com.example.accessingdatajpa;

import com.example.accessingdatajpa.model.Car;
import com.example.accessingdatajpa.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class, args);

		CustomerRepository repository = context.getBean(CustomerRepository.class);
		CarRepository carRepository = context.getBean(CarRepository.class);

		Car car = new Car("MAZERTI", 222);
		Car car2 = new Car("BMW", 555);
		Customer customer = new Customer("Nick", "321");
		List<Car> cars = new ArrayList<>();
		cars.add(car);
		cars.add(car2);
		customer.setCars(cars);

		repository.deleteById(1L);

	}

}
