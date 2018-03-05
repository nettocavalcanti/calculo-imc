package unipe.pos.alexmartins.calculo_imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = (String) getIntent().getStringExtra("NAME");

        if (name != null) {

            TextView resultTextView = (TextView) findViewById(R.id.result);

            float weight = (Float) Float.parseFloat(getIntent().getStringExtra("WEIGHT"));
            float height = (Float) Float.parseFloat(getIntent().getStringExtra("HEIGHT"));

            float result = weight / (height * height);

            if (result < 18.5) {
                resultTextView.setText(name + " seu IMC é " + result + ". Está abaixo do peso!");
            } else if (result > 18.6 && result < 24.9) {
                resultTextView.setText(name + " seu IMC é " + result + ". Está com o peso ideal (parabéns).");
            } else if (result > 25.0 && result < 29.9) {
                resultTextView.setText(name + " seu IMC é " + result + ". Está levemente acima do peso.");
            } else if (result > 30.0 && result < 34.9) {
                resultTextView.setText(name + " seu IMC é " + result + ". Está com obesidade grau I.");
            } else if (result > 35.0 && result < 39.9) {
                resultTextView.setText(name + " seu IMC é " + result + ". Está com obesidade grau II (severa).");
            } else {
                resultTextView.setText(name + " seu IMC é " + result + ". Está com obesidade III (mórbida).");
            }
        }

        Button bntCalculate = (Button) findViewById(R.id.bntCalculateId);

        bntCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                EditText weightEditText = (EditText) findViewById(R.id.weight);
                EditText heightEditText = (EditText) findViewById(R.id.height);

                if(weightEditText.getText().length() == 0 || heightEditText.getText().length() == 0)
                    Toast.makeText(getApplicationContext(), "Por favor, preencha o campo vazio.", Toast.LENGTH_SHORT).show();
                else {

                    float weight = (Float) Float.parseFloat(weightEditText.getText().toString());
                    float height = (Float) Float.parseFloat(heightEditText.getText().toString());

                    if (weight == 0 || height == 0.0)
                        Toast.makeText(getApplicationContext(), "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
                    else{

                        Intent intent = new Intent(getBaseContext(), GetNameActivity.class);
                        intent.putExtra("WEIGHT", Float.toString(weight));
                        intent.putExtra("HEIGHT", Float.toString(height));
                        startActivity(intent);
                    }
                }
            }
        });
    }

}
