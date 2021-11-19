package banking;

import java.util.Scanner;

public class BankAccount {
	// saldo que a conta possui
	private int balance;
	
	// valor da última quantidade depositada ou saquada
	private int previousTransaction;
	
	// Nome do cliente proprietário da conta.
	private String customerName;
	
	// identificação do cliente no sistema.
	private String customerID;
	
	
	public BankAccount(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}
	
	/*
	 * @param quantidade para depositar na conta
	 * 
	 * */
	public void deposit(int amount) {
		// Se amount for uma valor válido, acrescenta
		// o valor no saldo existente da conta.
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	/*
	 * @param Quantidade para saquar da conta
	 * 
	 * */
	public void withdraw(int amount) {
		// Se amount for um valor válido e 
		// for menor ou igual a balance, então
		// o saque pode ser realizado.
		if (amount != 0 && amount <= balance) {
			balance -= amount;
			// Quando o saque é realizado um número negativo é armazenado
			// indicando que foi saquado a quantidade de amount.
			previousTransaction = -amount;
		}
	}
	
	/*
	 * Recupera o valor da última transação realizada com sucesso.
	 * 
	 * */
	public void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
			
		} else if (previousTransaction < 0) {
			// Quando o saque é realizado o valor tem valor negativo.
			// o método abs transforma o valor em positivo.
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
			
		} else {
			System.out.println("No transaction occured");
		}
	}
	
	public void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		String infoCustomer = "Welcome " + customerName + "\n" + "Your ID is: " + customerID;
		String options = 
				  "A. Check balance\n"
				+ "B. Deposit\n"
				+ "C. Withdraw\n"
				+ "D. Previous transaction\n"
				+ "E. Exit";
		
		System.out.println(infoCustomer);
		System.out.println(options);
		
		System.out.println();
		
		do {
			System.out.print("Choose a option: ");
			option = scanner.next().toUpperCase().charAt(0);
			
			switch (option) {
				case 'A':
					System.out.println(
							"---------------------------------------------\n" 
							+ balance
							+ "\n---------------------------------------------");
					break;
					
				case 'B':
					System.out.print(
							"---------------------------------------------\n" 
							+ "Enter an amount to deposit: "
							+ "\n---------------------------------------------\n");
					int newAmountDeposit = scanner.nextInt();
					deposit(newAmountDeposit);
					System.out.println();
					break;
				
				case 'C':
					System.out.println(
							"---------------------------------------------\n" 
							+ "Enter an amount to withdraw:"
							+ "\n---------------------------------------------");
					int newAmountWithdraw = scanner.nextInt();
					withdraw(newAmountWithdraw);
					System.out.println();
					break;
				
				case 'D':
					System.out.println("---------------------------------------------");
					getPreviousTransaction();
					System.out.println("---------------------------------------------");
					System.out.println();
					break;
					
				default:
					System.out.println("Invalid option. Please try again");
					break;
			}
		} while (option != 'E');
		
		System.out.println("Thank you for using our services");
		
	}
}
