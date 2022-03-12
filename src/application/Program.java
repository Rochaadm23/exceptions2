package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.next();
			System.out.print("Initial balance: ");
			double inBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double wdLimit = sc.nextDouble();

			Account acc = new Account(number, holder, inBalance, wdLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double withdraw = sc.nextDouble();
			acc.withdraw(withdraw);

			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));

		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();

	}

}
