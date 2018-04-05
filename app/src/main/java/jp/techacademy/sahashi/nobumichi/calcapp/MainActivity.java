package jp.techacademy.sahashi.nobumichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    Double dbl1;
    Double dbl2;
    Double dblRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        try{
            Intent intent = new Intent(this, SecondActivity.class);
            BigDecimal bdc1 = new BigDecimal(mEditText1.getText().toString());
            BigDecimal bdc2 = new BigDecimal(mEditText2.getText().toString());

            if (v.getId() == R.id.button1) {
                BigDecimal bdcResult = bdc1.add(bdc2);
                intent.putExtra("VALUE", bdcResult.toString());

            } else if (v.getId() == R.id.button2) {
                BigDecimal bdcResult = bdc1.subtract(bdc2);
                intent.putExtra("VALUE", bdcResult.toString());

            } else if (v.getId() == R.id.button3) {
                BigDecimal bdcResult = bdc1.multiply(bdc2);
                intent.putExtra("VALUE", bdcResult.toString());

            } else if (v.getId() == R.id.button4) {
                BigDecimal bdcResult = bdc1.divide(bdc2);
                intent.putExtra("VALUE", bdcResult.toString());

            }
            startActivity(intent);
        }
        catch (Exception e){
            Toast toast = Toast.makeText(
                    this, "予期せぬエラーが発生しました。", Toast.LENGTH_SHORT);
            toast.show();
            mEditText1.requestFocus();
        }

    }

}
