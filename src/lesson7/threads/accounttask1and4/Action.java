package lesson7.threads.accounttask1and4;

import java.util.concurrent.locks.ReentrantLock;

public class Action extends Thread {

    Account acc;
    int withdraw;

    public Action(Account acc, int withdraw) {
        this.acc = acc;
        this.withdraw = withdraw;
    }

    public void run() {
        ReentrantLock theLock  = new ReentrantLock();
        theLock.lock();
        int has = acc.get();
        if (has >= withdraw + 100) {
            acc.set(acc.get() - withdraw);
        } else System.out.println("You can`t withdraw. You have only $" + acc.get());
        theLock.unlock();
    }

}
