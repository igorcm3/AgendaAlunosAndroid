package br.com.empresax.agendadealunos.helper;

import android.widget.EditText;
import android.widget.RatingBar;
import br.com.empresax.agendadealunos.FormularioActivity;
import br.com.empresax.agendadealunos.R;
import br.com.empresax.agendadealunos.modelo.Aluno;


public class FormularioHelper {
    EditText edtNome;
    EditText edtEndereco;
    EditText edtTelefone;
    EditText edtEmail;
    RatingBar rbNota;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        edtNome = activity.findViewById(R.id.edtNome);
        edtEndereco = activity.findViewById(R.id.edtEndereco);
        edtTelefone = activity.findViewById(R.id.edtTelefone);
        edtEmail = activity.findViewById(R.id.edtEmail);
        rbNota = activity.findViewById(R.id.rbNota);

        aluno = new Aluno();
    }

    public Aluno getAluno() {
        aluno.setNome(edtNome.getText().toString());
        aluno.setEndereco(edtEndereco.getText().toString());
        aluno.setTelefone(edtTelefone.getText().toString());
        aluno.setEmail(edtEmail.getText().toString());
        aluno.setNota(Double.valueOf(rbNota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        edtNome.setText(aluno.getNome());
        edtEndereco.setText(aluno.getEndereco());
        edtTelefone.setText(aluno.getTelefone());
        edtEmail.setText(aluno.getEmail());
        rbNota.setProgress(aluno.getNota().intValue());

        this.aluno = aluno;
    }
}
