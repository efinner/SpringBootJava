package pet.store.entity; 

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity // Marks this class as a JPA entity, meaning it will be mapped to a database table
@Data // Lombok annotation to generate boilerplate code like getters, setters, and toString()
public class Customer { 

    @Id // Specifies the primary key for the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key using database identity column
    private Long customerId; 
    private String customerFirstName; 
    private String customerLastName;  
    private String customerEmail;     
    
    @EqualsAndHashCode.Exclude 
    @ToString.Exclude 
    @ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST) 
    
    private Set<PetStore> petStores = new HashSet<>(); 

}