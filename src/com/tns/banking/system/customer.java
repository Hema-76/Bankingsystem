package com.tns.banking.system;

public class customer {
	private int customerID;
    private String name;
    private String address;
    private String contact;
    public customer (int customerID, String name, String address, String contact) {
       this.customerID = customerID;
       this.name = name;
       this.address = address;
       this.contact= contact;
   }
    public int getcustomerID() { return customerID; }
	public String getName() { return name; }
	public String getAddress() { return address; }
    public String getContact() { return contact; }
    public void setName (String name) { this.name = name; }
    public void setAddress (String address) { this.address = address;}
    public void setContact (String contact) { this.contact = contact;}	
}
