package com.example.icalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button  buttonNulle,
            buttonOne,
            buttonTwo,
            buttonThree,
            buttonFour,
            buttonFive,
            buttonSix,
            buttonSeven,
            buttonEight,
            buttonNine,
            buttonMinus,
            buttonPlus,
            buttonDell,
            buttonMultiply,
            buttonEqual,
            buttonLeft,
            buttonRight,
            buttonPoint,
            buttonDel;
    TextView textViewAnswer;
    AnalysisCharacter analysisCharacter = new AnalysisCharacter();
    Calculate calculate = new Calculate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNulle = (Button)findViewById(R.id.nulle);
        buttonOne = (Button)findViewById(R.id.one);
        buttonTwo = (Button)findViewById(R.id.two);
        buttonThree = (Button)findViewById(R.id.three);
        buttonFour = (Button)findViewById(R.id.four);
        buttonFive = (Button)findViewById(R.id.five);
        buttonSix = (Button)findViewById(R.id.six);
        buttonSeven = (Button)findViewById(R.id.seven);
        buttonEight = (Button)findViewById(R.id.eight);
        buttonNine = (Button)findViewById(R.id.nine);
        buttonMinus = (Button)findViewById(R.id.minus);
        buttonPlus = (Button)findViewById(R.id.plus);
        buttonDell = (Button)findViewById(R.id.dell);
        buttonMultiply = (Button)findViewById(R.id.multiply);
        buttonEqual = (Button)findViewById(R.id.equal);
        buttonLeft = (Button)findViewById(R.id.left);
        buttonRight = (Button)findViewById(R.id.right);
        textViewAnswer = (TextView) findViewById(R.id.expression);
        buttonDel = (Button)findViewById(R.id.del);
        buttonPoint = (Button)findViewById(R.id.point);
        buttonNulle.setOnClickListener(this);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonDell.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonLeft.setOnClickListener(this);
        buttonRight.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int buttonPressID = v.getId();
        Button buttonPress = (Button)findViewById(buttonPressID);
        textViewAnswer.append(buttonPress.getText() + "");
        if (!buttonPress.getText().equals("=") &&
                !buttonPress.getText().equals("Del") ) analysisCharacter.detectCharacter(buttonPress.getText().toString());
        else textViewAnswer.setText(calculate.recivedResults());
        if (buttonPress.getText().equals("Del")){
            textViewAnswer.setText("");
            analysisCharacter.stackAction.CleaningStack();
        }
    }
}
