package model;

public interface BankProc {
	/*
	 * Precondition:client different from null
	 */
	void addClient(Client client);
	/*
	 * Precondition:client different from null
	 * Precondition:No client with matching ssn was found
	 */
	void editClient(Client client);
	/*
	 * Precondition:ssn different from null
	 * Postcondition:bank.size() is one smaller
	 */
	void removeClient(String ssn);
	/*
	 * Precondition:client different from null, account different from null
	 * Postcondition:Client was not found
	 */
	void addAccount(Client client, Account account);
	/*
	 * Precondition:Precondition:Client object different from null, account different from null
	 * Postcondition:Client was not found
	 */
	void editAccount(Client client, Account account);
	/*
	 * Precondition:accId different from null,client different from null
	 * Postcondition:Client was not found
	 */
	void removeAccount(Client client, int accId);
	/*
	 * Precondition:accId != null, client !=null, amount > 0
	 *
	 */
	void deposit(Client client, int accId, double amount);
	/*
	 * Precondition:accId != null, client !=null, amount > 0
	 */
	void withdraw(Client client, int accId, double amount);

}
