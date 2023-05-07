package kodlama.io.rentACar.entities.concretes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// veri tabanında tabloyu tasarlıyorum...
// ardından repositroysini yazıp onu jpadan extends ediyorum (interfacei interface e extends edilir)
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// veri tabanı id yi unique yapmak
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	// bu objeyi tablo haline getirmek gerek annotation ile yapılır
}
