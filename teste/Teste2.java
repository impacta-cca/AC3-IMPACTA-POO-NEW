import org.junit.Test;

public class Teste2 {
    @Test
    public  void TestarCarregarDados(){
        Faculdade faculdade = new Faculdade("Impacta - FIT");
        faculdade.carregarDadosArquivo("disciplinas-bccdbdedee.txt","estudantes-bccdbdedee.txt","matriculas-bccdbdedee.txt");
        System.out.println(faculdade.getEstudantes().get(0).getNome()+" "+faculdade.getDisciplinas().get(0).getCodigo());
        Matricula matricula  = new Matricula(faculdade.getEstudantes().get(0),faculdade.getDisciplinas().get(0));

        System.out.println(faculdade.getEstudantes().get(0).getMatriculas().get(1).getDisciplina().getCodigo());

    }


    @Test
    public void testaraddmatricula(){
        Estudante estudantetest = new Estudante(0,"Lucas","Lucas@Lucas.Lucas");
        Disciplina disciplinatest = new Disciplina("0032",50);
        Matricula matricula = new Matricula(estudantetest,disciplinatest);
        estudantetest.addMatricula(matricula);
        disciplinatest.addMatricula(matricula);
        System.out.println(estudantetest.getMatriculas().get(0).toString());
        System.out.println(disciplinatest.getMatriculas().get(0).toString());
    }
}
