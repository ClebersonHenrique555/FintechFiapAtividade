package br.com.fintech.model;

public class PhysicalAccount extends Account{
    private Client client;
    private int cpf;

    public PhysicalAccount(int cpf, Client client) {
        this.cpf = cpf;
        this.client = client;

    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount. It must be greater than zero.");
            }

            if (this.getBalance() >= amount) {
                this.setBalance(this.getBalance() - amount);
                System.out.println("Withdrawal completed successfully! Current balance: " + this.getBalance());
            } else {
                System.out.println("The withdrawal was not carried out. Insufficient balance.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public void deposit(double value, PhysicalAccount physicalAccount){
        if(value > 0 && this.getBalance() >= value){
            this.setBalance(this.getBalance() - value);
            physicalAccount.setBalance(physicalAccount.getBalance() + value);
            System.out.println("Deposit made successfully!");
            System.out.println("Details of the recipient:");
            System.out.println("RG number: " + physicalAccount.getClient().getRg());
            System.out.println("Name: " + physicalAccount.getClient().getFullName());
        }else{
            System.out.println("The deposit was not carried out. Insufficient balance or the value entered is invalid.");
        }
    }
}

