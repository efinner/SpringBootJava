package pet.store; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication 
// This annotation enables Spring Boot's auto-configuration, component scanning, and configuration support.
public class PetStoreApplication {

    /**
     * The main method serves as the entry point for the Spring Boot application.
     * It starts the embedded server and initializes the Spring application context.
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(PetStoreApplication.class, args);
        
    }
}