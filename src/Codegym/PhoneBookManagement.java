package Codegym;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement {
    List<PhoneBook> phoneBooks = new ArrayList<>();

    public List<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void setPhoneBooks(List<PhoneBook> phoneBooks) {
        this.phoneBooks = phoneBooks;
    }

    public void showAll() {
        for (PhoneBook phoneBook : phoneBooks) {
            System.out.println(phoneBook);
        }
    }

    public void addNew(PhoneBook phoneBook) {
        this.phoneBooks.add(phoneBook);
    }

    public void updateById(String id, PhoneBook phoneBook) {
        int index = finById(id);
        if (index != -1) {
            phoneBooks.set(index, phoneBook);
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public void removeById(String id) {
        int index = finById(id);
        if (index != -1) {
            phoneBooks.remove(index);
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public int finById(String id) {
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int finByName(String name) {
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public int finByPhoneNumber(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < phoneBooks.size(); i++) {
            if (phoneBooks.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
