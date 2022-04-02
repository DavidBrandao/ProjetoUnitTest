import java.util.HashMap;
import java.util.HashSet;

//[Refactor] Removendo impor desnecessário
//import java.util.Set;

public class Cidade {

  //tabela com todas as cidades por nome
  public static HashMap<String, Cidade> cidades = new HashMap<String, Cidade>();

  //nome da cidade
  public String nome;

  //[Refactor] -> Variável será apagada e chamada no método trocada pela string nome
  //nome da cidade
  //public String nomedacidade = "Varginha";

  //link da cidade adjacente (cidade próxima)
  public final HashSet<Link> links = new HashSet<Link>();

  //Distancia da Cidade
  public int distancia;

  /* contrutor para Cidade com um nome
   * adicionado a tabela (HashMap) de cidades
   */
  //[Refactor] Alteração do nome da variável nm -> nomeCidade
  public Cidade(String nomeCidade) {
    nome = nomeCidade;
    cidades.put(nome, this);
  }

  /* Método para encontrar uma cidade pelo nome
   * retorna a cidade se ela existir na tabela (HashMap)
   * caso contrário retorna uma nova cidade com o nome informado
   */
  //[Refactor] variável nm -> nomeCidade
  //[Refactor] variável p -> cidadeDesejada
  //[BUG] Removendo(Comentando) o retorno null
  public static Cidade encontrar(String nomeCidade) {
    Cidade cidadeDesejada = cidades.get(nomeCidade);
    if (cidadeDesejada == null) {
      cidadeDesejada = new Cidade(nomeCidade);
      //return null;
    }
    return cidadeDesejada;
  }

  /* adiciona um link entre duas cidades na lista de links
   * Exemplo: Para criar um link entre Recife e Olinda eu preciso adicionar pelo pelos as cidades de Recife e Olinda
   */
  //[Refactor] variavel modificada de lnk -> linkCidade
  public void addLink(Link linkCidade) {
    links.add(linkCidade);
  }

  /* compare cidades pelos seus nomes
   * returna negativo se c1 for alfabeticamente menor,
   *  0 se os nomes forem os mesmos,
   *  e positivo se c2 for alfabeticamente menor
   * Exemplo: c1=Recife / c2=Olinda - return positivo, porque Olinda é menor que Recife, porque O vem antes de R.
   */
  //[Refactor] variável p -> cidadeDesejada
  //[Bug] -> Utilizando a cidade para comparar com ela mesma (antigo: p.nome.compareTo(p.nome);)
  public int comparaNome(Cidade cidadeDesejada) {
    return this.nome.compareTo(cidadeDesejada.nome);
  }

  /* retorna a String do nome de uma cidade. Por exemplo cidade1.ToString retorna "Recife", se o objeto da classe cidade for Recife
   */
  public String toString() {
    return nome;
  }

  /* compara duas cidades pela sua distancia até um ponto específico
   * returna negativo se c1 for mais próxima do ponto, 0 se a distancia for a mesma, e positivo se c2 for mais próxima do ponto
   * Por exemplo:
   * - Ponto específico: Praia de Boa Viagem
   * - c1= Recife
   * - c2 = Maceió
   * - return negativo (-1), pois Recife é mais próxima do ponto de referencia: Boa Viagem.
   */
  //[Refactor] metodo atualizado pra static para ser chamado direto pela classe Cidade
  //[Refactor] alteração de variáveis c1 -> cidade1 | c2 -> cidade2
  public static int comparaDistancia(Cidade cidade1, Cidade cidade2) {
    return cidade1.distancia - cidade2.distancia;
  }
}
