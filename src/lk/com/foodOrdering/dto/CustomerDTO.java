package lk.com.foodOrdering.dto;

public class CustomerDTO {
    private int id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private int phoneno;
    private String province;
    private String addressline1;
    private String addressline2;
    private int postalcode;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String fname, String lname, String email, String password, int phoneno, String province, String addressline1, String addressline2, int postalcode) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.phoneno = phoneno;
        this.province = province;
        this.addressline1 = addressline1;
        this.addressline2 = addressline2;
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

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneno=" + phoneno +
                ", province='" + province + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", postalcode=" + postalcode +
                '}';
    }
}
