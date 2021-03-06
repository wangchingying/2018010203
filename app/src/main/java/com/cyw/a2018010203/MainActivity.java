package com.cyw.a2018010203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1;
    RadioButton rb1,rb2,rb3;
    RadioGroup rg1;
    Button bt1,bt2,bt3,bt4,bt5;
    Switch sw1;
    ProgressBar pb1,pb2;
    SeekBar sb1,sb2;
    TextView tv1;
    RatingBar rbr1,rbr2;
    int pi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Checkbox 打勾沒
        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    Toast.makeText(MainActivity.this, "打勾", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //RadioButton哪個被按了
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rg1=(RadioGroup) findViewById(R.id.radioGroup);
        bt1=(Button)findViewById(R.id.button);
 /*       自己寫的
            bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) {
                    Toast.makeText(MainActivity.this, "radio 1 is checked", Toast.LENGTH_SHORT).show();
                }
                else if (rb2.isChecked()) {
                    Toast.makeText(MainActivity.this, "radio2 is checked", Toast.LENGTH_SHORT).show();
                }
                else if (rb3.isChecked()) {
                    Toast.makeText(MainActivity.this, "radio3 is checked", Toast.LENGTH_SHORT).show();
                }
                }
           }
      });
*/

        sb2=(SeekBar)findViewById(R.id.seekBar2);
        rbr1=(RatingBar)findViewById(R.id.ratingBar);
        rbr2=(RatingBar)findViewById(R.id.ratingBar2);
        bt1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (rg1.getCheckedRadioButtonId()) {
                    case R.id.radioButton:
                        Toast.makeText(MainActivity.this, "第1個按鈕被按了", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this, "第2個按鈕被按了", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton3:
                        Toast.makeText(MainActivity.this, "第3個按鈕被按了", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        //rating bar 2 不能rating,只有最大的那個rating bar可以rating(rating bar 1)
                        Toast.makeText(MainActivity.this, "沒有按鈕被按而seekbar值="+String.valueOf(sb1.getProgress()+"seekbar2值"+String.valueOf(sb2.getProgress()+"RatingBar值"+String.valueOf(rbr1.getRating()+"RatingBar2值"+String.valueOf(rbr2.getNumStars())))), Toast.LENGTH_LONG).show();
                        break;
                }
               // if(rg1.callOnClick()){}{Toast.makeText(MainActivity.this, "沒有按鈕被按", Toast.LENGTH_SHORT).show();}
                //Toast.makeText(MainActivity.this, String.valueOf(sb1.getProgress()), Toast.LENGTH_SHORT).show();
            }
       });
        //Progress Bar 用Switch控制轉(visible)或不轉(invisble), gone是整個消失, layout可能會亂掉
        pb1=(ProgressBar)findViewById(R.id.progressBar);
        sw1=(Switch)findViewById(R.id.switch1);
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    pb1.setVisibility(View.VISIBLE);
                }else{
                    pb1.setVisibility(View.INVISIBLE);
                }
            }
        });
        //讓Progress Bar 運作三秒鐘
        bt2=(Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb1.setVisibility(View.VISIBLE);
                //啟動一個副執行緒數3秒, 主執行緒不能停住三秒不動,這樣所有東西都不會動
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //pb1 必須在主執行緒關閉或開啟,所以又要開一個runOnUiThread
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pb1.setVisibility(View.INVISIBLE);
                            }
                        });

                    }
                }.start();

        }

    });
        //橫向ProgressBar增減
        pb2=(ProgressBar)findViewById(R.id.progressBar2);
        bt3=(Button)findViewById(R.id.button3);
        bt4=(Button)findViewById(R.id.button4);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb2.setProgress(pb2.getProgress()-10);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb2.setProgress(pb2.getProgress()+10);
            }
        });

    //SeekBar 進度
        sb1=(SeekBar)findViewById(R.id.seekBar);
        tv1=(TextView)findViewById(R.id.textView);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv1.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //進度條從     bt5=(Button) findViewById(R.id.button5);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        for (pi = 0; pi < 100; pi++) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    pb2.setProgress(pi);
                                }
                            });

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            }

        });
}




}
