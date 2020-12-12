package br.com.empresax.agendadealunos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import br.com.empresax.agendadealunos.helper.FormularioHelper;
import br.com.empresax.agendadealunos.modelo.Aluno;
import br.com.empresax.agendadealunos.dao.AlunoDAO;
import android.content.Intent;

public class FormularioActivity extends AppCompatActivity {
    private FormularioHelper formularioHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        formularioHelper = new FormularioHelper(this);

        Intent intent = getIntent();
        Aluno aluno = (Aluno) intent.getSerializableExtra("aluno");
        if(aluno!=null) {
            formularioHelper.preencheFormulario(aluno);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Aluno aluno = formularioHelper.getAluno();

                AlunoDAO alunoDAO = new AlunoDAO(this);

                if(aluno.getId()==null) {
                    alunoDAO.insere(aluno);
                } else {
                    alunoDAO.altera(aluno);
                }
                alunoDAO.close();

                Toast.makeText(FormularioActivity.this,
                        "Aluno " + aluno.getNome() + " salvo com sucesso!",
                        Toast.LENGTH_SHORT).show();
                finish();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



