package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballGame implements Game{
	
	private Team homeTeam;
	private Team awayTeam;
	
	public BaseballGame(){}
	
	/*
	 * Constructor injection: using constructor to inject dependencies.
	 * @Qualifier tells spring to select a bean with the corresponding id.
	 */
	@Autowired
	public BaseballGame(@Qualifier("cubs")   Team homeTeam, 
						@Qualifier("redSox") Team awayTeam){
		
		if(homeTeam == awayTeam) System.out.println("home and away are the same object on the heap");
		
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}

	public void setHomeTeam(Team team) {
		homeTeam = team;
		
	}

	public Team getHomeTeam() {
		// TODO Auto-generated method stub
		return homeTeam;
	}

	public void setAwayTeam(Team team) {
		awayTeam=team;
	}

	public Team getAwayTeam() {
		// TODO Auto-generated method stub
		return awayTeam;
	}

	public String playGame() {
		// TODO Auto-generated method stub
		return Math.random() < 0.5 ? getHomeTeam().getName() : getAwayTeam().getName();
	}

}
