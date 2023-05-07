package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;

@RestController	// Annotation	SpringFramework bu uygulamayı derlediğinde veya çalışırken hangi classlarda rest controller var diye arıyor. Demek ki orası erişim noktası
@RequestMapping("/api/brands")  
public class BrandsController {
	private BrandService brandService;

	@Autowired	// bu cons. un parametrelerine bak --> BrandService sonra uygulamaya bak kim BrandService kullanıyorsa onun newlenmiş halini ver
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
		
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		//BrandManager brandManager = new BrandManager(new InMemoryBrandRepository());
		//brandManager.getAll();
		// bu yukarıdakiler yerine
		// Sprinde IoC denen bir yapı var. (inversion of control)
		// bellekte bir şeyi newle gerektiğinde o oluşturulan nesnelerin refaransını ver. boş yere bir şeyler oluşturma her defasında
		// bunları IoC ye eklemesi için "service" annotation u eklemek lazım
		return brandService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);		
	}
	
}
