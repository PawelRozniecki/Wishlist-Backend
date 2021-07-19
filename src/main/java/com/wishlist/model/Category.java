package com.wishlist.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.wishlist.enums.Categories;
import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name="categories")

public class Category {

    @Id
    Long id;
    @ElementCollection(targetClass = Categories.class)
    @Enumerated(EnumType.STRING)
    Collection<Categories> categories;




}
