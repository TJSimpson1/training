package com.fdmgroup.generics;

public class GenericClass<T extends Number, V> {
	private T var1;
	private V var2;

	public T getVar1() {
		return var1;
	}

	public void setVar1(T var1) {
		this.var1 = var1;
	}

	public V getVar2() {
		return var2;
	}

	public void setVar2(V var2) {
		this.var2 = var2;
	}
	
	
	
	

}
