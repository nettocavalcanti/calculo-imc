package unipe.pos.alexmartins.calculo_imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetNameActivity extends AppCompatActivity {

    Button ok_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_get_name);

    }

    public void btnGetNameOnClick(View v) {

        EditText name = (EditText) findViewById(R.id.name);
        float weight = Float.parseFloat(getIntent().getStringExtra("WEIGHT"));
        float height = Float.parseFloat(getIntent().getStringExtra("HEIGHT"));

        if(name.getText().length() == 0 )
            Toast.makeText(getApplicationContext(), "Por favor, preencha o campo em branco.", Toast.LENGTH_SHORT).show();

    }

    void showToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT)
                .show();
    }
}
