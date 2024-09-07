import java.io.IOException;
import java.util.*;

public class ECommerceSystem {

    private static List<Product> products = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        try {
            FileOperations.checkOrCreateFile("products.txt");
            FileOperations.checkOrCreateFile("orders.txt");
            products = FileOperations.readProductsFromFile("products.txt");
            } catch (IOException e) {
            System.err.println("Dosya işlemi sırasında hata: " + e.getMessage());
        }

             // Müşteri ekle
        Customer customer = new Customer("C001", "John Doe", "john@example.com");
        customers.add(customer);


        // Sipariş oluştur
        try {
            Product product = products.get(0); // İlk ürünü al
            if (product.getStock() < 1) {
                throw new OutOfStockException("Ürün stokta yok!");
            }
            Order order = new Order("O001", product, customer, 1, new Date());
            orders.add(order);

            // Siparişi dosyaya yaz
            FileOperations.writeOrderToFile(order, "orders.txt");

            // Stok güncelle
            product.setStock(product.getStock() - 1);

        } catch (OutOfStockException e) {
            System.err.println("Sipariş hatası: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }

        // Sistemdeki tüm siparişleri yazdır
        orders.forEach(System.out::println);
    }
}