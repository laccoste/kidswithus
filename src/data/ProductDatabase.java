package data;

import model.Clothes;
import model.Product;
import model.SoftToys;

import java.util.ArrayList;


public class ProductDatabase {


    public static ArrayList <Product> productArrayList = new ArrayList <Product>();

    public ProductDatabase() {


        productArrayList = DataInputOutput.getAllProductDetails();

    }

    //This method allows you to remove products from the ArrayList
    public static void buyProduct(int i) {

        productArrayList.remove(i);
    }

    /**
     * The following methods print out a table of all available Products/Toys and tables of just Toys/Products from the passed
     * ArrayList called productArrayList. It is passed an ArrayList of generic Objects.
     * Firstly, it is checked if the passed ArrayList is an instance of Products.
     * If true, then there is a different printout Format compared to SoftToys.
     * A second check is if the Product is available. Only available Product are printed.
     */


    public static void printProducts() {
        System.out.println("\n  These are the products that are currently available: \n");
        System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | %-10s | \n", "ID", "Product Name", "Type", "Price", "Color", "Age Group");
        for (Product thisObject : productArrayList) { //for each object in productArrayList
            if (thisObject instanceof Clothes) { // If true, then it is printed out. 3
                System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | %-10s | \n",
                        productArrayList.indexOf(thisObject), thisObject.getName(), thisObject.getType(), thisObject.getPrice(), ((Clothes) thisObject).getColor(), "");
            } else if (thisObject instanceof SoftToys)
                System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | %-10s | \n",
                        productArrayList.indexOf(thisObject), thisObject.getName(), thisObject.getType(), thisObject.getPrice(), "", ((SoftToys) thisObject).getAgeGroup());
        }
    }

    public static void printClothes() {
        System.out.println("\n  These are the products that are currently available: \n");
        System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | \n", "ID", "Product Name", "Type", "Price", "Color");
        for (Product thisObject : productArrayList) { //for each object in productArrayList
            if (thisObject instanceof Clothes) { // If true, then it is printed out.
                System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | \n",
                        productArrayList.indexOf(thisObject), thisObject.getName(), thisObject.getType(), thisObject.getPrice(), ((Clothes) thisObject).getColor());

            }
        }
    }

    public static void printSoftToys() {
        System.out.println("\n  These are the products that are currently available: \n");
        System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | \n", "ID", "Product Name", "Type", "Price", "AgeGroup");
        for (Product thisObject : productArrayList) { //for each object in productArrayList
            if (thisObject instanceof SoftToys) { // If true, then it is printed out.
                System.out.printf("  | %-2s | %-15s | %-8s | %-9s | %-10s | \n",
                        productArrayList.indexOf(thisObject), thisObject.getName(), thisObject.getType(), thisObject.getPrice(), ((SoftToys) thisObject).getAgeGroup());

            }
        }
    }

    public void addProduct(Product product) {

        productArrayList.add(product);

    }

    public void writeUpdatedProductListToFile(ArrayList <Product> product) {
        DataInputOutput.emptyFile("products2.txt");

//
        for (int i = 0; i < productArrayList.size(); i++) {

            if (productArrayList.get(i) instanceof SoftToys) {
                String details = productArrayList.get(i).getId() + ";" + productArrayList.get(i).getName() + ";" + productArrayList.get(i).getType() + ";" + productArrayList.get(i).getPrice() + ";" +
                        productArrayList.get(i).getAvailable() + ";" + ((SoftToys) productArrayList.get(i)).getAgeGroup();
                DataInputOutput.WriteDetails("products2.txt", details);
            } else if (productArrayList.get(i) instanceof Clothes) {
                String details1 = productArrayList.get(i).getId() + ";" + productArrayList.get(i).getName() + ";" + productArrayList.get(i).getType() + ";" + productArrayList.get(i).getPrice() + ";" +
                        productArrayList.get(i).getAvailable() + ";" + ((Clothes) productArrayList.get(i)).getColor();
                DataInputOutput.WriteDetails("products2.txt", details1);


            }
        }
    }

    // Formatted Printing (Amended Example from Lecture)

    // This method writes the product to the file products2.txt
    public void writeProductToFile(Product product) {
        for (Product p : productArrayList) {
            if (p instanceof SoftToys) {
                String details = product.getId() + ";" + product.getName() + ";" + product.getType() + ";" + product.getPrice() + ";" + product.getAvailable() + ";" + ((SoftToys) product).getAgeGroup();
                DataInputOutput.WriteDetails("products2.txt", details);
            } else if (p instanceof Clothes) {
                String details = product.getId() + ";" + product.getName() + ";" + product.getType() + ";" + product.getPrice() + ";" + product.getAvailable() + ";" + ((Clothes) product).getColor();
                DataInputOutput.WriteDetails("products2.txt", details);
            }

        }
    }

    public ArrayList <Product> getAvailableProducts() {
        return productArrayList;

    }

    public void setAvailableProducts(ArrayList <Product> productArrayList) {
        this.productArrayList = productArrayList;
    }
}
