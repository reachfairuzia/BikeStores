package com.tutorial.bikestores.production.brand;

import com.tutorial.bikestores.shared.DropdownDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends Repository<Brand, Integer> {
    @Query(value = """
            SELECT new com.tutorial.bikestores.production.brand.BrandDTO(b.id, b.name)
            FROM Brand b
            WHERE b.name LIKE %:name%
            """)
    Page<Brand> findAll(@Param("name") String name, Pageable pageable);

    @Query("""
            SELECT new com.tutorial.bikestores.shared.DropdownDTO(b.id, b.name)
            FROM Brand b
            """)
    List<DropdownDTO> getAllBrandDropdown();
}
