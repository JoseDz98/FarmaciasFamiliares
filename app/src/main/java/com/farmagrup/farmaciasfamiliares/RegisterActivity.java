package com.farmagrup.farmaciasfamiliares;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText pass1, pass2;
    TextInputLayout layoutpass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        pass1 = findViewById(R.id.txt_pass1);
        pass2 = findViewById(R.id.txt_pass2);
        layoutpass1 = findViewById(R.id.layout_pass1);
    }

    public void registrar_usuario(View view) {
        String str_pass1 = pass1.getText().toString();
        String str_pass2 = pass2.getText().toString();
        if (!str_pass1.equals(str_pass2)){
            layoutpass1.setError("Las contraseñas no coinciden");
            pass2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    layoutpass1.setErrorEnabled(false);
                }
            });
        }

    }
}