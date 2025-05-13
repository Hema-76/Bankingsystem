package com.tns.banking.system;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class BankingServiceImpl implements BankingService {
    public BankingServiceImpl() {}
    
	private Map<Integer, customer> customers = new HashMap<>();
	private Map<Integer, Account> accounts =new HashMap<>();
	private Map<Integer, Transaction> transactions= new HashMap<>();
	private Map<Integer, Beneficiary> beneficiaries =new HashMap<>();
	@Override
	public void addCustomer (customer customer) {
			customers.put(customer.getcustomerID(), customer);
	}
			@Override
			public void addAccount (Account account) {
			accounts.put(account.getAccountID(), account);
			}
			@Override
			public void addTransaction (Transaction transaction) {
					transactions.put (transaction.getTransactionID(), transaction);
					Account account = accounts.get(transaction.getAccountID());
					if (account != null) {
				    	if (transaction.getType().equalsIgnoreCase ("deposit")) {
					account.setBalance (account.getBalance() + transaction.getAmount()); }
					 else if (transaction.getType().equalsIgnoreCase ("withdrawal")) {
						account.setBalance (account.getBalance () - transaction.getAmount());
					}

					}						
			}
						@Override
						public void addBeneficiary (Beneficiary beneficiary) {
								beneficiaries.put(beneficiary.getBeneficiaryID(), beneficiary);
						}
				
	             	@Override
								public customer findcustomerById(int id) {
								return customers.get(id);
	             	}
	             	public Account findAccountById(int id) {
	        			return accounts.get(id);
	        			}
	        			public Transaction findTransactionById(int id) {
	        			return transactions.get(id);
	        			}
	        			public Beneficiary findBeneficiaryById(int id) {
	        			return beneficiaries.get(id);
	        			}
	        	
	        			public List<Account> getAccountsByCustomerId(int customerId) {
	        				List<Account> result = new ArrayList<>();
	        				for (Account account: accounts.values()) {
	        				if (account.getCustomerID() == customerId) {
	        				result.add(account);
	        				}
	        				}
	        				return result;
	        				}
	        				public List<Transaction> getTransactionsByAccountId(int accountId) {
	        				List<Transaction> result = new ArrayList<>();
	        				for (Transaction transaction : transactions.values()) {
	        				if (transaction.getAccountID() == accountId) {
	        					result.add(transaction);
	        				}
	        				}
	        				return result;
	        				}
	        				public List<Beneficiary> getBeneficiariesByCustomerId(int customerId) {
	        					List<Beneficiary> result = new ArrayList<>();
	        					for (Beneficiary beneficiary: beneficiaries.values()) {
	        					if (beneficiary.getCustomerID () == customerId) {
	        						result.add (beneficiary);
	        					}
	        					}
	        					return result;
	        					}
	        					public Collection<Account> getAllAccounts() {
	        					return accounts.values();
	        					}
	        					public Collection<customer> getAllCustomers() {
	        					return customers.values();
	        					}
	        					public Collection<Transaction> getAllTransactions() {
	        					return transactions.values();
	        					}
	        					public Collection<Beneficiary> getAllBeneficiaries() {
	        					return beneficiaries.values();
	        					}
								@Override
								public List<Account> getAccountsBycustomerId(int customerId) {
									// TODO Auto-generated method stub
									return null;
								}
								@Override
								public List<Beneficiary> getBeneficiariesBycustomerId(int customerId) {
									// TODO Auto-generated method stub
									return null;
								}
	        					}

