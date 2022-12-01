package ru.cft.electronicstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.enums.LaptopSize;

@SpringBootApplication
public class ElectronicStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
		Laptop laptop = Laptop.builder().withSize(LaptopSize.INCH_13).build();
		System.out.println(laptop);
	}

}
