package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

// bu classın concrete yapısı yok mu? = ilgili nesneyi implemente edilmiş gibi bellege koyuyor. Yani Spring bizim icin concrete'ini bize hazırlıyor 
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	// Veri tabanı isleri yapacak sınıflara verilen objedir
	// DAO olarak da gecer 
	// markaları listeleyecek (bir veya birden fazla)
	
	//List<Brand> getAll();
	// getAll a gerek yok artık jpa repository hepsini iceriyor

}
