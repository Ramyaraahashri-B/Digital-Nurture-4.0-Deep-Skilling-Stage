import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Product class
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int id, String name, String category) {
            this.productId = id;
            this.productName = name;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

    // Linear Search (O(n))
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (O(log n)) - works only on sorted array
    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(name);
            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Step 1: Setup product data
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Backpack", "Bags")
        };

        String searchTarget = "Phone";

        // Step 2: Linear Search
        System.out.println("🔍 Linear Search:");
        Product foundLinear = linearSearch(products, searchTarget);
        System.out.println(foundLinear != null ? "Found: " + foundLinear : "Product not found");

        // Step 3: Binary Search (after sorting the array by product name)
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("\n🔍 Binary Search (after sorting):");
        Product foundBinary = binarySearch(products, searchTarget);
        System.out.println(foundBinary != null ? "Found: " + foundBinary : "Product not found");

        // Step 4: Time complexity comparison (in comments)
        /*
         * 🔍 Complexity Analysis:
         * Linear Search: O(n) - Best: O(1), Average/Worst: O(n)
         * Binary Search: O(log n) - Only for sorted data
         *
         * ✅ Recommendation:
         * Use Binary Search for faster results in large datasets, but ensure the data is sorted.
         * For small or unsorted datasets, Linear Search is simpler to implement.
         */
    }
}
