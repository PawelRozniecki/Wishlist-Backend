//package com.wishlist.converters;
//
//import com.wishlist.enums.Categories;
//
//import javax.persistence.AttributeConverter;
//
//public class CategoryConverter implements AttributeConverter<Categories, String> {
//
//
//    @Override
//    public String convertToDatabaseColumn(Categories category) {
//        if (category == null) {
//            return null;
//        }
//        return category.name();
//    }
//
//    @Override
//    public Categories convertToEntityAttribute(String dbData) {
//    }
//}
