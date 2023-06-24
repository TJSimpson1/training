package com.fdmgroup.staticKeywordExercises;

public class Runner {

	public static void main(String[] args) {
		double matterToEnergy = EnergyMatterCalculator.matterToEnergy(20);
		double energyToMatter = EnergyMatterCalculator.energyToMatter(15);
		
		System.out.println(matterToEnergy);
		System.out.println(energyToMatter);
	}

}
