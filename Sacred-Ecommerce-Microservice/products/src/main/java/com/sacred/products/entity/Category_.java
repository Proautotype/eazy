package com.sacred.products.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Category.class)
public class Category_ {

    public static SingularAttribute<Category, Long> id;
    public static SingularAttribute<Category, String> name;
    public static SingularAttribute<Category, String> description;
    public static ListAttribute<Category, Product> products;

}
