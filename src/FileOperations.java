import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public static List<Product> readProductsFromFile(String fileName) throws IOException {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productData = line.split(",");
                products.add(new Product(productData[0], productData[1],
                        Integer.parseInt(productData[2]),
                        Double.parseDouble(productData[3])));
            }
        }
        return products;
    }

    public static void writeOrderToFile(Order order, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(order.toString());
            writer.newLine();
        }
    }

    // Dosya var mı kontrol et, yoksa oluştur
    public static void checkOrCreateFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
