package pet.store.entity; 

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity // Marks this class as a JPA entity, mapping it to a database table
@Data // Lombok annotation that generates getter, setter, equals, hashCode, and
		// toString methods automatically
public class PetStore {

	@Id // Marks this field as the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long petStoreId; 
	private String petStoreName; 
	private String petStoreAddress; 
	private String petstoreCity; 
	private String petStoreState; 
	private String petStoreZip; 
	private String petStorePhone; 
	@ManyToMany(cascade = CascadeType.PERSIST)
	 // Defines a many-to-many relationship with the Customer entity.
	 // CascadeType.PERSIST ensures that when a PetStore is persisted, its associated
	 // Customers are also persisted.

	@JoinTable(name = "pet_store_customer", // Name of the join table for the many-to-many relationship
			joinColumns = @JoinColumn(name = "pet_store_id"), // Foreign key column for PetStore in the join table
			inverseJoinColumns = @JoinColumn(name = "customer_id") // Foreign key column for Customer in the join table
	)
	@EqualsAndHashCode.Exclude // Excludes this field from equals() and hashCode() methods to prevent infinite
								// loops
	@ToString.Exclude // Excludes this field from the toString() method to avoid circular references
	private Set<Customer> customers = new HashSet<>(); // Initializes the Set to prevent NullPointerException issues

	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	
	 // Defines a one-to-many relationship with the Employee entity. -
	 // "mappedBy = 'petStore'" means this field is mapped by the "petStore" field in
	 // the Employee class. - CascadeType.ALL ensures that all operations (persist,
	 // merge, remove, refresh, detach) are cascaded to Employees. - orphanRemoval =
	 // true means if an Employee is removed from this set, it is deleted from the
	 // database.
	 
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude 
	private Set<Employee> employees = new HashSet<>(); 
}