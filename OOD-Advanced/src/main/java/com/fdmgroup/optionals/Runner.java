package com.fdmgroup.optionals;

import java.util.function.Supplier;

public class Runner{

	public static void main(String[] args) {
		MemoryChip memoryChip1 = new MemoryChip("Samsung");
		Motherboard motherboard1 = new Motherboard("IBM");
		Computer computer = new Computer("HP");
		
		motherboard1.setMemoryChip(memoryChip1);
		//computer.setMotherboard(motherboard1);
		
		System.out.println("===== ifPresent =====");
		computer.getMotherboard()
			.ifPresent(motherboard -> motherboard.getMemoryChip()
					.ifPresent(memoryChip -> memoryChip.accessData()));
		
		System.out.println("\n===== orElse =====");
		computer.getMotherboard()
			.orElse(new Motherboard("Dummy motherboard"))
			.getMemoryChip()
			.orElse(new MemoryChip("Dummy memory chip"))
			.accessData();
		
		System.out.println("\n===== orElseThrow =====");
		Supplier<MotherboardException> supplyException =
				() -> new MotherboardException("No motherboard present");
				
		try {
			computer.getMotherboard()
				.orElseThrow(supplyException);
		} catch (MotherboardException e) {
			e.printStackTrace();
		}
	}

}
