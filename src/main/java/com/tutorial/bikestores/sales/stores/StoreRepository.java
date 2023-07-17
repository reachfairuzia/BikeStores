package com.tutorial.bikestores.sales.stores;

import com.tutorial.bikestores.shared.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Stores, Integer> {
    @Query(value = """
            SELECT new com.tutorial.bikestores.shared.DropdownDTO(s.storeId,
            CONCAT('Store Name: ', s.storeName, ' - ', 'Stock: ', st.quantity))
            FROM Stores s
            JOIN Stock st on s.storeId = st.storeId
            WHERE st.productId = :id
            """)
    List<DropdownDTO> getStoreDropdown(Integer id);
}
