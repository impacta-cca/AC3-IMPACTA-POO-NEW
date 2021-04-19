import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Faculdade {
    private String Nome;
    private ArrayList<Estudante> estudantes;
    private ArrayList<Disciplina> diciplinas;

    // Métodos de acesso aos atributos


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public List<Disciplina> getDisciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(ArrayList<Disciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }

    public Faculdade(String nomeFaculdadeEsperado) {
        Nome = nomeFaculdadeEsperado;
    }



public void carregarDados() {
    try {
        BufferedReader r = new BufferedReader(new FileReader("EstudanteEntrada.txt"));
        String linha = r.readLine();
        int n = Integer.parseInt(linha);
        String[] linhas;
        ArrayList<Estudante> acumulador = new ArrayList<Estudante>();
        for (int i = 0; i < n; i++) {
            linha = r.readLine();
            linhas = linha.split(":");
            Estudante addal = new Estudante(
                    Integer.parseInt(linhas[0]),
                    linhas[1],
                    linhas[2]
            );
          this.estudantes.add(addal);
        }
        r.close();

        for(Estudante alunos: estudantes){
            System.out.println(alunos.toString());
        }
    } catch (IOException ex) {
        Logger.getLogger(Faculdade.class.getName()).log(Level.SEVERE, null, ex);

    }
}


    public void carregarDadosArquivo(String nomeArquivoDisciplinas, String nomeArquivoEstudantes, String nomeArquivoMatriculas) {
        
    }



}
