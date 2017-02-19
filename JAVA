package com.example.ljm19.myapplication2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    TestJni d  = new TestJni();
    boolean flag= false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt=(Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri=Uri.parse("tel:"+110);
                Intent haha=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(haha);
            }
        });

        Button bd=(Button)findViewById(R.id.bt);
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder  bd = new AlertDialog.Builder(MainActivity.this);
                bd.setTitle("警告");
                bd.setMessage("您确定要卸载这个应用吗？");
                bd.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消卸载该应用", Toast.LENGTH_SHORT).show();
                    }
                });
                bd.setPositiveButton("卸载", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this, "确认卸载该应用", Toast.LENGTH_SHORT).show();
                    }
                });
                bd.setNeutralButton("haha", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "来打我呀", Toast.LENGTH_SHORT).show();
                    }
                });
                bd.show();
            }//Onclick
        });
    }//onCreate
    public void lighton(View v){

        d.java_open();
        if(flag == false) {
            d.java_ioctl(0);
           // button.setText("LED_ON");
            flag = true;
        }else
        {
            d.java_ioctl(1);
            //button.setText("LED_OFF");
            flag = false;
        }
    }
}
