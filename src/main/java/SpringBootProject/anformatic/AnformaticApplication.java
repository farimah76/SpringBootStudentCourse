package SpringBootProject.anformatic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnformaticApplication {
	private static final Logger logger = LoggerFactory.getLogger(AnformaticApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AnformaticApplication.class, args);
		logger.info("AnformaticApplication is successfully Run.");
	}

}
