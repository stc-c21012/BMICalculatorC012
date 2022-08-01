package jp.suntech.c21012.bmicalculatorc012;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_calculation=findViewById(R.id.bt_calculation);
        HelloListener listener =new HelloListener();//リスナのインスタンス生成
        bt_calculation.setOnClickListener(listener);//ボタンにリスナを組み込む

        Button bt_clear=findViewById(R.id.bt_clear);
        ClearListener listener1 =new ClearListener();//リスナのインスタンス生成
        bt_clear.setOnClickListener(listener1);
    }

    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view){
            EditText input =findViewById(R.id.Age);
            EditText output = findViewById(R.id.Height);
            EditText put = findViewById(R.id.Wight);
            TextView himan = findViewById(R.id.et_himan);
            TextView taijuu = findViewById(R.id.et_taijuu);
            TextView tekisei = findViewById(R.id.et_tekisei);
            TextView Ans = findViewById(R.id.teki_ans);
            TextView kg = findViewById(R.id.et_kg);
            String input2 = input.getText().toString();
            String output2 = output.getText().toString();
            String put2 = put.getText().toString();
            double input_d=Float.parseFloat(input2);
            double output_d=Float.parseFloat(output2);
            double put_d=Float.parseFloat(put2);
            double bmi =put_d/((output_d*output_d)/10000);
            double kaup=put_d/((output_d*output_d)/10000);
            double bmiAns=22*((output_d*output_d)/10000);
            String bmiAns2=String.format("%.1f",bmiAns);
            String bmiAns3 = String.valueOf(bmiAns2);
            double kaupAns=16*((output_d*output_d)/10000);
            String kaupAns2=String.format("%.1f",kaupAns);
            String kaupAns3 = String.valueOf(kaupAns2);
            himan.setText("あなたの肥満度は");
            tekisei.setText("あなたの適正体重は");
            kg.setText("kg");
            Ans.setText(bmiAns3);
            if (bmi < 18.5) {
                 taijuu.setText("低体重（痩せ型）");
            } else if (bmi >= 18.5 && bmi < 25) {
                taijuu.setText("普通体重");
            } else if (bmi >= 25 && bmi < 30) {
                taijuu.setText("肥満(1度)");
                Ans.setText(bmiAns3);
            } else if (bmi >= 30 && bmi < 35) {
                taijuu.setText("肥満(2度)");
            } else if (bmi >= 35 && bmi < 40) {
                taijuu.setText("肥満(3度)");
            } else if (bmi >= 40) {
                taijuu.setText("肥満(4度)");
            }
            if(input_d<16) {
                OrderConfirmdialogFragment dialogFragment = new OrderConfirmdialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
            }
        }
    }
    private class ClearListener implements View.OnClickListener{

        @Override
        public void onClick(View view){
            EditText input =findViewById(R.id.Age);
            EditText output = findViewById(R.id.Height);
            EditText put = findViewById(R.id.Wight);
            TextView himan = findViewById(R.id.et_himan);
            TextView taijuu = findViewById(R.id.et_taijuu);
            TextView tekisei = findViewById(R.id.et_tekisei);
            TextView Ans = findViewById(R.id.teki_ans);
            TextView kg = findViewById(R.id.et_kg);
            String input2 = input.getText().toString();
            String output2 = output.getText().toString();
            String put2 = put.getText().toString();
            double input_d=Float.parseFloat(input2);
            double output_d=Float.parseFloat(output2);
            double put_d=Float.parseFloat(put2);

            input.setText("");
            output.setText("");
            put.setText("");
            himan.setText("");
            tekisei.setText("");
            kg.setText("");
            taijuu.setText("");
            Ans.setText("");
        }

    }
}