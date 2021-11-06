package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView calculation, result;
    private String curr, res;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCE, btnC, btnAdd, btnSub, btnMulti, btnDiv, btnEqual, btnSigned;
    private ImageButton btnBackSpace;
    private int signed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculation = (TextView) findViewById(R.id.caculation);
        result = (TextView) findViewById(R.id.result);

        curr="";
        res="";
        signed=0;


        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnCE =(Button) findViewById(R.id.btnCE);
        btnC = (Button) findViewById(R.id.btnC);
        btnBackSpace = (ImageButton) findViewById(R.id.btnBackspace);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMulti = (Button)  findViewById(R.id.btnMulti);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnSigned = (Button) findViewById(R.id.btnSigned);
        btnEqual = (Button) findViewById(R.id.btnEqual);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(res!="") {
                    res = res + "0";
                    displayTwo();
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"1";
                displayTwo();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"2";
                displayTwo();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"3";
                displayTwo();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"4";
                displayTwo();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"5";
                displayTwo();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"6";
                displayTwo();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"7";
                displayTwo();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"8";
                displayTwo();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res = res+"9";
                displayTwo();
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayCE();
                displayOne();
                displayTwo();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayC();
                displayTwo();
                displayOne();
            }
        });
        btnBackSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayBackspace();
                displayTwo();
            }
        });
        btnSigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySigned();
                displayTwo();
            }

        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" + ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" - ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" × ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                curr=res+" ÷ ";
                res="";

                displayOne();
                displayTwo();

            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr=curr+res+" = ";
                String[] tokens = curr.split(" ");
                switch (tokens[1].charAt(0)){
                    case '+':
                        res=Double.toString(Double.parseDouble(tokens[0])+Double.parseDouble(tokens[2]));
                        break;
                    case '-':
                        res=Double.toString(Double.parseDouble(tokens[0])-Double.parseDouble(tokens[2]));
                        break;
                    case '×':
                        res=Double.toString(Double.parseDouble(tokens[0])*Double.parseDouble(tokens[2]));
                        break;
                    case '÷':
                        res=Double.toString(Double.parseDouble(tokens[0])/Double.parseDouble(tokens[2]));
                        break;
                }
                displayOne();
                displayTwo();
            }

        });



    }

    public void displayOne(){
        calculation.setText(curr);

    }

    public void displayTwo(){
        result.setText(res);
    }

    public void displayCE(){
        res = "";
    }

    public void displayC(){
        curr = "";
        res = "";
    }

    public void displayBackspace(){
        if(!res.isEmpty()){
            res = res.substring(0, res.length()-1);
        }
    }
    public void displaySigned(){
        signed++;
        if(res!="") {
            if (signed % 2 == 1)
                res = "-" + res;
            else res = res.substring(1, res.length());
        }
    }
}