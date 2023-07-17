package com.tutorial.bikestores.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DropdownDTO {
    private String value;
    private String text;

    public DropdownDTO(Object value, Object text) {
        this.value = value.toString();
        this.text = text.toString();
    }
}
