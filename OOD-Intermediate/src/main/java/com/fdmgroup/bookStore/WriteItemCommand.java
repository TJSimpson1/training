package com.fdmgroup.bookStore;

public interface WriteItemCommand {

	void insertItem(Book book);

	void deleteItem(Book book);

}
