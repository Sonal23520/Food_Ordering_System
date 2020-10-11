package lk.com.foodOrdering.view.tm;

import com.jfoenix.controls.JFXButton;

public class CustomerTM {

    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private int phoneno;
    private String province;
    private int postalcode;

    public CustomerTM() {
    }

    public CustomerTM(int id, String fname, String lname, String email, String password, int phoneno, String province, int postalcode) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
        this.province = province;
        this.postalcode = postalcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneno=" + phoneno +
                ", province='" + province + '\'' +
                ", postalcode=" + postalcode +
                '}';
    }
}
