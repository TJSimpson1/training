package com.fdmgroup.threading.reentrantReadWrite;

public class ReentrantReadWriteDemo {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(150.75);
		
		ReaderThread readerThread1 = new ReaderThread(bankAccount);
		ReaderThread readerThread2 = new ReaderThread(bankAccount);
		ReaderThread readerThread3 = new ReaderThread(bankAccount);
		ReaderThread readerThread4 = new ReaderThread(bankAccount);
		WriterThread writerThread1 = new WriterThread(bankAccount,25.2);
		WriterThread writerThread2 = new WriterThread(bankAccount,86.4);
		
		readerThread1.setName("reader thread 1");
		readerThread2.setName("reader thread 2");
		readerThread3.setName("reader thread 3");
		readerThread4.setName("reader thread 4");
		writerThread1.setName("writer thread 1");
		writerThread2.setName("writer thread 2");
		
		readerThread1.start();
		readerThread2.start();
		readerThread3.start();
		writerThread1.start();
		writerThread2.start();
		readerThread4.start();

	}

}
