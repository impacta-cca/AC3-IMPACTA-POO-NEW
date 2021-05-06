import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Faculdade {
    private String Nome;
    private ArrayList<Estudante> estudantes = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

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

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Faculdade(String nomeFaculdadeEsperado) {
        Nome = nomeFaculdadeEsperado;
    }

    public void carregarDadosArquivo(String nomeArquivoDisciplinas, String nomeArquivoEstudantes, String nomeArquivoMatriculas) {
        try {

            //buffer para leitura dos arquivos de cada classe
            BufferedReader arqEstudante = new BufferedReader(new FileReader(nomeArquivoEstudantes));
            BufferedReader arqDisciplina = new BufferedReader(new FileReader(nomeArquivoDisciplinas));
            BufferedReader arqMatriculas = new BufferedReader(new FileReader(nomeArquivoMatriculas));


            // Faz a leitura de cada arquivo, separando por linha e atributo
            int nlinhaEstudante = 0;
            int nlinhaDisciplinas = 0;
            int nlinhaMatricula = 0;

            while(arqEstudante.readLine() != null){
                nlinhaEstudante++;
            }

            while(arqDisciplina.readLine() != null){
                nlinhaDisciplinas++;
            }

            while(arqMatriculas.readLine() != null){
                nlinhaMatricula++;
            }

            arqEstudante = new BufferedReader(new FileReader(nomeArquivoEstudantes));
            arqDisciplina = new BufferedReader(new FileReader(nomeArquivoDisciplinas));
            arqMatriculas = new BufferedReader(new FileReader(nomeArquivoMatriculas));


            // loop para criar as instancias da classe Estudante e disciplina e add na ArrayList Estudante e
            // ArrayList Disciplina da classe Faculdade

            for (int i = 0; i < nlinhaEstudante; i++) {
                String[] linhaEstudante = arqEstudante.readLine().split(":");
                Estudante estudante = new Estudante(Integer.parseInt(linhaEstudante[0]),linhaEstudante[1],linhaEstudante[2]);
                this.estudantes.add(estudante);
            }

            for(int i=0;i<nlinhaDisciplinas;i++){
                String[] linhaDisciplina = arqDisciplina.readLine().split(":");
                Disciplina disciplina = new Disciplina(linhaDisciplina[0],Integer.parseInt(linhaDisciplina[1]));
                this.disciplinas.add(disciplina);
            }

            for(int i=0;i<nlinhaMatricula;i++){
                String[] linhaMatricula = arqMatriculas.readLine().split(":");
                int indexEstudante = 0;
                int indexDisciplina = 0;
                for(Estudante estudante: estudantes){
                    if(estudante.getId() == Long.parseLong(linhaMatricula[0])){
                        indexEstudante = estudantes.indexOf(estudante);
                    }
                }

                for(Disciplina disciplina: disciplinas){
                    if(disciplina.getCodigo().equals(linhaMatricula[1])){
                        indexDisciplina = disciplinas.indexOf(disciplina);
                    }
                }
                Matricula matricula = new Matricula(estudantes.get(indexEstudante),disciplinas.get(indexDisciplina));
                estudantes.get(indexEstudante).addMatricula(matricula);
                disciplinas.get(indexDisciplina).addMatricula(matricula);
            }
            arqEstudante.close();
            arqDisciplina.close();
            arqMatriculas.close();
        } catch (IOException ex) {
            Logger.getLogger(Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
