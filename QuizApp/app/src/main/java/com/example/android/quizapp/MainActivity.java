package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  int questionsAmount = 5;
  EditText firstAnswer, secondAnswer;
  RadioButton trueRadioBtn, falseRadioBtn, buttonRadioBtn, viewRadioBtn, radioButtonRadioBtn;
  CheckBox linearLayoutCheckBox, textViewCheckBox, checkBoxCheckBox, relativeLayoutCheckBox;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    firstAnswer = findViewById(R.id.first_answer); // First question's answer view (EditText)
    secondAnswer = findViewById(R.id.second_answer); // Second question's answer view (EditText)

    // Third question's answer view (RadioButton)
    trueRadioBtn = findViewById(R.id.true_radio_btn);
    falseRadioBtn = findViewById(R.id.false_radio_btn);

    // Fourth question's answer views (CheckBox)
    linearLayoutCheckBox = findViewById(R.id.linear_layout_checkbox);
    textViewCheckBox = findViewById(R.id.text_view_checkbox);
    checkBoxCheckBox = findViewById(R.id.checkbox_checkbox);
    relativeLayoutCheckBox = findViewById(R.id.relative_layout_checkbox);

    // Fifth question's answer views (CheckBox)
    buttonRadioBtn = findViewById(R.id.button_radio_btn);
    viewRadioBtn = findViewById(R.id.view_radio_btn);
    radioButtonRadioBtn = findViewById(R.id.radio_button_radio_btn);

  }

  /*
    This method is triggered when the submit button has been clicked.
    It will verify each answer of the quiz and show a Toast message with the score.
   */
  public void checkResults(View view) {
    double score = 0; // This variable will hold the score of the user.

    // Verifying answers from question #1
    if (firstAnswer.getText().toString().equals("TextView")) {
      ++score;
    }

    // Verifying answers from question #2
    if (secondAnswer.getText().toString().equals("LinearLayout")) {
      ++score;
    }

    // Verifying answers from question #3
    if (falseRadioBtn.isChecked() && !trueRadioBtn.isChecked()) {
      ++score;
    }

    // Verifying answers from question #4
    if (linearLayoutCheckBox.isChecked()) {
      if (!textViewCheckBox.isChecked() && !checkBoxCheckBox.isChecked()) {
        score += 0.5;
      }
    }
    if (relativeLayoutCheckBox.isChecked()) {
      if (!textViewCheckBox.isChecked() && !checkBoxCheckBox.isChecked()) {
        score += 0.5;
      }
    }

    // Verifying answers from question #5
    buttonRadioBtn = findViewById(R.id.button_radio_btn);
    viewRadioBtn = findViewById(R.id.view_radio_btn);
    radioButtonRadioBtn = findViewById(R.id.radio_button_radio_btn);
    if (buttonRadioBtn.isChecked() && !viewRadioBtn.isChecked() && !radioButtonRadioBtn.isChecked()) {
      ++score;
    }

    // Display message to the user.
    Toast.makeText(this, "You score is " + score + "/" + questionsAmount, Toast.LENGTH_SHORT).show();
  }

}
