package com.tns.banking.system;
import java.util.List;
import java.util.Scanner;
import com.tns.banking.system.BankingService;

public class BankingSystemApp {

public static void main(String[] args) {
BankingService bankingService = new BankingServiceImpl();
int customerID;
int accountID11;
String type;
double balance;
int beneficiaryID;
String name;
String accountNumber;
String bankDetails;
String address;
String contact;
int transactionID;
double amount;
int ch;
Scanner sc = new Scanner(System.in);
do {
System.out.println("Banking System");
System.out.println("1. Add Customers");
System.out.println("2. Add Accounts");
System.out.println("3. Add Beneficiary");
System.out.println("4. Add Transaction");
System.out.println("5. Find Customer by Id ");
System.out.println("6. List all Accounts of specific Customer");
System.out.println("7. List all transactions of specific Account");
System.out.println("8. List all beneficiaries of specific customer");
System.out.println("9. Exit");
System.out.println("Enter your choice: ");
ch =sc.nextInt();
switch(ch){
case 1:
System.out.println("Enter Customer Details");
System.out.print("Cutomer Id: ");
customerID = sc.nextInt();
System.out.print("Name: ");
sc.nextLine();
name = sc.nextLine();
System.out.print("Address: ");
address = sc.nextLine();
System.out.print("Contact No. : ");
contact = sc.nextLine();
customer c = new customer (customerID, name, address, contact);
bankingService.addCustomer(c);
break;

case 2:
	System.out.println("Enter Account Details");
	System.out.print("AccountId: ");
	 int accountID1 = sc.nextInt();
	System.out.print("Customer Id: ");
	customerID = sc.nextInt();
	sc.nextLine();
	System.out.print("Account Type Saving/ Current: ");
	type = sc.nextLine();
	System.out.print("Balance: ");
	balance = sc.nextDouble();
	Account account = new Account (  accountID1, customerID, type, balance);
	bankingService.addAccount (account);
	break;
	case 3:
		System.out.println("Enter Beneficiary Details");
		System.out.print("Customer Id: ");
		customerID = sc.nextInt();
		System.out.print("Benefiary Id: ");
		beneficiaryID= sc.nextInt();
		System.out.print("Beneficiary Name: ");
		sc.nextLine();
		name =sc.nextLine();
		System.out.print("Beneficiary Account No. : ");
		accountNumber = sc.nextLine();
		System.out.print("Beneficiary Bank details: ");
		bankDetails =sc.nextLine();
		Beneficiary b =new Beneficiary (customerID, beneficiaryID, name, accountNumber, bankDetails);
		bankingService.addBeneficiary (b);
		break;
	case 4:

		System.out.println("Enter Transaction Details");
		System.out.print("Account Id: ");
		accountID11= sc.nextInt();
		sc.nextLine();
		System.out.print("Tyep (Deposit/Withdraw: ");
		type =sc.nextLine();
		System.out.print("Account Amount: ");
		amount = sc.nextDouble();
		Transaction t= new Transaction (accountID11, type, amount);
		bankingService.addTransaction(t);
		break;
	case 5:
		for (customer customer: bankingService.getAllCustomers()) {
		System.out.println("cutomer ID: " + customer.getcustomerID() + ", Name:" + customer.getName());
		}
		System.out.print("Customer Id: ");
		customerID= sc.nextInt();
		@SuppressWarnings("unused") customer foundcustomer =bankingService.findcustomerById(customerID);
	case 6:
		for (Account account1 :bankingService.getAllAccounts()) {
		System.out.println("Account ID: " + account1.getAccountID() + ", customer ID: "+account1.getCustomerID()+", Balance: "+ account1.getName());
		}
		System.out.print("Customer Id: ");
		customerID =sc.nextInt();
		List<Account> customerAccounts =bankingService.getAccountsBycustomerId(customerID);
		System.out.println("Accounts for Customer ID:" + customerID);
		for (Account accountID111: customerAccounts) {
		System.out.println("Account ID: " + accountID111.getAccountID() + ", Balance: "+ accountID111.getBalance());
		}
				break;
		
		case 7:
			System.out.print("Account Id: ");
			accountID11= sc.nextInt();
			List<Transaction> accountTransactions =bankingService.getTransactionsByAccountId(accountID11);
			System.out.println("Transactions for Account ID:" + accountID11);
			for (Transaction transaction: accountTransactions) {
			System.out.println("Transaction ID: " + transaction.getTransactionID() + ", Type:"
			+ transaction.getType()+", Amount: " + transaction.getAmount()+", Timestamp:"
			+ transaction.getTimestamp());
			}
			break;
			case 8:
			System.out.print("Customer Id: ");
			customerID = sc.nextInt();
			List<Beneficiary> customerBeneficiaries =bankingService.getBeneficiariesBycustomerId(customerID);
			System.out.println("Beneficiaries for customer ID :"+ customerID);
			for (Beneficiary beneficiary :customerBeneficiaries) {
			System.out.println(
			"Beneficiary ID: " + beneficiary.getBeneficiaryID() + ", Name:" + beneficiary.getName()); 
			}
			break;
			case 9:
			System.out.println("Thank you!");
			break;
			default:
				System.out.println("Invalid Choice");
				}
				} while(ch!=9);
}}