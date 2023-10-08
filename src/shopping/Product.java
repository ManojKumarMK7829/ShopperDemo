package shopping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {

    private static List<List<String>> productData = new ArrayList<>();
    private static List<String> productsName = new ArrayList<>();
    private static List<Double> unitPriceOfAllProducts = new ArrayList<>();
    private static List<Double> gstOfAllProducts = new ArrayList<>();


    public List<List<String>> getProductData() {
        return productData;
    }

    public List<String> getProductsName() {
        productData.stream().skip(1).forEach(item -> productsName.add(item.get(1)));
        return productsName;
    }

    public List<Double> getUnitPriceOfAllProducts() {
        productData.stream().skip(1).forEach(item -> unitPriceOfAllProducts.add(Double.valueOf(item.get(2))));
        return unitPriceOfAllProducts;
    }

    public List<Double> getGSTOfAllProducts() {
        productData.stream().skip(1).forEach(item -> gstOfAllProducts.add(Double.valueOf(item.get(3))));
        return gstOfAllProducts;
    }

    public static Product getInstance(String productDetailsPath) throws IOException {
        readItems(productDetailsPath);
        return new Product();
    }

    private static void readItems(String productDetailsPath) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(productDetailsPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                productData.add(Arrays.asList(values));
            }
        }
    }



}
