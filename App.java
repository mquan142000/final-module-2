import src.PhoneManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PhoneManager phoneManager = new PhoneManager();
        PhoneManager.loadPhonesFromFile();
        PhoneManager.saveRecordsToFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI -----");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    phoneManager.addPhone();
                    break;
                case 2:
                    phoneManager.deletePhone();
                    break;
                case 3:
                    phoneManager.displayPhone();
                    break;
                case 4:
                    phoneManager.searchPhone();
                    break;
                case 0:
                    System.out.println("Bạn đã thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
        }


    }
}
