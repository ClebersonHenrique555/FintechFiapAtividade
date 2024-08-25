package br.com.fintech.model;


public class Client {
    private String fullName;
    private String dateOfBirth;
    private int rg;

    public Client(String dateOfBirth, String fullName, int rg) {
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.rg = rg;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
