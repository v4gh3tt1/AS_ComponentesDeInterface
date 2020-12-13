    package dev.smartpanda.componentesdeinterfacegrafica;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.TextView;

    import com.google.android.material.textfield.TextInputEditText;

    public class MainActivity extends AppCompatActivity {

    // variaveis acecssiveis por toda a classe

    //Campos de texto
    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    //checkBox
    private CheckBox checkVerde, checkBranco, checkVermelho;

    //radioButton
    private RadioButton sexoMasc,sexoFem, sexoUnicornio;

    String textoCheckBox = "";
    String textoSexo = "";
    String textoNomeEmail= "";

    //uso do radioGroup para exibir informação ao clicar
    private RadioGroup opcaoAcordo;
    private RadioButton radioCorreto, radioIncorreto;
    private String textoAcordo="";
    private TextView textAcordo;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicialização das variaveis ao criar o activity_main. Variavel ligada aos campos graficos respectivos

        //checkBox
        checkVerde = findViewById(R.id.checkBoxVerde);
        checkBranco = findViewById(R.id.checkBoxBranco);
        checkVermelho = findViewById(R.id.checkBoxVermelho);

        //Campos de texto
        //variavel campoNome, do tipo EditText recebe texto digitado na caixa editNome
        this.campoNome = findViewById(R.id.editNome);
        //variavel campoEmail, do tipo TextInputEditText recebe texto digitado na caixa editEmail
        this.campoEmail = findViewById(R.id.editEmail);
        // variavel textoResuldao, tipo TextView, recebe valor da caixa textResultado
        this.textoResultado = findViewById(R.id.textResultado);

        //RadioButton
        sexoMasc = findViewById(R.id.radioButtonMasc);
        sexoFem = findViewById(R.id.radioButtonFem);
        sexoUnicornio = findViewById(R.id.radioUnicornio);

        //radioGoup

        opcaoAcordo = findViewById(R.id.radioGroupAcordo);
        radioCorreto = findViewById(R.id.radioCorreto);
        radioIncorreto = findViewById(R.id.radioIncorreto);
        textAcordo = findViewById(R.id.textAcordo);

        acordo(); //metodo ouvinte, aguardando ocorrer determinada situacao deve ser chamado no on create

    }

    /*
    metodo ouvinte, aguarda o evento para rodar. neste caso, quando clica no radiobutton executa a ação
     */
    public void acordo(){
        opcaoAcordo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) { // ao clicar no radio, retorna um int, que sera comparado
                if (checkedId ==R.id.radioCorreto){ // comparacao do id retornado ao clicar com id do radioButton especifico
                    textoAcordo = radioCorreto.getText().toString();
                    textAcordo.setText( textoAcordo);
                }
                else if (checkedId == R.id.radioIncorreto){ // comparacao do id retornado ao clicar com id do radioButton especifico
                   // textoAcordo = radioIncorreto.getText().toString();
                    textAcordo.setText(textoAcordo = radioIncorreto.getText().toString());
                }
            }
        });
    }


    public void checkbox(){


        if ( checkVerde.isChecked() ){ // verifica se esta marcado
           // String corSelecionada = checkVerde.getText().toString();
           // textoCheckBox = corSelecionada;
            textoCheckBox = textoCheckBox + "verde Selecionado \n";
        }
        if ( checkBranco.isChecked() ){ // verifica se esta marcado
            textoCheckBox = textoCheckBox + "branco Selecionado \n";
        }
        if ( checkVermelho.isChecked() ){ // verifica se esta marcado
            textoCheckBox = textoCheckBox + "vermelho Selecionado \n";
        }

      //  textoResultado.setText( textoCheckBox );
    }

        public void radioButton(){


        if (sexoMasc.isChecked()){
            textoSexo = sexoMasc.getText().toString();
        }
        if (sexoFem.isChecked()){
            textoSexo = sexoFem.getText().toString();
        }
        if (sexoUnicornio.isChecked()){
            textoSexo = sexoUnicornio.getText().toString();
        }
        }

        //campos de texto

    public void campoTexto (){
         String email = campoEmail.getText().toString();
        String nome = campoNome.getText().toString();

        textoNomeEmail = (email + ", " + nome + "\n");

    }

    /*
    metodo que recupera dados digitados e exibe em uma caixa de texto apos clicar no botao enviar
    pode ser usado para enviar para banco de dados em vez de manda para caixa de texto

     */

        public void enviar(View view){ // obs: sera setado o ultimo evento no textoresultado

            checkbox();
            campoTexto();
            radioButton();

        //Variavel nome e email, do tipo String, recebe o valor de campoNome e campoEmail convertidos com metodo toString

        textoResultado.setText( textoNomeEmail + ", " + textoCheckBox + ", " + textoSexo );
        //campo textoResultado usa o metodo setText para capturar e exibir  variavel nome e email

    }

    // metodo para limpar os campos digitados

    public void limpar (View view){

        campoNome.setText("");
        campoEmail.setText("");
        textoResultado.setText("");
    }
    }
