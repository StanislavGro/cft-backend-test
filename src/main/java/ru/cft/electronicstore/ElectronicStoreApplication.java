package ru.cft.electronicstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.cft.electronicstore.entity.Computer;
import ru.cft.electronicstore.entity.Laptop;
import ru.cft.electronicstore.entity.enums.ComputerFormFactor;
import ru.cft.electronicstore.entity.enums.LaptopSize;
import ru.cft.electronicstore.repository.ComputerRepository;
import ru.cft.electronicstore.repository.HardDriveRepository;
import ru.cft.electronicstore.repository.LaptopRepository;
import ru.cft.electronicstore.repository.MonitorRepository;

import java.util.List;

@SpringBootApplication
public class ElectronicStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectronicStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner testStart(ComputerRepository computerRepository,
									   HardDriveRepository hardDriveRepository,
									   LaptopRepository laptopRepository,
									   MonitorRepository monitorRepository) {
		return args -> {
			computerRepository.save(new Computer(1L, "dvd", "12", 2, ComputerFormFactor.DESKTOP));
			List<Computer> computers = computerRepository.findAll();
			for(Computer computer: computers){
				System.out.println(computer);
			}
		};
	}
}
