package com.vendingmachine.entity.constants;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * Contains uniq ids/position numbers of each coffee product
 */
public final class CoffeeProductConstants {

    private CoffeeProductConstants() {}

    public final static String ID_COFF_1 = "COFF_1";
    public final static String ID_COFF_2 = "COFF_2";
    public final static String ID_COFF_3 = "COFF_3";
    public final static String ID_COFF_4 = "COFF_4";

    public final static List<String> ID_LIST = asList(ID_COFF_1, ID_COFF_2, ID_COFF_3, ID_COFF_4);

}
