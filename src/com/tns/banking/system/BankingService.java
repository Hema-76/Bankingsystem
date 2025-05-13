package com.tns.banking.system;
import java.util.Collection;
import java.util.List;

public interface BankingService {
	void addCustomer (customer customer);
	void addAccount (Account account);
	void addTransaction (Transaction transaction);
	void addBeneficiary (Beneficiary beneficiary);
	
	customer findcustomerById(int id);
	Account findAccountById(int id);
	Transaction findTransactionById(int id);
	Beneficiary findBeneficiaryById(int id);
	
	Collection<Account> getAllAccounts();
	Collection<customer> getAllCustomers();
	Collection<Transaction> getAllTransactions();
	Collection<Beneficiary> getAllBeneficiaries();
	
	List<Account> getAccountsBycustomerId (int customerId);
	List<Transaction> getTransactionsByAccountId(int accountId);
	List<Beneficiary> getBeneficiariesBycustomerId (int customerId);
	}



