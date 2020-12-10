package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "30 min on running";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	// add init method
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: start up method");
	}
	// add destroy method
	
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: clean up method");
	}
}












