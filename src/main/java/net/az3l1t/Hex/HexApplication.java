package net.az3l1t.Hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HexApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexApplication.class, args);
	}

}
