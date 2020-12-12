package dev.smartpanda.componentesdeinterfacegrafica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    // variaveis acecssiveis por toda a classe

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox checkVerde, checkBranco, checkVermelho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkBox

        checkVerde = findViewById(R.id.checkBoxVerde);
        checkBranco = findViewById(R.id.checkBoxBranco);
        checkVermelho = findViewById(R.id.checkBoxVermelho);

        // inicialização das variaveis ao criar o activity_main

        //variavel campoNome, do tipo EditText recebe texto digitado na caixa editNome
        this.campoNome = findViewById(R.id.editNome);
        //variavel campoEmail, do tipo TextInputEditText recebe texto digitado na caixa editEmail
        this.campoEmail = findViewById(R.id.editEmail);
        // variavel textoResuldao, tipo TextView, recebe valor da caixa textResultado
        this.textoResultado = findViewById(R.id.textResultado);
    }

    public void checkbox(){

        String texto = "";

        if ( checkVerde.isChecked() ){ // verifica se esta marcado
           // String corSelecionada = checkVerde.getText().toString();
           // texto = corSelecionada;
            texto = texto + "verde Selecionado, \n";
        }
        if ( checkBranco.isChecked() ){ // verifica se esta marcado
            texto = texto + "branco Selecionado, \n";
        }
        if ( checkVermelho.isChecked() ){ // verifica se esta marcado
            texto = texto + "vermelho Selecionado, \n";
        }

        textoResultado.setText( texto );
    }

    /*
    metodo que recupera dados digitados e exibe em uma cixa de texto apos clicar no botao enviar
    pode ser usado para enviar para banco de dados em vez de manda para caixa de texto

     */
    public void enviar(View view){

        checkbox();

/*
        String email = campoEmail.getText().toString();
        String nome = campoNome.getText().toString();
        //Variavel nome e email, do tipo String, recebe o valor de campoNome e campoEmail convertidos com metodo toString


        textoResultado.setText("nome: " + nome + ", email: " + email );
        //campo textoResultado usa o metodo setText para capturar e exibir  variavel nome e email
*/
    }

    // metodo para limpar os campos digitados

    public void limpar (View view){

        campoNome.setText("");
        campoEmail.setText("");
        textoResultado.setText("");
    }
}
