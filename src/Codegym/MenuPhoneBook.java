package Codegym;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuPhoneBook {
    public static Scanner scanner = new Scanner(System.in);
    public static PhoneBookManagement phoneBookManagement = new PhoneBookManagement();

    static {
        phoneBookManagement.addNew(new PhoneBook("1", "CodeGym", "Lê Anh Tú", "Nam", "28-02-1995", "0917686082", "Cầu Giấy", "leanhtu280295@gmail.com"));
        phoneBookManagement.addNew(new PhoneBook("2", "CodeGym", "ahihi", "Nam", "11-12-1996", "0998468734", "Ba Đình", "leanhtu280295@gmail.com"));
        phoneBookManagement.addNew(new PhoneBook("3", "CodeGym", "ahuhu", "Nữ", "29-09-1997", "0981527465", "Đống Đa", "leanhtu280295@gmail.com"));
    }

    public void run() {
        int choice;
        do {
            menuPhoneBook();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAll();
                    break;
                }
                case 2: {
                    addNew();
                    break;
                }
                case 3: {
                    updateById();
                    break;
                }
                case 4: {
                    removePhoneBook();
                    break;
                }
                case 5: {
                    searhPhoneBook();
                    break;
                }
                case 6: {
                    readDataToFile();
                    break;
                }
                case 7: {
                    writeDataToFile();
                    break;
                }

                default: {
                    System.out.println("Không hợp lệ !!! mời bạn chọn lại dùm");
                }
            }
        } while (choice != 0);
    }

    private void writeDataToFile() {
        System.out.println("Bạn có muốn ghi lại toàn bộ file không ??");
        System.out.println("Nhập Y để tiếp tục - Ấn phím bất kì để quay lại");
        String check = scanner.nextLine();
        if (!check.equals("Y")) {
            return;
        }
        List<PhoneBook> phoneBooks = phoneBookManagement.phoneBooks;
        try {
            FileWriter fileWriter = new FileWriter("data/contacts.csv");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (PhoneBook phoneBook : phoneBooks) {
                bw.write(String.valueOf(phoneBook));
                bw.newLine();
            }
            bw.close();
            System.out.println("Ghi vào file thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readDataToFile() {
        try {
            FileReader fileReader = new FileReader("data/contacts.csv");
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(Arrays.toString(line.split(",")));
            }
            br.close();
        } catch (IOException ie) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }

    private void searhPhoneBook() {
        System.out.print("Nhập vào số điện thoại hoặc họ tên để tìm kiếm trong danh bạ: ");
        String check = scanner.nextLine();
        int indexPhone = phoneBookManagement.finById(check);
        int indexName = phoneBookManagement.finByName(check);
        if (indexName != 1) {
            System.out.println("liên hệ mà bạn cần tìm");
            System.out.println(phoneBookManagement.getPhoneBooks().get(indexName));
        }else if (indexPhone != 1){
            System.out.println("liên hệ mà bạn cần tìm");
            System.out.println(phoneBookManagement.getPhoneBooks().get(indexPhone));
        }else {
            System.out.println("Không tìm thấy liên hệ nào phù hợp");
        }
    }

    private void removePhoneBook() {
        System.out.println("Xóa 1 số điện thoại");
        System.out.println("Nhập một số bất kỳ:");
        String id = scanner.nextLine();
        int index = phoneBookManagement.finById(id);
        if (index != -1) {
            System.out.println("Bạn có muốn xóa 1 số khỏi danh sách không");
            System.out.println("Bấm T để xóa, Bấm phím bất kỳ để thoát");
            String Ktr = scanner.nextLine();
            phoneBookManagement.removeById(id);
            System.out.println("Xong");
        }else {
            if (id.equals(""))
                System.out.println("Không tồn tại id này");
            return;
        }
        System.out.println("Mời bạn nhập lại");
        removePhoneBook();
    }


    private void updateById() {
        System.out.println("Chỉnh sửa thông tin");
        System.out.println("Nhập mã sản phẩm cần chỉnh sửa");
        String id = scanner.nextLine();
        int index = phoneBookManagement.finById(id);
        if (index != -1) {
            PhoneBook phoneBook = inputPhoneBook();
            phoneBookManagement.updateById(id, phoneBook);
        } else {
            if (id.equals("")){
                System.out.println("Không tồn tại id này");
                return;
            }
            System.out.println("Mời bạn nhập lại");
            updateById();
        }
    }

    private void addNew() {
        PhoneBook phoneBook = inputPhoneBook();
        phoneBookManagement.addNew(phoneBook);

    }

    private void showAll() {
        phoneBookManagement.showAll();
    }
    private static PhoneBook inputPhoneBook(){
        int count = 0;
        do {if (count > 0) {
            System.out.println("Bạn nhập sai rồi:");
        }
            System.out.println("Nhập thứ tự danh sách:");
            String id = scanner.nextLine();
            System.out.println("Nhập tên nhóm:");
            String group = scanner.nextLine();
            System.out.println("Nhập tên người:");
            String name = scanner.nextLine();
            System.out.println("Nhập giới tính:");
            String genDer = scanner.nextLine();
            System.out.println("Nhập ngày tháng năm sinh:");
            String dateOfBirth = scanner.nextLine();
            System.out.println("Nhập số điện thoại:");
            String phoneNumber = scanner.nextLine();
            System.out.println("Nhập địa chỉ:");
            String address = scanner.nextLine();
            System.out.println("Nhập email:");
            String email = scanner.nextLine();
            count++;
            return new PhoneBook(id, group, name, genDer, dateOfBirth, phoneNumber, address, email);
        }while (count ==0);
    }
    public static void menuPhoneBook(){
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chứ năng: ");
    }

}