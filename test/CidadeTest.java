import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {

    static Cidade cidade1 = new Cidade("Primeira Cidade");
    static Cidade cidade2 = new Cidade("Segunda Cidade");
    static String cidade3 = "Paulista";

    public void ImprimirCidades(){
        System.out.println(Cidade.cidades);
    }

    @BeforeAll
    public static void popularCidades(){

        cidade1.nome = "Recife";
        cidade1.distancia = 100;
        cidade2.nome = "Olinda";
        cidade2.distancia = 50;
    }

    @Test
    void testValidarCidadeEcontrada() {
        assertEquals(cidade1.nome, Cidade.encontrar("Primeira Cidade"));
    }

    @Test
    void testValidarCidadeNaoEcontrada() {
        Cidade cidadeCriada = Cidade.encontrar(cidade3);
        assertEquals(cidade3, cidadeCriada.nome);
    }

    @Test
    void addLink() {
        Link link = new Link(cidade1, cidade2,2);
        Cidade cidadeLinks = new Cidade(cidade3);
        cidadeLinks.addLink(link);
        assertEquals("[Olinda Recife]", cidadeLinks.links.toString());
    }

    @Test
    void comparaNomePositivo() {
        assertEquals(3, cidade1.comparaNome(cidade2));
    }

    @Test
    void comparaNomeNegativo() {
        assertEquals(- 3, cidade2.comparaNome(cidade1));
    }

    @Test
    void comparaNomeIgual() {
        assertEquals(0, cidade1.comparaNome(cidade1));
    }

    @Test
    void testToString() {
        assertEquals("Recife", cidade1.toString());
    }

    @Test
    void comparaDistanciaPositivaNovo() {
        assertEquals(50, Cidade.comparaDistancia(cidade1, cidade2));
    }

    @Test
    void comparaDistanciaNegativaNovo() {
        assertEquals(-50, Cidade.comparaDistancia(cidade2, cidade1));
    }

    @Test
    void comparaDistanciaIgualNovo() {
        assertEquals(0, Cidade.comparaDistancia(cidade2, cidade2));
    }
}