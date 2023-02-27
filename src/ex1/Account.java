package ex1;

public class Account {
	   public static Account account;
	   private static int balance = 1000;
	   private static Person person;

	   private Account() {
	   }

	   public static Account getAccount(Person p) {
	       if (account == null) {
	           account = new Account();
	       }
	       Account.person = p;
	       return account;
	   }

	   public static int getBal() {
	       return balance;
	   }

	   public synchronized void withdraw(int bal) {
	       try {

	           if (balance >= bal) {
	               System.out.println(person.getName() + " " + "withdraw");
	               try {
	                   Thread.sleep(100);
	               } catch (Exception e) {
	                   e.printStackTrace();
	               }
	               balance = balance - bal;
	               System.out.println(person.getName() + " " + "withdraw complete");
	               System.out.println();
	           } else {
	               System.out.println(person.getName() + " " + "not enough money to withdraw");
	           }
	           System.out.println(person.getName() + " " + " withdrew $" + bal + " Current balance: $"+ balance);
	           System.out.println();
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }

	   public synchronized void deposit(int bal) {
	       try {
	           if (bal > 0) {
	               System.out.println(person.getName() + " " + "deposit");
	               try {
	                   Thread.sleep(100);
	               } catch (Exception e) {
	                   e.printStackTrace();
	               }
	               balance = balance + bal;
	               System.out.println(person.getName() + " " + "deposit complete");
	               System.out.println();
	           } else {
	               System.out.println(person.getName() + " " + "not enough money to deposit");
	           }
	           System.out.println(person.getName() + " " + " deposited $" + bal + " Current balance: $" + balance);
	           System.out.println();
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }
	}
