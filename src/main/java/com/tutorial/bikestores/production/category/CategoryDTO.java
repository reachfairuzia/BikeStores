package com.tutorial.bikestores.production.category;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private Integer id;
    @NotBlank(message = "Kalo name jangan kosong")
    @Length(min = 3, max = 50, message = "minimal 3 huruf, maksimal 50 huruf")
    private String name;
}
