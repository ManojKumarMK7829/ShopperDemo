package shopping;

import java.io.IOException;
import java.util.Collections;

public class Customer {
    static String productItems = System.getProperty("user.dir")+"\\src\\resource\\productsDetails.csv";
    static shopping.Product product;

    public static void main(String[] args) throws IOException {
        product = shopping.Product.getInstance(productItems);
        System.out.println(maxGstPaidForAnItem());
        System.out.println(sumOfAllPrice());
    }

    private static double sumOfAllPrice() {
        return product.getUnitPriceOfAllProducts().stream().mapToDouble(Double::doubleValue).sum();
    }

    private static String maxGstPaidForAnItem() {
        int indexValue = product.getGSTOfAllProducts().indexOf(Collections.max(product.getGSTOfAllProducts()));
        return product.getProductsName().get(indexValue);
    }
}
