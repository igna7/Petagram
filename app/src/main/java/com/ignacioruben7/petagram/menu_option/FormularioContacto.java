package com.ignacioruben7.petagram.menu_option;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ignacioruben7.petagram.R;

public class FormularioContacto extends AppCompatActivity {
    Button enviar;
    EditText nombre;
    EditText correo;
    EditText comentarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_contacto);

        nombre = (EditText) findViewById(R.id.nombre);
        correo = (EditText) findViewById(R.id.correo);
        comentarios = (EditText) findViewById(R.id.comentario);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar4);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enviar = (Button) findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nombre.getText().toString();
                String to = "ignacioruben7@gmail.com";
                String mail = correo.getText().toString();
                String comment = comentarios.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, name + " - " + mail );
                email.putExtra(Intent.EXTRA_TEXT, comment );
                startActivity(Intent.createChooser(email, "Enviar correo :"));

            }
        });

    }
}
