package app.model;

public class employee {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String image;

    public employee(String username, String password, String name, String email, String phone, String address, String image) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }

    public employee() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPhone() { return phone; }

    public String getAddress() { return address; }

    public String getImage() { return image; }
}
