import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorCidadeTest {

    ComparadorCidade comparadorCidade = new ComparadorCidade();

    static Cidade cidade1 = new Cidade("Primeira Cidade");
    static Cidade cidade2 = new Cidade("Segunda Cidade");

    @BeforeAll
    public static void popularCidades(){

        cidade1.nome = "Recife";
        cidade1.distancia = 100;
        cidade2.nome = "Olinda";
        cidade2.distancia = 50;
    }

    @Test
    void comparaDistanciaPositivaNovo() {
        assertEquals(50, comparadorCidade.compare(cidade1, cidade2));
    }

    @Test
    void comparaDistanciaNegativaNovo() {
        assertEquals(-50, comparadorCidade.compare(cidade2, cidade1));
    }

    @Test
    void comparaDistanciaIgualNovo() {
        assertEquals(0, comparadorCidade.compare(cidade2, cidade2));
    }
}