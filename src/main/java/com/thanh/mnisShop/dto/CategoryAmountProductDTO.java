package com.thanh.mnisShop.dto;

import com.thanh.mnisShop.model.Category;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAmountProductDTO{
    private Category category;
    private Long productCount;
}
