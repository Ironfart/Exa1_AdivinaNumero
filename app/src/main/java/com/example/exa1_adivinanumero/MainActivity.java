package com.example.exa1_adivinanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtFir, txtSec, txtThi, txtFou, txtFif;
    RadioGroup rdGpSerie;
    EditText edTxtRes;
    Button btnVerif;

    int serie[] = new int[5];
    int lives = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFir = findViewById(R.id.txtFir);
        txtSec = findViewById(R.id.txtSec);
        txtThi = findViewById(R.id.txtThi);
        txtFou = findViewById(R.id.txtFou);
        txtFif = findViewById(R.id.txtFif);
        rdGpSerie = findViewById(R.id.rdGpSerie);
        edTxtRes = findViewById(R.id.edTxtRes);
        btnVerif = findViewById(R.id.btnVerif);

        load();

        rdGpSerie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // This will get the radiobutton that has changed in its check state
                RadioButton checkedRadioButton = (RadioButton) group.findViewById(checkedId);

                // Call to the correct generate method
                if (checkedRadioButton.getId() == R.id.rdBtnAr){
                    generateArit();
                    Toast.makeText(MainActivity.this, "Vidas reiniciadas", Toast.LENGTH_SHORT).show();
                }
                 else {
                    generateAlge();
                    Toast.makeText(MainActivity.this, "Vidas reiniciadas", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void generateArit(){
        int rand = (int)(Math.random()*50)+1;
        int d = (int) (Math.random()*10);
        int hidden = (int)(Math.random()*5)+1;

        serie[0] = rand;

        for (int i = 1; i<serie.length; i++){
            serie[i] = serie[0] + ((i+1)-1)* d;
        }

        txtFir.setText(serie[0]+"");
        txtSec.setText(serie[1]+"");
        txtThi.setText(serie[2]+"");
        txtFou.setText(serie[3]+"");
        txtFif.setText(serie[4]+"");

        switch (hidden){
            case 1:
                txtFir.setText("");
                break;
            case 2:
                txtSec.setText("");
                break;
            case 3:
                txtThi.setText("");
                break;
            case 4:
                txtFou.setText("");
                break;
            case 5:
                txtFif.setText("");
                break;
        }
    }

    public void generateAlge(){
        int rand = (int)(Math.random()*11)+5;
        int r = (int) (Math.random()*6) + 2;
        int hidden = (int)(Math.random()*5)+1;

        serie[0] = rand;

        for (int i = 1; i<serie.length; i++){
            serie[i] = serie[0] * (int) Math.pow(r,((i+1)-1));
        }

        txtFir.setText(serie[0]+"");
        txtSec.setText(serie[1]+"");
        txtThi.setText(serie[2]+"");
        txtFou.setText(serie[3]+"");
        txtFif.setText(serie[4]+"");

        switch (hidden){
            case 1:
                txtFir.setText("");
                break;
            case 2:
                txtSec.setText("");
                break;
            case 3:
                txtThi.setText("");
                break;
            case 4:
                txtFou.setText("");
                break;
            case 5:
                txtFif.setText("");
                break;
        }
    }

    public void check(View v){
        int guess = 0;

        try {
            guess = Integer.parseInt(edTxtRes.getText().toString());
            if (lives > 0) {
                if (txtFir.getText().toString().equals("")) {
                    if (guess == serie[0]) {
                        Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                        load();
                    } else {
                        lives -= 1;
                        Toast.makeText(this, "Te quedan " + lives + " vidas", Toast.LENGTH_SHORT).show();
                    }
                } else if (txtSec.getText().toString().equals("")) {
                    if (guess == serie[1]) {
                        Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                        load();
                    } else {
                        lives -= 1;
                        Toast.makeText(this, "Te quedan " + lives + " vidas", Toast.LENGTH_SHORT).show();
                    }
                } else if (txtThi.getText().toString().equals("")) {
                    if (guess == serie[2]) {
                        Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                        load();
                    } else {
                        lives -= 1;
                        Toast.makeText(this, "Te quedan " + lives + " vidas", Toast.LENGTH_SHORT).show();
                    }
                } else if (txtFou.getText().toString().equals("")) {
                    if (guess == serie[3]) {
                        Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                        load();
                    } else {
                        lives -= 1;
                        Toast.makeText(this, "Te quedan " + lives + " vidas", Toast.LENGTH_SHORT).show();
                    }
                } else if (txtFif.getText().toString().equals("")) {
                    if (guess == serie[4]) {
                        Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                        load();
                    } else {
                        lives -= 1;
                        Toast.makeText(this, "Te quedan " + lives + " vidas", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(this, "Ya no te quedan vidas!", Toast.LENGTH_SHORT).show();
                load();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Introduce un valor!", Toast.LENGTH_SHORT).show();
        }
    }

    public void load(){
        lives = 3;
        if (rdGpSerie.getCheckedRadioButtonId() == R.id.rdBtnAr)
            generateArit();
        else
            generateAlge();
    }
}
