package com.jegerima.easyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_enter;
    EditText txt_n1;
    EditText txt_n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            getSupportActionBar().setTitle("Simple App");
        }catch (Exception e) {
            e.printStackTrace();
        }

        txt_n1 = (EditText)findViewById(R.id.txt_n1);
        txt_n2 = (EditText)findViewById(R.id.txt_n2);
        btn_enter = (Button)findViewById(R.id.btn_enter);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = txt_n1.getText().toString();
                String n2 = txt_n2.getText().toString();

                if(n1.isEmpty()){
                    showToast(getApplicationContext(), "Primer valor es vacío");
                    return;
                }

                if(!isInteger(n1)){
                    showToast(getApplicationContext(), "Primer valor debe ser entero");
                    return;
                }

                if(n2.isEmpty()){
                    showToast(getApplicationContext(), "Segundo valor es vacío");
                    return;
                }

                if(!isInteger(n2)){
                    showToast(getApplicationContext(), "Segundo valor debe ser entero");
                    return;
                }

                System.out.println("bye");

                int v1 = Integer.parseInt(n1);
                int v2 = Integer.parseInt(n2);

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("n1", v1);
                intent.putExtra("n2", v2);
                intent.putExtra("sum", v1+  v2);
                intent.putExtra("prom", (v1 + v2)/2.0);
                intent.putExtra("n1menor", v1<v2);
                intent.putExtra("n1mayor", v1>v2);
                intent.putExtra("n1igual", v1==v2);
                startActivity(intent);
            }
        });
    }

    void showToast(Context ctx, String text){
        Toast t = Toast.makeText(ctx, text, Toast.LENGTH_SHORT);
        t.show();
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
