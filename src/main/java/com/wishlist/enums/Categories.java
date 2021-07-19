package com.wishlist.enums;
    public enum Categories {

        GAMES("games"),
        CLOTHING("clothing"),
        ACCESSORIES("accessories"),
        TOYS("toys"),
        HEALTH("health"),
        BEAUTY("beauty"),
        HOME("home"),
        BOOKS("books"),
        MOVIES("movies"),
        MUSIC("music"),
        SPORTS("sports"),
        FURNITURE("furniture"),
        ELECTRONICS("electronics"),
        PETS("pets");

        private  final String category;

        Categories(final String category){this.category = category;}
        public  String getCategory(){return category;}

        public static String getCategory(String category){
            if(category == null)
                return null;
            for (Categories c: values()){
                if(c.getCategory().equals(category))
                    return c.getCategory();
            }
            return null;
        }


    }
