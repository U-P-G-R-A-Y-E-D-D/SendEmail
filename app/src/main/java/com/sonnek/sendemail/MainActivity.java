package com.sonnek.sendemail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText TO;
    EditText Predmet;
    EditText Zprava;
    Button Odeslat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TO = findViewById((R.id.edit_text_to));
        Predmet = findViewById(R.id.edit_text_subject);
        Zprava = findViewById(R.id.edit_text_message);

        Odeslat = findViewById(R.id.button_send);

        Odeslat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

    private void sendMail(){
        String prijemceList = TO.getText().toString();
        String[] prijemce = prijemceList.split(",");

        String predmet = Predmet.getText().toString();
        String zprava = Zprava.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,prijemce);
        intent.putExtra(Intent.EXTRA_SUBJECT,prijemce);
        intent.putExtra(Intent.EXTRA_TEXT,zprava);
        intent.setType("messagee/rfc822");
        startActivity(Intent.createChooser(intent, "Vyberte e-mailového klienta"));

    }
}
