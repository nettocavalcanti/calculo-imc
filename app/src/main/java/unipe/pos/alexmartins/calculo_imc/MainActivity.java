package unipe.pos.alexmartins.calculo_imc;

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
    }

    public void btnCalcularOnClick(View v){

        TextView lblResultado = (TextView)findViewById(R.id.lblResultado);
        EditText txtPeso = (EditText) findViewById(R.id.txtPeso);
        EditText txtAltura = (EditText) findViewById(R.id.txtAltura);

        if(txtPeso.getText().length() == 0 || txtAltura.getText().length() == 0)
            Toast.makeText(getApplicationContext(), "Por favor, preencha o campo vazio.", Toast.LENGTH_SHORT).show();
        else {

            float peso = Float.parseFloat(txtPeso.getText().toString());
            float altura = Float.parseFloat(txtAltura.getText().toString());

            if (peso == 0 || altura == 0.0)
                Toast.makeText(getApplicationContext(), "Por favor, insira valores válidos", Toast.LENGTH_SHORT).show();
            else{

                float resultado = peso / (altura * altura);

                if (resultado < 18.5) {
                    lblResultado.setText("Abaixo do peso!");
                } else if (resultado > 18.6 && resultado < 24.9) {
                    lblResultado.setText("Peso ideal (parabéns).");
                } else if (resultado > 25.0 && resultado < 29.9) {
                    lblResultado.setText("Levemente acima do peso.");
                } else if (resultado > 30.0 && resultado < 34.9) {
                    lblResultado.setText("Obesidade grau I.");
                } else if (resultado > 35.0 && resultado < 39.9) {
                    lblResultado.setText("Obesidade grau II (severa).");
                }

                else {
                    lblResultado.setText("Obesidade III (mórbida).");
                }
            }
        }
    }
}
