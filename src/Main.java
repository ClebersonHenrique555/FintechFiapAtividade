import br.com.fintech.model.Account;
import br.com.fintech.model.Client;
import br.com.fintech.model.PhysicalAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;
        PhysicalAccount physicalAccount = null;

        do {
            System.out.println("==== MENU ====");
            System.out.println("Option 1: Register new customer - natural person.");
            System.out.println("Option 2: Make withdrawal.");
            System.out.println("Option 3: Make transfer.");
            System.out.println("Option 4: Your balance.");
            System.out.println("Option 5: To go out ");
            System.out.print("Choose an option: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("You chose Option 1. We will collect some data. Please, provide your RG: ");
                    int rg = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter full name: ");
                    String fullName = scanner.nextLine();

                    System.out.println("Enter your date of birth: ");
                    String dateOfBirth = scanner.nextLine();

                    Client client = new Client(dateOfBirth, fullName, rg);

                    System.out.println("Now enter your CPF: ");
                    int cpf = scanner.nextInt();
                    physicalAccount = new PhysicalAccount(cpf, client);
                    physicalAccount.setBalance(10000.00);
                    break;
                case 2:
                    if (physicalAccount != null) {
                        System.out.println("You chose Option 2. Withdraw");
                        System.out.println("Your current balance: " + physicalAccount.getBalance());
                        System.out.print("Please, enter the amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        physicalAccount.withdraw(amount);
                    } else {
                        System.out.println("You need to register a customer before making a withdrawal.");
                    }
                    break;
                case 3:
                    if (physicalAccount != null){
                        System.out.println("You chose Option 3. Transfer");
                        System.out.println("Your current balance: " + physicalAccount.getBalance());
                        System.out.print("Please, enter the amount to transfer ");
                        double amount = scanner.nextDouble();
                        Client clientTest = new Client("15/07/1982", "João Henrique", 846641961);
                        PhysicalAccount account = new PhysicalAccount(53679245, clientTest);
                        physicalAccount.deposit(amount, account);

                    }
                    break;
                case 4:
                    System.out.println("Your balance: " + physicalAccount.getBalance());
                    break;
                case 5:
                    System.out.println("Leaving...");
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println();
        } while (opcao != 5);

        scanner.close();
    }


    }
