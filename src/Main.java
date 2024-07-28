import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

public class Main {
    private static final String CURSO_JAVA_TITULO = "Curso Java";
    private static final String CURSO_JAVA_DESCRICAO = "Descrição curso Java";
    private static final int CURSO_JAVA_CARGA_HORARIA = 8;

    private static final String CURSO_JS_TITULO = "Curso JavaScript";
    private static final String CURSO_JS_DESCRICAO = "Descrição curso JavaScript";
    private static final int CURSO_JS_CARGA_HORARIA = 4;

    private static final String MENTORIA_JAVA_TITULO = "Mentoria de Java";
    private static final String MENTORIA_JAVA_DESCRICAO = "Descrição mentoria Java";

    public static void main(String[] args) {
        Curso curso1 = criarCurso(CURSO_JAVA_TITULO, CURSO_JAVA_DESCRICAO, CURSO_JAVA_CARGA_HORARIA);
        Curso curso2 = criarCurso(CURSO_JS_TITULO, CURSO_JS_DESCRICAO, CURSO_JS_CARGA_HORARIA);
        Mentoria mentoria = criarMentoria(MENTORIA_JAVA_TITULO, MENTORIA_JAVA_DESCRICAO);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        exibirProgresso(devCamila);

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        exibirProgresso(devJoao);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static Mentoria criarMentoria(String titulo, String descricao) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(LocalDate.now());
        return mentoria;
    }

    private static void exibirProgresso(Dev dev) {
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        dev.progredir();
        dev.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos " + dev.getNome() + ": " + dev.getConteudosConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());
    }
}
