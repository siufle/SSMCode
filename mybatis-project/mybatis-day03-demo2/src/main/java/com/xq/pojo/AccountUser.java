package com.xq.pojo;

public class AccountUser extends Account{
    private String username;

    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + super.getId() + '\'' +
                ", uid=" + super.getUid() + '\'' +
                ", money=" + super.getMoney() + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
