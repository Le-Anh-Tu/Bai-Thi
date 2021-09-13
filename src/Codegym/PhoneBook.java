package Codegym;

public class PhoneBook extends Person {
    private String phoneNumber;
    private String address;
    private String email;

    public PhoneBook() {
    }

//    public PhoneBook(String phoneNumber, String address, String email) {
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.email = email;
//    }

    public PhoneBook(String id, String group, String name, String genDer, String dateOfBirth, String phoneNumber, String address, String email) {
        super(id, group, name, genDer, dateOfBirth);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return getId() + "," + phoneNumber + "," + getGroup() + "," + getName() + "," + getGenDer() + "," + address + "," + getDateOfBirth() + "," + email;
    }


}
