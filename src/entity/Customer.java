package entity;

public class Customer extends User {
    private String name;
    private String cccd;
    private String gplx;


    public Customer() {
    }

    public Customer(String name, String cccd, String gplx) {
        this.name = name;
        this.cccd = cccd;
        this.gplx = gplx;
    }

    public Customer(int id, String username, String password, String name, String cccd, String gplx) {
        super(id, username, password);
        this.name = name;
        this.cccd = cccd;
        this.gplx = gplx;
    }

    public Customer(String username, String password, String phone, String email, String name, String cccd, String gplx) {
        super(username, password, phone, email);
        this.name = name;
        this.cccd = cccd;
        this.gplx = gplx;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getGplx() {
        return gplx;
    }

    public void setGplx(String gplx) {
        this.gplx = gplx;
    }
    public String[] toArray() {
        return new String[] {username, password, name, phone, email, String.valueOf(cccd), gplx};
    }
}
