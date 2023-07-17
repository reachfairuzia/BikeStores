package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.production.brand.BrandRepository;
import com.tutorial.bikestores.production.category.Category;
import com.tutorial.bikestores.production.category.CategoryDbService;
import com.tutorial.bikestores.production.category.CategoryRepository;
import com.tutorial.bikestores.sales.stores.StoreRepository;
import com.tutorial.bikestores.shared.DropdownDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductDbService implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final StoreRepository storeRepository;
    private  final static Integer PAGE_SIZE = 5;

    private final ModelMapper modelMapper;

    public Page<ProductDTO> getAllProduct(String name, int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber-1, PAGE_SIZE);
        return productRepository.findAll(name, pageable);
    }
    public Page<ProductDTO> getAllProduct(){
        return productRepository.findAll("", PageRequest.ofSize(1000));
    }

    public ProductUpsertDTO getProductById(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct
                .orElseThrow(()-> new EntityNotFoundException("Product tidak ditemukan"));
        return modelMapper.map(product, ProductUpsertDTO.class);
    }

    public ProductDTO getSingle(Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = optionalProduct
                .orElseThrow(()-> new EntityNotFoundException("Product tidak ditemukan"));
        return modelMapper.map(product, ProductDTO.class);
    }

    public void save(ProductUpsertDTO productUpsertDTO){
        Product product = new Product();
        productRepository.save(modelMapper.map(productUpsertDTO, Product.class));
    }
    public void remove(Integer id){}
    public List<DropdownDTO> getCategoryDropdown(){
        return categoryRepository.getAllCategoryDropdown();
    }
    public List<DropdownDTO> getBrandDropdown(){
        return brandRepository.getAllBrandDropdown();
    }

    public List<DropdownDTO> getStoreDropdown(Integer id){
        return storeRepository.getStoreDropdown(id);
    }
}
