package com.wishlist.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 2)
    @Column(nullable = false, updatable = false)
    @NonNull
    Long id;
    String name;
    BigDecimal price;
    String category;
    String description;
    String imageUrl;
    // status 0 means product is not yet bought, status 1 means product is bought
    Boolean status;


}
