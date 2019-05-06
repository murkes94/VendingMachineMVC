package com.vendingmachine.entity.constants;

/**
 * Contains predefined types of ErrorEntity {@link com.vendingmachine.entity.ErrorEntity}
 */
public final class ErrorEntityType {
    private ErrorEntityType() {}

    public final static String MOTOR_ERROR = "MOTOR_ERROR";
    public final static String NO_CUPS = "NO_CUPS";
    public final static String NO_WATER = "NO_WATER";

    private final static String _OUT_OF_STOCK = "_OUT_OF_STOCK";

    /**
     * Returns _OUT_OF_STOCK ErrorEntity type for specific product id
     * @param productId
     * @return type of ErrorEntity
     */
    public static String outOfStockType(String productId) {
        return productId + _OUT_OF_STOCK;
    }
}
