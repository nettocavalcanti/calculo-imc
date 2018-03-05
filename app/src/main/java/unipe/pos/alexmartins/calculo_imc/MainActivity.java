package unipe.pos.alexmartins.calculo_imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      TextView resultTextView = (TextView)findViewById(R.id.result);

       *//* String name = getIntent().getStringExtra("Name");
        float weight = Float.parseFloat(getIntent().getStringExtra("WEIGHT"));
        float height = Float.parseFloat(getIntent().getStringExtra("HEIGHT"));*//*

//        float resultado = weight / (height * height);

        if (resultado < 18.5) {
            resultTextView.setText("Abaixo do peso!");
        } else if (resultado > 18.6 && resultado < 24.9) {
            resultTextView.setText("Peso ideal (parabéns).");
        } else if (resultado > 25.0 && resultado < 29.9) {
            resultTextView.setText("Levemente acima do peso.");
        } else if (resultado > 30.0 && resultado < 34.9) {
            resultTextView.setText("Obesidade grau I.");
        } else if (resultado > 35.0 && resultado < 39.9) {
            resultTextView.setText("Obesidade grau II (severa).");
        }

        else {
            resultTextView.setText("Obesidade III (mórbida).");
        }*/
    }

    public void btnCalcularOnClick(View v){


        EditText weightEditText = (EditText) findViewById(R.id.weight);
        EditText heightEditText = (EditText) findViewById(R.id.height);

        if(weightEditText.getText().length() == 0 || heightEditText.getText().length() == 0)
            Toast.makeText(getApplicationContext(), "Por favor, preencha o campo vazio.", Toast.LENGTH_SHORT).show();
        else {

            float weight = Float.parseFloat(weightEditText.getText().toString());
            float height = Float.parseFloat(heightEditText.getText().toString());

            if (weight == 0 || height == 0.0)
                Toast.makeText(getApplicationContext(), "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
            else{

                Intent intent = new Intent(getBaseContext(), GetNameActivity.class);
                intent.putExtra("WEIGHT", weight);
                intent.putExtra("HEIGHT", height);
                startActivity(intent);
            }
        }
    }
}
