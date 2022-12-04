package ru.cft.electronicstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.Technique;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;
import ru.cft.electronicstore.entity.enums.LaptopSize;
import ru.cft.electronicstore.repository.*;
import ru.cft.electronicstore.service.impl.ComputerServiceImpl;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ElectronicStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner testStart(ComputerServiceImpl computerService) {
//		return args -> {
//			computerService.create(new Computer(2L, "dvdv", "1000", 25, ComputerFormFactor.DESKTOP));
//			computerService.create(new Computer(3L, "sasi", "777", 7, ComputerFormFactor.MONOBLOCK));
//			computerService.create(new Computer(1L, "ska", "999", 6, ComputerFormFactor.NETTOP));
//			List<Computer> computers = computerService.getAll();
//			for(Computer computer: computers)
//				System.out.println(computer);
//			computerService.delete(2L);
//			List<Computer> computers2 = computerService.getAll();
//			for(Computer computer: computers2)
//				System.out.println(computer);
//			computerService.update(4L, new Computer(4L, "!!!", "MILLIARD", 100, ComputerFormFactor.NETTOP));
//			List<Computer> computers3 = computerService.getAll();
//			for(Computer computer: computers3)
//				System.out.println(computer);
//		};
//	}
}
