package unipe.pos.alexmartins.calculo_imc;

import android.content.Intent;
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

        Button bntName = (Button) findViewById(R.id.bntNameId);

        bntName.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText nameEditText = (EditText) findViewById(R.id.name);
                String weight = (String) getIntent().getStringExtra("WEIGHT");
                String height = (String) getIntent().getStringExtra("HEIGHT");

                if (nameEditText.getText().length() == 0)
                    Toast.makeText(getApplicationContext(), "Por favor, preencha o campo em branco.", Toast.LENGTH_SHORT).show();

                String name = nameEditText.getText().toString();

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("WEIGHT", weight);
                intent.putExtra("HEIGHT", height);
                startActivity(intent);

            }
        });
    }

}
