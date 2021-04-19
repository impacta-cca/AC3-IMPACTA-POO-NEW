import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoAcademicaApp1 {
/*
    //Listar os números = id () e nomes(ok) de todos os estudantes.
    public void listaNomeEstudantes(ArrayList<Estudante> Estudantes){
        System.out.println("==========LISTA DE ALUNOS==============");
        for (Estudante aluno : Estudantes){
            System.out.println(aluno.getId(), aluno);//imprimir id tbm (getId)
        }
    }

    // Listar os códigos de todas as disciplinas.
     public void listaCodigosDiscip(ArrayList<Disciplina> codigo){
            System.out.println("========== LISTA DE CÓDIGOS DE DISCIPLINAS ==========");
            for ( codigo : Disciplina) {
                System.out.print(codigo + "\n");
            }
        }

    /*   Listar todas as informações dos estudantes matriculados em uma determinada disciplina.
    //   Nesta opção, o usuário deverá fornecer o código da disciplina e a aplicação deverá
    //   apresentar uma -lista dos estudantes matriculados nesta disciplina (com o número
    //   identificado, o nome e o e-mail do aluno) e o -número total de alunos matriculados nesta
         disciplina.*/

    /*

    public void listaEstudanteDisc(ArrayList<Disciplina> Disciplinas){
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o código da disciplina: ");
        String codigo = in.nextLine();
        //identificar de qual disc é o cód digitado, a partir disso get estudantes(all info) matriculados(numa lista)
        //System.out.println("==========LISTA DE ALUNOS MATRICULADOS NESSA DISCIPLINA==============");

        //get créditos de tal disciplina
        //System.out.println("==========TOTAL DE ALUNOS MATRICULADOS NESSA DISCIPLINA==============");
        }


    /*
    Listar todas as informações das disciplinas em que um determinado estudante está
      matriculado. Nesta opção, o usuário deverá fornecer o número identificador do estudante
      e a aplicação deverá apresentar uma

      Disciplina -> estudantes

    */
    /*
     public void listaInfoDiscip(int identificador){
        ArrayList<Disciplina> disc = new ArrayList<Disciplina>;
        ArrayList<Estudante> est = new ArrayList<Estudante>;
        Estudante find;

        for ( Estudante aluno : est) {
            if ( aluno.getId() == identificador ) {
            find = aluno;
            }
        }

        // lista das disciplinas em que ele está matriculado
        List<Disciplina> listaDisc = find.getDisciplinasMatriculadas();

        for ( Disciplina d : listaDisc ) {
            // o código
            System.out.println(d.getCodigo());
            // número de créditos da disciplina
            System.out.println(d.getCreditos());
        }

        // total de créditos das matrículas do aluno.
        for ( Disciplina creditos  : listaDisc ) {
            int total = total + getCreditos;
            System.out.println(total);
        }
     }
*/
}
