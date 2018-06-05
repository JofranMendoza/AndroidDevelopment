package com.example.android.baseballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  int scoreTeamA = 0;
  int scoreTeamB = 0;
  int outs = 0;
  int balls = 0;
  int strikes = 0;
  int innings = 2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  /*
    Updates the given score for Team A
   */
  public void displayTeamAScore(int score) {
    TextView scoreView = (TextView) findViewById(R.id.teamAScore);
    scoreView.setText(String.valueOf(score));
  }

  /*
    Updates the given score for Team B
   */
  public void displayTeamBScore(int score) {
    TextView scoreView = (TextView) findViewById(R.id.teamBScore);
    scoreView.setText(String.valueOf(score));
  }

  /*
      Updates the given Strike
   */
  public void displayStrikes(int strike) {
    TextView scoreView = (TextView) findViewById(R.id.strikes_counter);
    scoreView.setText(String.valueOf(strike));
  }

  /*
      Updates the given Out
   */
  public void displayOuts(int out) {
    TextView scoreView = (TextView) findViewById(R.id.outs_counter);
    scoreView.setText(String.valueOf(out));
  }

  /*
      Updates the given Ball
   */
  public void displayBalls(int ball) {
    TextView scoreView = (TextView) findViewById(R.id.balls_counter);
    scoreView.setText(String.valueOf(ball));
  }

  /*
      Updates the given Inning
   */
  public void displayInnings(int inning) {
    TextView scoreView = (TextView) findViewById(R.id.innings_counter);
    String text = "";
    switch (inning%2) {
      case (0):
        text = "Top #"+String.valueOf(inning/2);
        break;
      case (1):
        text = "Bottom #"+ String.valueOf(inning/2);
        break;
    }
    scoreView.setText(text);
  }

  /*
    Resets all metrics and the scores of each team
   */
  public void reset(View view){
    scoreTeamA = scoreTeamB = outs = balls = strikes = 0;
    innings = 2;
    displayTeamAScore(scoreTeamA);
    displayTeamBScore(scoreTeamB);
    displayStrikes(strikes);
    displayOuts(outs);
    displayBalls(balls);
    displayInnings(innings);
  }

  /*
    Updates the display of all metrics such as Strikes, Outs, Balls, and Innings.
   */
  public void updateMetrics() {
    displayStrikes(strikes);
    displayOuts(outs);
    displayBalls(balls);
    displayInnings(innings);
  }

  /*
    Add a run to the Score of Team A
   */
  public void addRunTeamA(View view){
    scoreTeamA = ++scoreTeamA;
    displayTeamAScore(scoreTeamA);
  }

  /*
    Add a run to the Score of Team B
   */
  public void addRunTeamB(View view){
    scoreTeamB = ++scoreTeamB;
    displayTeamBScore(scoreTeamB);
  }

  /*
    Methods for increasing each metric
   */
  public void addStrike(View view) {
    if (strikes < 2) { // If it is less than 2 Strikes then add a strike
      strikes = ++strikes;
    } else { // If higher than 2 then reset the strikes' metric and add an Out
      strikes = 0;
      addOut(view);
    }
    displayStrikes(strikes);
  }

  public void addOut(View view) {
    if (outs < 2) { // If it is less than 2 Outs then add an out
      outs = ++outs;
    } else { // If no less than 2 Outs then add an half Inning and reset the other metrics
      addInning(view);
      outs = 0;
      strikes = 0;
      balls = 0;
    }
    updateMetrics(); // Update the displays
  }

  public void addBall(View view) {
    if (balls < 3) { // If ball is less than 3 then add another ball
      balls = ++balls;
    } else { // If balls are more than 3 then reset balls' metric
      balls = 0;
    }
    displayBalls(balls); // Update balls' display
  }

  public void addInning(View view) {
    if (innings < 19) {
      innings = ++innings;
    } else {
      // if both teams' are draw then add an extra inning, also add an end half inning if it is at the first half inning
      if (scoreTeamA == scoreTeamB || innings%2 == 0) {
        innings = ++innings;
      } else { // If not draw then reset for a new game. The team with a higher score won.
        reset(view);
      }
    }
    displayInnings(innings); // Update innings' display
  }
}
