package com.sacred.carts.constants;

public class CartsConstants {
    private CartsConstants(){}

    public final static int STATUS_200 = 200;
    public final static String MESSAGE_200 = "Request processed successfully";

    public final static int STATUS_201 = 201;
    public final static String MESSAGE_201 = "Resource created successfully";


    public final static int STATUS_203 = 203;
    public final static String MESSAGE_203_DELETE = "Resource deleted successfully";
    public final static String MESSAGE_203_UPDATE = "Resource updated successfully";
    public final static int STATUS_403 = 403;;
    public final static String MESSAGE_403_DELETE = "Delete operation failed. Please retry again or look at the documentation";
    public final static String MESSAGE_403_UPDATE = "Update operation failed. Please retry again or look at the documentation";

    public final static int STATUS_400 = 400;
    public final static String MESSAGE_400 = "Request could not proceed";



    public static final int  STATUS_500 = 500;
    public static final String  MESSAGE_500 = "An error occurred. Please try again or contact Dev team";
}
