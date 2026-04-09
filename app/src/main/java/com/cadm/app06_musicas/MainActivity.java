package com.cadm.app06_musicas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editMusica, editBanda, editAno;
    private RadioGroup radioGrupo;
    private Button btnAdicionar;
    private TextView txtLista;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtLista = findViewById(R.id.txtViewLista);
        radioGrupo = findViewById(R.id.grupoRadio);
        editBanda = findViewById(R.id.editNomeArtista);
        editAno = findViewById(R.id.editAnoMusica);
        editMusica = findViewById(R.id.editNomeMusica);
        radioGrupo = findViewById(R.id.grupoRadio);
        btnAdicionar = findViewById(R.id.btEnviar);

        btnAdicionar.setOnClickListener(v -> adicionarMusica());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    private void adicionarMusica(){
        String musica = editMusica.getText().toString();
        String banda = editBanda.getText().toString();
        String ano = editAno.getText().toString();

        int idSelecionado = radioGrupo.getCheckedRadioButtonId();

        if(idSelecionado == -1){
            Toast.makeText(this, "selecione um estilo", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton radioSelecionado = findViewById(idSelecionado);
        String estilo = radioSelecionado.getText().toString();

        String resultado = " " + musica +
                "\nBanda: " + banda +
                "\nAno: " + ano +
                "\nEstilo: " + estilo +
                "\n\n";

        txtLista.append(resultado);
        limparCampos();

        if(musica.isEmpty() || banda.isEmpty() || ano.isEmpty()){
            Toast.makeText(this,"Preencha todos os campos!", Toast.LENGTH_SHORT).show();

        }else{

        }

    }

    private void limparCampos(){
        editMusica.setText("");
        editBanda.setText("");
        editAno.setText("");
        radioGrupo.clearCheck();
    }



}