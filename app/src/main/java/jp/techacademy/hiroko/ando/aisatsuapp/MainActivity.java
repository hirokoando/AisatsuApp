package jp.techacademy.hiroko.ando.aisatsuapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TimePicker;
import android.app.TimePickerDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.aisatsuText);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.button){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog TimePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        if(hourOfDay>=18){
                            mTextView.setText("こんばんは");
                            mTextView.setTextColor(Color.BLUE);
                        }else if(hourOfDay>=10){
                            mTextView.setText("こんにちは");
                            mTextView.setTextColor(Color.rgb(250,190,190));
                        }else if(hourOfDay>=2){
                            mTextView.setText("おはよう");
                            mTextView.setTextColor(Color.rgb(200,200,0));
                        }else{
                            mTextView.setText("こんばんは");
                            mTextView.setTextColor(Color.BLUE);
                        }
                    }
                },
                12,
                0,
                true);
        TimePickerDialog.show();
    }
}
