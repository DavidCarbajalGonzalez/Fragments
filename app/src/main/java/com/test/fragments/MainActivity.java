package com.test.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.editText);
        Button btnAddFragment = findViewById(R.id.btnAddFragment);

        btnAddFragment.setOnClickListener(v -> {
            String inputText = editText.getText().toString();

            if (inputText.isEmpty()) {
                Toast.makeText(MainActivity.this, "El campo de texto está vacío", Toast.LENGTH_SHORT).show();
                return;
            }

            // Crear una instancia del fragmento con el texto ingresado
            Fragment textFragment = TextFragment.newInstance(inputText);

            // Reemplazar el fragmento en el contenedor
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentContainer, textFragment);
            transaction.commit();
        });
    }
}
