import java.util.Objects;

public class Guest extends Person {
    private String phone;
    private String email;

    public Guest(String name, String phone, String email) {
        super(name);
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getRole() {
        return "Guest";
    }

    @Override
    public String toString() {
        return super.toString() + ", Phone: " + phone + ", Email: " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(email, guest.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
