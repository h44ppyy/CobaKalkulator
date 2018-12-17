package com.example.bheab.cobakalkulator;

import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.EditText;

import android.widget.Spinner;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Called when the activity is first created

    private EditText angka1;

    private EditText angka2;

    private Spinner spinOperasi;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        angka1 = (EditText)findViewById(R.id.editPertama);

        angka2 = (EditText)findViewById(R.id.editKedua);

        spinOperasi = (Spinner)findViewById(R.id.spinnerOperasi);

    }

    public void buttonHandler (View view){

        double a, b, hasil;

        if(angka1.getText().length() == 0){

            Toast.makeText(this, "Angka Pertama masih kosong", Toast.LENGTH_LONG).show();

            return;

        }

        if(angka2.getText().length() == 0){

            Toast.makeText(this, "Angka Kedua masih kosong", Toast.LENGTH_LONG).show();

            return;

        }

        a = Double.parseDouble(angka1.getText().toString());

        b = Double.parseDouble(angka2.getText().toString());

        //hasil = a + b;

        switch (spinOperasi.getSelectedItemPosition()){

            case 0 :

                hasil = a + b;

                break;

            case 1 :

                hasil = a - b;

                break;

            case 2 :

                hasil = a * b;

                break;

            case 3 :

                hasil = a / b;

                break;

            default :

                hasil = a + b;

                break;

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Hasil Operasi"+spinOperasi.getSelectedItem().toString());

        builder.setMessage("Hasil = "+String.valueOf(hasil)).setPositiveButton("OK", new DialogInterface.OnClickListener(){

            @Override

            public void onClick(DialogInterface dialog, int which){

                //TODO Auto-generated method stub

                angka1.setText("");

                angka2.setText("");

                dialog.dismiss();

            }

        });

        AlertDialog dialogHasil = builder.create();

        dialogHasil.show();

        

    }

}