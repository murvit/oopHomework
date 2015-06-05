package lesson7.threads.accounttask1and4;

public class Account {

	int money;
	
	public Account(int money) {
		this.money = money;
	}
	
	public int get() {
		return money;
	}
	
	public void set(int x) {
		money = x;
	}
}
