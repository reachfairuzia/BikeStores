package com.tutorial.bikestores.production.product;

import com.tutorial.bikestores.shared.DropdownDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Page<ProductDTO> getAllProduct(String name, int pageNumber);
    public Page<ProductDTO> getAllProduct();
    ProductUpsertDTO getProductById(Integer id);
    void save(ProductUpsertDTO productUpsertDTO);
    List<DropdownDTO> getCategoryDropdown();
    List<DropdownDTO> getBrandDropdown();
    ProductDTO getSingle(Integer id);
    List<DropdownDTO> getStoreDropdown(Integer id);
}
