package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView txtRow1,txtRow2,txtRow3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRow1=findViewById(R.id.txtRow1);
        txtRow2=findViewById(R.id.txtRow2);
        txtRow3=findViewById(R.id.txtRow3);
        //thêm font chữ cho textview: app->new-> folder ->Asset folder .vào Asset->new->directory:font_digital->copy vào đây
        try {
            Typeface typeface=Typeface.createFromAsset(getAssets(),"font_digital/DS-DIGIB.TTF");
            txtRow1.setTypeface(typeface);
            txtRow2.setTypeface(typeface);
            txtRow3.setTypeface(typeface);
        }
        catch (Exception ex)
        {
            Log.v("TAG",ex.toString());
        }

        //Khi người dùng nhâp dữ liêu thôi
        txtRow2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value1=txtRow1.getText().toString();
                String value2=txtRow2.getText().toString();
                if(value1.length()!=0 && value2.length()>2) {
                    try {
                        int c = 0;
                        int a = Integer.parseInt(value1);
                        int b = Integer.parseInt(value2.substring(2, value2.length()));
                        if (value2.charAt(0) == '+') {
                            c = a + b;
                        } else if (value2.charAt(0) == '-') {
                            c = a - b;
                        } else if (value2.charAt(0) == 'x') {
                            c = a * b;
                        } else if (value2.charAt(0) == '/') {
                            try {
                                c = a / b;
                            } catch (ArithmeticException ex) {
                                txtRow3.setText("Lỗi chia cho 0");
                                return;
                            }
                        }
                        txtRow3.setText("= " + String.valueOf(c));
                    }
                    catch (Exception ex)
                    {
                        txtRow3.setText(ex.getMessage());
                    }
                }
                else if(value2.length()!=0 && value1.length()==0)
                {
                    txtRow3.setText("= "+s);
                }
                /*
                đặt ntn là đo vì nó xét xong txt1 xong mới thay đổi txt2->bắt đc sự kiện
                        txtRow1.setText("");
                        txtRow2.setText("0");
                 nếu đăt ntn --> xet txt2 --> khi đó txt1 chưa đổi giá trị --> sai
                        txtRow2.setText("0");
                        txtRow1.setText("");
                 */
                else if(value2.length()==2 && value1.length()!=0)
                {
                    txtRow3.setText("= "+value1);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Button btnBS,btnC,btnCE,btnDiv,btnX,
                btn1,btn2,btn3,btn4,btn5,
                btn6,btn7,btn8,btn9,btn0,
                btnAdd,btnSub,btnPoint,btnEquals,btnSign;

        btnBS=findViewById(R.id.btnBS);
        btnC=findViewById(R.id.btnC);
        btnCE=findViewById(R.id.btnCE);
        btnDiv=findViewById(R.id.btnDiv);
        btnX=findViewById(R.id.btnX);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn0=findViewById(R.id.btn0);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnPoint=findViewById(R.id.btnPoint);
        btnEquals=findViewById(R.id.btnEquals);
        btnSign=findViewById(R.id.btnSign);

        btnBS.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnSign.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.btnEquals) {
            String value=txtRow3.getText().toString();
            if(value.length()>=3)
            {
                if(!value.equals("Lỗi chia cho 0")) {
                    value = value.substring(2, value.length());
                    txtRow1.setText("");
                    txtRow2.setText(value);
                }
            }
        }
        if(id==R.id.btn0)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'0';
            txtRow2.setText(value);
        }
        if(id==R.id.btn1)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'1';
            txtRow2.setText(value);
        }
        if(id==R.id.btn2)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'2';
            txtRow2.setText(value);
        }
        if(id==R.id.btn3)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'3';
            txtRow2.setText(value);
        }
        if(id==R.id.btn4)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'4';
            txtRow2.setText(value);
        }
        if(id==R.id.btn5)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'5';
            txtRow2.setText(value);
        }
        if(id==R.id.btn6)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'6';
            txtRow2.setText(value);
        }
        if(id==R.id.btn7)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'7';
            txtRow2.setText(value);
        }
        if(id==R.id.btn8)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'8';
            txtRow2.setText(value);
        }
        if(id==R.id.btn9)
        {
            String value=txtRow2.getText().toString();
            if(value.charAt(0)=='0') value="";
            value=value+'9';
            txtRow2.setText(value);
        }
        if(id==R.id.btnX)
        {
            String value=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            if(value.charAt(0)=='0'&& value1.length()==0)
            {
                txtRow1.setText("0");
                txtRow2.setText("x ");
            }
            else {
                if(value.length()>=2)
                {
                    if(value.charAt(1)!=' ')
                    {
                        txtRow1.setText(value);
                        value = "";
                        value=value+"x ";
                        txtRow2.setText(value);
                    }
                    else
                    {
                        String result=txtRow3.getText().toString();
                        if(!result.equals("Lỗi chia cho 0")&& result.length()>=3)
                        {
                            result=result.substring(2,result.length());
                            txtRow1.setText(result);
                            txtRow2.setText("x ");
                        }
                    }
                }
                else
                {
                    txtRow1.setText(value);
                    value = "";
                    value=value+"x ";
                    txtRow2.setText(value);
                }
            }
        }
        if(id==R.id.btnDiv)
        {
            String value=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            if(value.charAt(0)=='0'&& value1.length()==0)
            {
                txtRow1.setText("0");
                txtRow2.setText("/ ");
            }
            else {
                if(value.length()>=2)
                {
                    if(value.charAt(1)!=' ')
                    {
                        txtRow1.setText(value);
                        value = "";
                        value=value+"/ ";
                        txtRow2.setText(value);
                    }
                    else
                    {
                        String result=txtRow3.getText().toString();
                        if(!result.equals("Lỗi chia cho 0")&& result.length()>=3)
                        {
                            result=result.substring(2,result.length());
                            txtRow1.setText(result);
                            txtRow2.setText("/ ");
                        }
                    }
                }
                if(value.length()==1)
                {
                    txtRow1.setText(value);
                    value = "";
                    value=value+"/ ";
                    txtRow2.setText(value);
                }
            }
        }
        if(id==R.id.btnSub)
        {
            String value=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            if(value.charAt(0)=='0'&& value1.length()==0)
            {
                txtRow1.setText("0");
                txtRow2.setText("- ");
            }
            else {
                if(value.length()>=2)
                {
                    if(value.charAt(1)!=' ')
                    {
                        txtRow1.setText(value);
                        value = "";
                        value=value+"- ";
                        txtRow2.setText(value);
                    }
                    else
                    {
                        String result=txtRow3.getText().toString();
                        if(!result.equals("Lỗi chia cho 0")&& result.length()>=3)
                        {
                            result=result.substring(2,result.length());
                            txtRow1.setText(result);
                            txtRow2.setText("- ");
                        }
                    }
                }
                if(value.length()==1)
                {
                    txtRow1.setText(value);
                    value = "";
                    value=value+"- ";
                    txtRow2.setText(value);
                }
            }
        }
        if(id==R.id.btnAdd)
        {
            String value=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            if(value.charAt(0)=='0'&& value1.length()==0)
            {
                txtRow1.setText("0");
                txtRow2.setText("+ ");
            }
            else {
                if(value.length()>=2)
                {
                    if(value.charAt(1)!=' ')
                    {
                        txtRow1.setText(value);
                        value = "";
                        value=value+"+ ";
                        txtRow2.setText(value);
                    }
                    else
                    {
                        String result=txtRow3.getText().toString();
                        if(!result.equals("Lỗi chia cho 0")&& result.length()>=3)
                        {
                            result=result.substring(2,result.length());
                            txtRow1.setText(result);
                            txtRow2.setText("+ ");
                        }
                    }
                }
                else
                {
                    txtRow1.setText(value);
                    value = "";
                    value=value+"+ ";
                    txtRow2.setText(value);
                }
                /*
                if (value.charAt(0) != 'x' && value.charAt(0) != '/' && value.charAt(0) != '+' && value.charAt(0) != '-') {
                    txtRow1.setText(value);
                    value = "";
                    value=value+"+ ";
                    txtRow2.setText(value);
                }
                 */
            }
        }
        if(id==R.id.btnSign)
        {
            String value2=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            int pos=value2.length();
            if(value2.charAt(0)!='0')
            {

                if((value2.charAt(0) == 'x' || value2.charAt(0) == '/' || value2.charAt(0) == '+' || value2.charAt(0) == '-') &&pos>=2&& value2.charAt(1)==' ')
                {
                    if(pos!=2)
                    {
                        if(value2.charAt(2) == '-') value2=value2.substring(0,2)+value2.substring(3,pos);
                        else value2=value2.substring(0,2)+'-'+value2.substring(2,pos);
                    }
                }
                else
                {
                    if(value2.charAt(0) != '-') value2=String.valueOf('-').concat(value2);
                    else value2=value2.substring(1,pos);
                }
                txtRow2.setText(value2);
            }
        }

        if(id==R.id.btnBS) //xóa 1 ký tự
        {
            String value2=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            int pos=value2.length();
            if(value2.charAt(0)!='0')
            {
                if((value2.charAt(0) == 'x' || value2.charAt(0) == '/' || value2.charAt(0) == '+' || value2.charAt(0) == '-') &&pos>=2&& value2.charAt(1)==' ')
                {
                    if(pos==2)
                    {
                        if (value1.length() != 0) {
                            txtRow1.setText("");
                            txtRow2.setText(value1);
                        } else {
                            txtRow1.setText("");
                            txtRow2.setText("0");
                        }
                    }
                    else
                    {
                        if(value2.charAt(pos-2) == '-') {
                            value2 = value2.substring(0, pos - 2);
                            txtRow2.setText(value2);
                        }
                        else {
                            value2 = value2.substring(0, pos - 1);
                            txtRow2.setText(value2);
                        }
                    }
                }
                else
                {
                    if(pos==2)
                    {
                        if(value2.charAt(0) == '-')
                        {
                            if (value1.length() != 0) {
                                txtRow1.setText("");
                                txtRow2.setText(value1);
                            } else {
                                txtRow1.setText("");
                                txtRow2.setText("0");
                            }
                        }
                        else
                        {
                            value2 = value2.substring(0,pos-1);
                            txtRow2.setText(value2);
                        }
                    }
                    else
                    {
                        if(pos>2) {
                            value2 = value2.substring(0, pos - 1);
                            txtRow2.setText(value2);
                        }
                        else
                        {
                            if (value1.length() != 0) {
                                txtRow1.setText("");
                                txtRow2.setText(value1);
                            } else {
                                txtRow1.setText("");
                                txtRow2.setText("0");
                            }
                        }
                    }
                }
            }
        }
        if(id==R.id.btnC) //xóa 1 toán hạng hoặc toán tử
        {
            String value2=txtRow2.getText().toString();
            String value1=txtRow1.getText().toString();
            int pos=value2.length();
            if(value2.charAt(0)!='0') {
                if((value2.charAt(0) == 'x' || value2.charAt(0) == '/' || value2.charAt(0) == '+' || value2.charAt(0) == '-') &&pos>=2&& value2.charAt(1)==' ')
                {
                    if(pos==2)
                    {
                        if (value1.length() != 0) {
                            txtRow1.setText("");
                            txtRow2.setText(value1);
                        } else {
                            txtRow1.setText("");
                            txtRow2.setText("0");
                        }
                    }
                    else
                    {
                        value2=value2.substring(0,2);
                        txtRow2.setText(value2);
                    }
                }
                else
                {
                    if (value1.length() != 0) {
                        txtRow1.setText("");
                        txtRow2.setText(value1);
                    } else {
                        txtRow1.setText("");
                        txtRow2.setText("0");
                    }
                }
            }
        }
        if(id==R.id.btnCE)
        {
            txtRow1.setText("");
            txtRow2.setText("0");
            txtRow3.setText("");
        }
    }
}
