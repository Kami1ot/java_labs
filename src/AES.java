import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class AES {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;

    public static void main(String[] args) {
        try {
            // Генерация ключа
            SecretKey secretKey = generateKey();

            // Сохранение ключа в строковом формате (для демонстрации)
            String keyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Секретный ключ (Base64): " + keyString);

            // Ввод имени исходного и выходного файлов
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите имя файла с исходными данными:");
            String inputFile = consoleReader.readLine();
            System.out.println("Введите имя файла для сохранения зашифрованных данных:");
            String encryptedFile = consoleReader.readLine();
            System.out.println("Введите имя файла для сохранения расшифрованных данных:");
            String decryptedFile = consoleReader.readLine();

            // Чтение данных из файла
            String data = readFromFile(inputFile);
            System.out.println("Исходные данные: " + data);

            // Шифрование данных
            String encryptedData = encrypt(data, secretKey);
            System.out.println("Зашифрованные данные: " + encryptedData);
            writeToFile(encryptedFile, encryptedData);

            // Дешифрование данных
            String decryptedData = decrypt(encryptedData, secretKey);
            System.out.println("Расшифрованные данные: " + decryptedData);
            writeToFile(decryptedFile, decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Генерация секретного ключа
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE);
        return keyGen.generateKey();
    }

    // Шифрование данных
    private static String encrypt(String data, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Дешифрование данных
    private static String decrypt(String encryptedData, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    // Чтение данных из файла
    private static String readFromFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    // Запись данных в файл
    private static void writeToFile(String fileName, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        }
    }
}

