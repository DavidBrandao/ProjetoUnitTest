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
        assertEquals(cidade1.nome, Cidade.encontrar("Primeira Cidade").toString(),"Cidade não encontrada");
    }

    @Test
    void testValidarCidadeNaoEcontrada() {
        Cidade cidadeCriada = Cidade.encontrar(cidade3);
        assertEquals(cidade3, cidadeCriada.nome, "Cidade não encontrada");
    }

    @Test
    void addLink() {
        Link link = new Link(cidade1, cidade2,2);
        Cidade cidadeLinks = new Cidade(cidade3);
        cidadeLinks.addLink(link);
        assertEquals("[Olinda 2 Recife]", cidadeLinks.links.toString(), "O link informado difere do esperado");
    }

    @Test
    void comparaNomePositivo() {
        assertEquals(3, cidade1.comparaNome(cidade2),"Cidade 2 não é alfabeticamente menor do que a cidade 1");
    }

    @Test
    void comparaNomeNegativo() {
        assertEquals(- 3, cidade2.comparaNome(cidade1),"Cidade 1 não é alfabeticamente menor do que a cidade 2");
    }

    @Test
    void comparaNomeIgual() {
        assertEquals(0, cidade1.comparaNome(cidade1),"Os nomes das cidades não são iguais");
    }

    @Test
    void testToString() {
        assertEquals("Recife", cidade1.toString(), "Resultado esperado difere do informado");
    }

    @Test
    void comparaDistanciaPositivaNovo() {
        assertEquals(50, Cidade.comparaDistancia(cidade1, cidade2), "Primeiro parametro é menor ou igual ao  segundo");
    }

    @Test
    void comparaDistanciaNegativaNovo() {
        assertEquals(-50, Cidade.comparaDistancia(cidade2, cidade1), "Primeiro parametro é maior ou igual ao segundo");
    }

    @Test
    void comparaDistanciaIgualNovo() {
        assertEquals(0, Cidade.comparaDistancia(cidade2, cidade2), "Distancias informadas não são iguais");
    }
}