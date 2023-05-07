package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service	// Bu sınıf bir business nesnedir. 
public class BrandManager implements BrandService{

	private BrandRepository brandRepository;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}
	
	@Override
	public List<GetAllBrandsResponse> getAll() {
	
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<>();
		
		for(Brand currentBrand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(currentBrand.getId());
			responseItem.setName(currentBrand.getName());
			brandsResponse.add(responseItem);
		}
		
		// iş kuralları...
		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		// TODO Auto-generated method stub
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
		
	}

}
