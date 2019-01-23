package com.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Farm {

    private Long id;

    private String name;

    private BigDecimal price;

    private Long minute;

    private String storeName;

}
