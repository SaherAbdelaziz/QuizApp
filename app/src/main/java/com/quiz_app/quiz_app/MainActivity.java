package com.quiz_app.quiz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score , q1 , q2 , q3 , q4 , q5 ;
    RadioGroup mRadioGroup1 , mRadioGroup2 , mRadioGroup5 ;
    EditText mQ4Answer ;
    CheckBox mQ3Answer31 , mQ3Answer32 , mQ3Answer33;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        mRadioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        mRadioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);

        mQ4Answer = (EditText) findViewById(R.id.Q4Answer);

        mQ3Answer31 = (CheckBox) findViewById(R.id.Q3Answer31);
        mQ3Answer32 = (CheckBox) findViewById(R.id.Q3Answer32);
        mQ3Answer33 = (CheckBox) findViewById(R.id.Q3Answer33);

        Button mSubmitButton = (Button) findViewById(R.id.SubmitButton);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mRadioGroup1.getCheckedRadioButtonId() == R.id.radioButton11){

                    q1=20 ;
                }
                if(mRadioGroup2.getCheckedRadioButtonId() == R.id.radioButton24){
                    q2=20 ;
                }
                if(mRadioGroup5.getCheckedRadioButtonId() == R.id.radioButton53){
                    q5=20 ;
                }

                if(mQ3Answer31.isChecked() && mQ3Answer32.isChecked() && mQ3Answer33.isChecked()){
                    q3=20 ;
                }
                String answer =String.valueOf(mQ4Answer.getText()) ;
                answer = answer.replaceAll("\\s+","") ;
                if(answer.equals("['hi!','hi!']")){
                    q4=20 ;
                }


                score=q1 + q2 + q3 + q4 + q5 ;

                Toast.makeText(MainActivity.this, "Your score is " + String.valueOf(score) + " over 100", Toast.LENGTH_SHORT).show();

                if(score==100)
                    Toast.makeText(MainActivity.this, "Congratulation! you have solved all questions right ", Toast.LENGTH_LONG).show();
                Rest() ;
            }
        });
    }

    public void RestButton(View view){
        mRadioGroup1.clearCheck();
        mRadioGroup2.clearCheck();
        mRadioGroup5.clearCheck();
        mQ4Answer.setText("");
        mQ3Answer31.setChecked(false) ;
        mQ3Answer32.setChecked(false) ;
        mQ3Answer33.setChecked(false) ;
        Rest() ;
    }

    private void Rest(){

        q1=0 ;
        q2=0 ;
        q3=0 ;
        q4=0 ;
        q5=0 ;
        score =0 ;

    }



}
