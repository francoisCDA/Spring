package com.yourcompany.serietv.enumerate;

public enum SerialKind {
    DRAMA,
    COMEDY,
    THRILLER,
    CRIME,
    SCIFI,
    FANTASY,
    HORROR,
    ACTION,
    FAMILY,
    SUPERHERO,
    ROMANCE,
    UNKNOW;

    public static SerialKind find(String search) {

         for (SerialKind sk : SerialKind.values()){
             if (sk.name().contains(search.toUpperCase())){
                 return sk;
             }
         }
        return  UNKNOW;
    }

}
