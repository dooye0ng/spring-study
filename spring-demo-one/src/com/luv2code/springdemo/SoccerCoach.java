package com.luv2code.springdemo;

public class SoccerCoach implements Coach{
	private FortuneService fortuneService;
	private String email;
	private String team;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "30 min shooting";
	}
	
	@Override
	public String getDailyFortune() {
		return "SOCCER : " + fortuneService.getFortune();
	}
	
	@Override
	public String toString() {
		return "team : " + team +
				"\nemail : " + email;
	}
	
	public void hello() {
		System.out.println("hello");
	}
}
