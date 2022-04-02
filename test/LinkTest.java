import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    static Cidade cidade1 = new Cidade("Primeira Cidade");
    static Cidade cidade2 = new Cidade("Segunda Cidade");
    static Cidade cidade3 = new Cidade("Terceira Cidade");
    static int tamanho = 10;
    static int tamanhoNegativo = -10;
    static int tamanhoZero = 0;
    static String stringDesejadaLink = "Amegakure 10 Konoha";
    static String stringDesejadaLinkInvertido = "Konoha 10 Amegakure";

    @BeforeAll
    public static void popularCidades(){
        cidade1.nome = "Konoha";
        cidade1.distancia = 100;
        cidade2.nome = "Amegakure";
        cidade2.distancia = 50;
        cidade3.nome = "Miyuki";
        cidade3.distancia = 50;
    }

    @Test
    void testGetTamanhoPositivo() {
        Link link = new Link(cidade1, cidade2, tamanho);
        assertEquals(tamanho, link.getTamanho(), "Tamanho informado difere do esperado");
    }

    @Test
    void testGetTamanhoNegativo() {
        Link link = new Link(cidade1, cidade2, tamanhoNegativo);
        assertEquals(tamanhoNegativo, link.getTamanho(), "Tamanho informado difere do esperado");
    }

    @Test
    void testGetTamanhoZerado() {
        Link link = new Link(cidade1, cidade2, tamanhoZero);
        assertEquals(tamanhoZero, link.getTamanho(), "Tamanho informado difere do esperado");
    }

    @Test
    void testIsUsadoTrue() {
        Link link = new Link(cidade1, cidade2, tamanho);
        assertTrue(link.isUsado(), "Resultado retornado pelo metodo não foi true");
    }

    @Test
    void testIsUsadoFalse(){
        Link link = new Link(cidade1, cidade2, tamanho);
        link.usado = false;
        assertFalse(link.isUsado(), "Resultado retornado pelo metodo não foi false");
    }

    @Test
    void testSetUsadoFalse() {
        Link link = new Link(cidade1, cidade2, tamanho);
        link.setUsado(false);
        assertFalse(link.isUsado(), "Resultado retornado pelo metodo não foi false");
    }

    @Test
    void testSetUsadoTrue(){
        Link link = new Link(cidade1, cidade2, tamanho);
        link.usado = false;
        link.setUsado(true);
        assertTrue(link.isUsado(),"Resultado retornado pelo metodo não foi true");
    }

    @Test
    void testToString() {
        Link link = new Link(cidade1, cidade2, tamanho);
        assertEquals(stringDesejadaLink, link.toString(), "String desejada difere da recebida");
    }

    @Test
    void testToStringInvertido(){
        Link link = new Link(cidade1, cidade2, tamanho);
        assertNotEquals(stringDesejadaLinkInvertido, link.toString(), "String recebida é igual a desejada");
    }

    //retorna 0 se os links tiverem as mesmas cidade1 e cidade2
    @Test
    void testCompareToCidadesIguais() {
        Link link = new Link(cidade1, cidade2, tamanho);
        Link link2 = new Link(cidade1, cidade2, tamanho);
        assertEquals(0, link.compareTo(link2), "Links informados não tem a mesma cidade");
    }

    //retorna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
    @Test
    void testCompareToCidadesDiferentesNegativo() {
        Link link = new Link(cidade1, cidade2, tamanho);
        Link link2 = new Link(cidade1, cidade1, tamanho);
        System.out.println(link.compareTo(link2));
        assertEquals(-1, link.compareTo(link2),"cidade1 do link não é menor do que a cidade1 do link2");
    }

    //retorna negativo se as cidades um são iguais
    @Test
    void testCompareToCidade1Iguais() {
        Link link = new Link(cidade3, cidade2, tamanho);
        Link link2 = new Link(cidade1, cidade2, tamanho);
        System.out.println(link.compareTo(link2));
        assertEquals(-1, link.compareTo(link2),"Cidades informadas são iguais");
    }

    //retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
    @Test
    void testCompareToCidadesIguaisNegativo(){
        Link link = new Link(cidade1, cidade2, tamanho);
        Link link2 = new Link(cidade3, cidade2, tamanho);
        System.out.println(link.cidade2);
        System.out.println(link2.cidade2);
        assertEquals(-1, link.compareTo(link2),"cidade2 do link não é menor do que a cidade2 do link2");
    }

    //retorna positivo se this.cidade2 > l.cidade2 (Alfabetcamente)
    @Test
    void testCompareToCidadesDiferentesPositivo(){
        Link link = new Link(cidade1, cidade3, tamanho);
        Link link2 = new Link(cidade2, cidade1, tamanho);
        assertEquals(1, link.compareTo(link2), "cidade2 do link é menor do que a cidade2 do link2");
    }

}