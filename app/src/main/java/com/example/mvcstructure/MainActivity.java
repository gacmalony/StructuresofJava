package com.example.mvcstructure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MVP {

    Button btn, btn2, btn3;
    TextView txt;
    Presenter presenter;

    MyMVVMST myMVVMST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        txt = findViewById(R.id.textView);
        btn3 = findViewById(R.id.button3);
        callMVC();
        presenter = new Presenter(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Caller();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getAppName();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMVVMST.getspecificData();
            }
        });



        myMVVMST = new ViewModelProvider(MainActivity.this).get(MyMVVMST.class);
        myMVVMST.mutableLiveData.observe(MainActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        txt.setText(s);
                    }
                });

            }





    public MyModel callMVC() {

        MyModel myModel = new MyModel("NOW SHOWING WITH MVC STRUCTURE ", 10000,4);
        return myModel;

    }

    private void Caller(){
        txt.setText(callMVC().getStr()+" "+callMVC().getI1()+" "+ callMVC().getI2());
    }


    @Override
    public void getAppName(String str) {
        txt.setText(str);

    }
}