package src;

import entity.CellPhone;
import entity.GenuinePhone;
import entity.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    private static List<Phone> phones = new ArrayList<>();
    private static final String FILE_PATH = "/Users/minhquan/Documents/final-module-2/src/mobiles.csv";
    Scanner scanner = new Scanner(System.in);

    public static void loadPhonesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String phoneName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    String producer = parts[4];
                    phones.add(new Phone(id, phoneName, price, quantity, producer));
                } else if (parts.length == 7) {
                    int id = Integer.parseInt(parts[0]);
                    String phoneName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    String producer = parts[4];
                    String warrantyPeriod = parts[5];
                    String warrantyScope = parts[6];
                    phones.add(new GenuinePhone(id, phoneName, price, quantity, producer, warrantyPeriod, warrantyScope));
                } else if (parts.length == 8) {
                    int id = Integer.parseInt(parts[0]);
                    String phoneName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int quantity = Integer.parseInt(parts[3]);
                    String producer = parts[4];
                    String portableCountry = parts[5];
                    String status = parts[6];
                    phones.add(new CellPhone(id, phoneName, price, quantity, producer, portableCountry, status));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPhone() {
        try {
            System.out.print("Enter phone name: ");
            String phoneName = scanner.nextLine();
            System.out.print("Enter price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter producer: ");
            String producer = scanner.nextLine();

            System.out.println("Phone type (1 - Genuine Phone, 2 - Regular Phone): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter warranty period: ");
                String warrantyPeriod = scanner.nextLine();
                System.out.print("Enter warranty scope: ");
                String warrantyScope = scanner.nextLine();

                GenuinePhone genuinePhone = new GenuinePhone(phones.size() + 1, phoneName, price, quantity, producer, warrantyPeriod, warrantyScope);
                phones.add(genuinePhone);
            } else {
                System.out.println("Enter portable country: ");
                String portableCountry = scanner.nextLine();
                System.out.print("Enter status: ");
                String status = scanner.nextLine();

                CellPhone cellPhone = new CellPhone(phones.size() + 1, phoneName, price, quantity, producer, portableCountry, status);
                phones.add(cellPhone);
                saveRecordsToFile(); 

            }
            System.out.println("Phone added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deletePhone() {
        try {
            System.out.println("Enter the id to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            boolean found = false;
            Iterator<Phone> iterator = phones.iterator();
            while (iterator.hasNext()) {
                Phone phone = iterator.next();
                if (phone.getId() == id) {
                    System.out.print("Bạn có chắc muốn xóa không? (Yes/No): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("Yes")) {
                        iterator.remove();
                        saveRecordsToFile();
                        System.out.println("Xóa điện thoại thành công.");
                    }
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Không tìm thấy điện thoại với mã số đã nhập.");
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            System.out.println("Mã số điện thoại không hợp lệ.");
        }
    }


    public void displayPhone() {
        for (Phone phone : phones) {
            phone.display();
        }
    }

    public static void saveRecordsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Phone phone : phones) {
                if (phone instanceof GenuinePhone) {
                    GenuinePhone gen = (GenuinePhone) phone;
                    bw.write(gen.getId() + "," + gen.getPhoneName() + "," + gen.getPrice() + "," + gen.getQuantity() + "," + gen.getProducer() + "," + gen.getWarrantyPeriod() + "," + gen.getWarrantyScope());
                } else if (phone instanceof CellPhone) {
                    CellPhone cel = (CellPhone) phone;
                    bw.write(cel.getId() + "," + cel.getPhoneName() + "," + cel.getPrice() + "," + cel.getQuantity() + "," + cel.getProducer() + "," + cel.getPortableCountry() + "," + cel.getStatus());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
