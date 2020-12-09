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

}