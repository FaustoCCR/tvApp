package com.faustoc.tvapp_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainTvActivity extends AppCompatActivity {


    //variables
    private EditText codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tv);

        codigo = findViewById(R.id.editTextCodigo);

    }

    public void enter(View view){

        int code_lenght = codigo.getText().length();
        if (code_lenght == 0){
            Toast.makeText(this,"Ingresa el código",Toast.LENGTH_LONG).show();
        }else{
            //instanciar el intent
            Intent intent = new Intent(this,TvActivity2.class);
            String code = codigo.getText().toString();
            intent.putExtra("code",code);
            codigo.setText("");
            startActivity(intent);
        }


    }
}