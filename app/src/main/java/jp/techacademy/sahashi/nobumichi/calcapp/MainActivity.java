package jp.techacademy.sahashi.nobumichi.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

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
        Intent intent = new Intent(this, SecondActivity.class);
        dbl1 = Double.parseDouble(mEditText1.getText().toString());
        dbl2 = Double.parseDouble(mEditText2.getText().toString());
        if (v.getId() == R.id.button1) {
            dblRet = dbl1 + dbl2;
            intent.putExtra("VALUE", dblRet);

        } else if (v.getId() == R.id.button2) {
            dblRet = dbl1 - dbl2;
            intent.putExtra("VALUE", dblRet);

        } else if (v.getId() == R.id.button3) {
            dblRet = dbl1 * dbl2;
            intent.putExtra("VALUE", dblRet);

        } else if (v.getId() == R.id.button4) {
            dblRet = dbl1 / dbl2;
            intent.putExtra("VALUE", dblRet);

        }
        startActivity(intent);
    }

}
