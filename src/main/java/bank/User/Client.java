package bank.User;

import java.util.Date;

public class Client{
    private String firstname;

    private String lastname;

    private String email;

    private String phone;

    private String nationalIdNumber;

    private float money;

    private Gender gender;

    private Date birthday;

    private int id;

    private String username;

    private String password;

    public Client(String firstname, String lastname, String email, String phone, String nationalIdNumber, float money, Gender gender, Date birthday, int id, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.nationalIdNumber = nationalIdNumber;
        this.money = money;
        this.gender = gender;
        this.birthday = birthday;
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Client(int id,float money){
        this.id = id;
        this.money = money;
    }
    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
