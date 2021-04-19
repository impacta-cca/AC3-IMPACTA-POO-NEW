
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random ;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class FaculdadeTest {


    private final Faculdade faculdade;
    private final String nomeFaculdadeEsperado;
    private String[][] disciplinasArray;
    private String[][] estudantesArray;
    private int[] matriculasPorEstudante;
    private int[] matriculasPorDisciplina;
    private String[][] matriculasArray;

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public String getNomeFaculdadeEsperado() {
        return nomeFaculdadeEsperado;
    }

    public String[][] getDisciplinasArray() {
        return disciplinasArray;
    }

    public void setDisciplinasArray(String[][] disciplinasArray) {
        this.disciplinasArray = disciplinasArray;
    }

    public String[][] getEstudantesArray() {
        return estudantesArray;
    }

    public void setEstudantesArray(String[][] estudantesArray) {
        this.estudantesArray = estudantesArray;
    }

    public int[] getMatriculasPorEstudante() {
        return matriculasPorEstudante;
    }

    public void setMatriculasPorEstudante(int[] matriculasPorEstudante) {
        this.matriculasPorEstudante = matriculasPorEstudante;
    }

    public int[] getMatriculasPorDisciplina() {
        return matriculasPorDisciplina;
    }

    public void setMatriculasPorDisciplina(int[] matriculasPorDisciplina) {
        this.matriculasPorDisciplina = matriculasPorDisciplina;
    }

    public String[][] getMatriculasArray() {
        return matriculasArray;
    }

    public void setMatriculasArray(String[][] matriculasArray) {
        this.matriculasArray = matriculasArray;
    }

    public FaculdadeTest() throws FileNotFoundException {
        String testeId = randomString("abcde", 10);
        String nomeArquivoDisciplinas = "disciplinas-" + testeId + ".txt";
        String nomeArquivoEstudantes = "estudantes-" + testeId + ".txt";
        String nomeArquivoMatriculas = "matriculas-" + testeId + ".txt";

        criarArquivoEstudantes(nomeArquivoEstudantes);
        criarArquivoDisciplinas(nomeArquivoDisciplinas);
        criarArquivoMatriculas(nomeArquivoMatriculas);

        nomeFaculdadeEsperado = "Faculdade Impacta de Tecnologia" + testeId;
        faculdade = new Faculdade(nomeFaculdadeEsperado);
        faculdade.carregarDadosArquivo(nomeArquivoDisciplinas, nomeArquivoEstudantes,
                nomeArquivoMatriculas);
    }

    public void criarArquivoEstudantes(String nomeArquivo) throws FileNotFoundException {
        estudantesArray = new String[3][];
        String matricula;
        matricula = randomString("1141629800", 8);
        estudantesArray[0] = new String[]{matricula, "Jonatas Gomes", matricula + "@aluno.faculdadeimpacta.com.br"};
        matricula = randomString("1140250885", 8);
        estudantesArray[1] = new String[]{matricula, "Lucas Lopes", matricula + "@aluno.faculdadeimpacta.com.br"};
        matricula = randomString("1140887929", 8);
        estudantesArray[2] = new String[]{matricula, "Renata Silveira", matricula + "@aluno.faculdadeimpacta.com.br"};

        try (PrintWriter pw = new PrintWriter(nomeArquivo)) {
            for (String[] estudante : estudantesArray) {
                pw.println(estudante[0] + ":" + estudante[1] + ":" + estudante[2]);
            }
        }
    }

    public void criarArquivoDisciplinas(String nomeArquivo) throws FileNotFoundException {
        disciplinasArray = new String[3][];
        disciplinasArray[0] = new String[]{"Estrutura de Dados", "80"};
        disciplinasArray[1] = new String[]{"Programação Orientada a Objetos", "40"};
        disciplinasArray[2] = new String[]{"Sistemas Operacionais", "80"};

        try (PrintWriter pw = new PrintWriter(nomeArquivo)) {
            for (String[] disciplina : disciplinasArray) {
                pw.println(disciplina[0] + ":" + disciplina[1]);
            }
        }
    }

    public void criarArquivoMatriculas(String nomeArquivo) throws FileNotFoundException {
        matriculasArray = new String[7][];
        matriculasPorEstudante = new int[]{3, 2, 2};
        matriculasPorDisciplina = new int[]{2, 3, 2};
        matriculasArray[0] = new String[]{estudantesArray[0][0], disciplinasArray[0][0]};
        matriculasArray[1] = new String[]{estudantesArray[0][0], disciplinasArray[1][0]};
        matriculasArray[2] = new String[]{estudantesArray[0][0], disciplinasArray[2][0]};
        matriculasArray[3] = new String[]{estudantesArray[1][0], disciplinasArray[1][0]};
        matriculasArray[4] = new String[]{estudantesArray[1][0], disciplinasArray[0][0]};
        matriculasArray[5] = new String[]{estudantesArray[2][0], disciplinasArray[1][0]};
        matriculasArray[6] = new String[]{estudantesArray[2][0], disciplinasArray[2][0]};
        try (PrintWriter pw = new PrintWriter(nomeArquivo)) {
            for (String[] matricula : matriculasArray) {
                pw.println(matricula[0] + ":" + matricula[1]);
            }
        }
    }



    public String randomString(String chars, int length) {
        Random rand = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return buf.toString();
    }

    public Estudante findEstudanteById(int id, List<Estudante> estudantes) {
        for (Estudante estudante : estudantes) {
            if (id == estudante.getId()) {
                return estudante; //estudante encontrado
            }
        }
        return null; //estudante não encontrado
    }

    public Disciplina findDisciplinaByCodigo(String codigo, List<Disciplina> disciplinas) {
        for (Disciplina disciplina : disciplinas) {
            if (codigo.equals(disciplina.getCodigo())) {
                return disciplina;//disciplina encontrada
            }
        }
        return null;//disciplina não encontrada
    }

    @Test
    public void testNomeFaculdade() {
        String nomeObtido = faculdade.getNome();
        assertEquals(nomeFaculdadeEsperado, nomeObtido);
    }

    @Test
    public void testEstudantes() {
        List<Estudante> estudantes = faculdade.getEstudantes();
        int numeroEsperado = estudantesArray.length;
        int numeroObtido = estudantes.size();
       assertEquals(numeroEsperado, numeroObtido);
        for (String[] estudanteArray : estudantesArray) {
            int id = Integer.parseInt(estudanteArray[0]);
            String nomeEsperado = estudanteArray[1];
            String emailEsperado = estudanteArray[2];
            Estudante estudanteEncontrado = findEstudanteById(id, estudantes);
            assertNotNull(estudanteEncontrado);
            assertEquals(nomeEsperado, estudanteEncontrado.getNome());
            assertEquals(emailEsperado, estudanteEncontrado.getEmail());
        }
    }

    @Test
    public void testDisciplinas() {
        List<Disciplina> disciplinas = faculdade.getDisciplinas();
        int numeroEsperado = disciplinasArray.length;
        int numeroObtido = disciplinas.size();
        assertEquals(numeroEsperado, numeroObtido);
        for (String[] disciplinaArray : disciplinasArray) {
            String codigo = disciplinaArray[0];
            int creditos = Integer.parseInt(disciplinaArray[1]);
            Disciplina disciplinaEncontrada = findDisciplinaByCodigo(codigo, disciplinas);
            assertNotNull(disciplinaEncontrada);
            assertEquals(creditos, disciplinaEncontrada.getCreditos());
        }
    }

    @Test
    public void testMatriculas() {
        List<Estudante> estudantes = faculdade.getEstudantes();
        List<Disciplina> disciplinas = faculdade.getDisciplinas();
        List<Matricula> matriculas =  null;

        for (int i=0; i<estudantesArray.length; i++) {
            String[] estudanteArray = estudantesArray[i];
            int id = Integer.parseInt(estudanteArray[0]);
            Estudante estudante = findEstudanteById(id, estudantes);
            assertEquals(matriculasPorEstudante[i], estudante.getMatriculas().size());
        }

        for (int i=0; i<disciplinasArray.length; i++) {
            String[] disciplinaArray = disciplinasArray[i];
            String codigo = disciplinaArray[0];
            Disciplina disciplina = findDisciplinaByCodigo(codigo, disciplinas);
            assertEquals(matriculasPorDisciplina[i], disciplina.getMatriculas().size());
        }

        for (String[] matriculaArray : matriculasArray) {
            int idEstudante = Integer.parseInt(matriculaArray[0]);
            String codigoDisciplina = matriculaArray[1];
            Estudante estudante = findEstudanteById(idEstudante, estudantes);
            Disciplina disciplina = findDisciplinaByCodigo(codigoDisciplina, disciplinas);

            Matricula matriculaEncontradaInEstudante = null;
            matriculas = estudante.getMatriculas();
            for (Matricula matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo())
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInEstudante = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInEstudante);

            Matricula matriculaEncontradaInDisciplina = null;
            matriculas = disciplina.getMatriculas();
            for (Matricula matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo())
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInDisciplina = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInDisciplina);
        }
    }

}
