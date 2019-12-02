package com.cop4331.shopping_cart_app.databases;

import java.io.File;
import java.util.ArrayList;

import com.cop4331.shopping_cart_app.account.Account;
import com.cop4331.shopping_cart_app.account.Customer;
import com.cop4331.shopping_cart_app.account.JsonLoadAccounts;
import com.cop4331.shopping_cart_app.account.JsonSaveAccounts;
import com.cop4331.shopping_cart_app.account.Seller;
import com.cop4331.shopping_cart_app.filemanager.ILoad;
import com.cop4331.shopping_cart_app.filemanager.ISave;

/**
 *
 * @author Justin Ament
 */
public class AccountDB {
    public static int CURRENTACCOUNT_ID = -1;
    private static ArrayList<Account> accounts;
    private static String fileName="Accounts.json";
    
    public static void init() {
    	
    	if(ifFileExists()) {
			load();
		}else {
			createInitialAccounts();
			save();
		}
    }
    
    //Returns true if the account is in the database, returns false if not
    //use getAccount method next
    public static boolean verify(String username, String password) {
    	for(int i=0; i<accounts.size(); i++) {
    		if(accounts.get(i).getUsername()==username && accounts.get(i).getPassword()==password) {
    			return true;
    		}
    	}
    	return false;
    }
    
    protected static Account getAccByUsername(String username) {
    	
    	for(int i=0; i<accounts.size(); i++) {
    		if(accounts.get(i).getUsername().equals(username)) {
    			return accounts.get(i);
    		}
    	}
    	return new Account();
    }
    
    
    //Returns an empty account if the account is not found, else returns the count if it is found
    //Method to be called after verify methodS
    public static Account getAccount(String username, String password) {
    	for(int i=0; i<accounts.size(); i++) {
    		if(accounts.get(i).getUsername()==username && accounts.get(i).getPassword()==password) {
    			return accounts.get(i);
    		}
    	}
    	return new Account();
    }
    
    public static int getAccountID(String username, String password) {
    	for(int i=0; i<accounts.size(); i++) {
    		Account a = accounts.get(i);
    		if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static Account getAccount(int id) {
    	return accounts.get(id);
    }
    
    public static void createInitialAccounts() {
    	accounts=new ArrayList<Account>();
    	accounts.add(new Customer("michael", "1234",""));
    	accounts.add(new Seller("justin", "1234"));
    	accounts.add(new Seller("HP", "1234"));
    	accounts.add(new Seller("Dell", "1234"));
    	accounts.add(new Seller("Western Digital", "1234"));
    	accounts.add(new Seller("Corsair", "1234"));
    	
    }
    
    public static void save() {
    	ISave<Account> accountSaver=new JsonSaveAccounts();
    	accountSaver.save(fileName, accounts);
    }
    
    public static void load() {
    	ILoad<Account> accountLoader = new JsonLoadAccounts();
    	accounts = accountLoader.load(fileName);
    }
    
    private static boolean ifFileExists() {
		return new File(fileName).exists();
	}
}
