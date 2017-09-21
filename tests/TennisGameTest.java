import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love" checked
// "15 - 15"
// "30 - 30"
// "deuce" checked
// "15 - love", "love - 15" checked
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage" checked
// "player2 has advantage" checked
// "player1 wins" checked
// "player2 wins" checked
	
	TennisGame game;
	String score;
	
	@Before 
	public void setUp(){
		game = new TennisGame();
		score =" ";
	}
	
	@Test
//	@Ignore
	public void testTennisGame_Start() {
		//Arrange
//		TennisGame game = new TennisGame();
		//Act
		score = game.getScore();
		//String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
//		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		score = game.getScore();
		//String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	// My test codes
	@Test 
	public void testTennisGame_EachPlayerWin5Points_Score_Deuce() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		// first deuce
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		// second deuce
		game.player1Scored();
		game.player2Scored();
		
		// third deuce, each has 5 points
		game.player1Scored();
		game.player2Scored();

		
		score = game.getScore();
		//String score = game.getScore();
		
		assertEquals("Tie score incorrect", "deuce", score);
	}
	
	@Test 
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		score = game.getScore();
		//String score = game.getScore();
		
		assertEquals("Tie score incorrect", "deuce", score);
	}
	
	@Test
	public void testTennisGame_Player1_has_advantage() throws TennisGameException {
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		score = game.getScore();
		//String score = game.getScore();
		
		assertEquals("Player1 should have advantage", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2_has_advantage() throws TennisGameException {
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		score = game.getScore();
		//String score = game.getScore();
		
		assertEquals("Player2 should have advantage", "player2 has advantage", score);
	}
	
	@Test
	public void testTennisGame_15_love() throws TennisGameException{
		game.player1Scored();
		score = game.getScore();
		
		assertEquals("15 - love", "15 - love", score);
	}
	
	@Test
	public void testTennisGame_love_15() throws TennisGameException{
		game.player2Scored();
		score = game.getScore();
		
		assertEquals("love - 15", "love - 15", score);
	}
	
	@Test
	public void testTennisGame_player1_wins() throws TennisGameException{
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		score = game.getScore();
		
		assertEquals("player1 wins", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_player2_wins() throws TennisGameException{
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		score = game.getScore();
		
		assertEquals("player2 wins", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_player2_wins_after_advantage() throws TennisGameException{
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		score = game.getScore();
		
		assertEquals("player2 wins after advantage", "player2 wins", score);
	}
	
	@Test
	public void testTennisGame_player1_wins_after_2_deuce() throws TennisGameException{
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player1Scored();
		
		game.player1Scored();
		game.player1Scored();
		
		score = game.getScore();
		
		assertEquals("player1 wins after 2 deuces", "player1 wins", score);
	}
	
	
	
	
	
	
	
}
