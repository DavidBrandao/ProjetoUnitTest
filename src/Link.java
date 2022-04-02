/* Classe que trata da construção de links entre as cidades
 */
public class Link implements Comparable<Link> {
  public Cidade cidade1;
  public Cidade cidade2;
  public int tamanho;
  public boolean usado = false;

  /* Dado que duas cidades sao recebidas
   * o método construtor cria um Link entre a primeira cidade e a segunda cidade com um tamanho específico
   * As cidades são comparadas ALFABETICAMENTE e criadas no link em ordem alfabética
   * o link é criado entre as duas cidades
   * Exemplo de comparação Alfabética entre cidades: Camaragibe>Recife, porque C vem antes de R
   */
  //[Refactor] Alteração das variaveis c1 -> cidade1Link | c2 -> cidade2Link | tam -> tamanhoLink
  public Link(Cidade cidade1Link, Cidade cidade2Link, int tamanhoLink) {
    if (cidade1Link.comparaNome(cidade2Link) < 0) {
      cidade1 = cidade1Link;
      cidade2 = cidade2Link;
    } else {
      cidade1 = cidade2Link;
      cidade2 = cidade1Link;
    }
    tamanho = tamanhoLink;
    cidade1Link.addLink(this);
    cidade2Link.addLink(this);
		usado = true;
  }

  /* retorna o tamanho de um link entre duas cidades */
  //[Bug] Modificado o retorno de (cidade1.distancia) para a variável tamanho
  public int getTamanho() {
    return tamanho;
  }

  /* retorna true se o link entre duas cidades existir */
  public boolean isUsado() {
    return usado;
  }

  /* seta usado como true ou false a depender de o link ser criado ou não */
  //[Refactor] Modificado nome da variável u -> estado
  //[Bug] Atribução do valor para variavel "usado" estava com "false" hardecodes, foi alterado para "estado"
  public void setUsado(boolean estado) {
    usado = estado;
  }

  /* retorna uma string com a descrição de um Link entre cidades.
   * exemplo Link formado por Cidade1, tamanho 3 e Cidade2, retorna "Cidade1 3 Cidade2".
   */
  //[BUG] Ajustando o código para concatenar a variável tamanho, como informado na descrição
  public String toString() {
    return cidade1.toString() + " " + tamanho + " " + cidade2.toString();
  }

  /* Compara dois links para saber o que eles tem em comum
   * retorna 0 se os links tiverem as mesmas cidade1 e cidade2
   * retorna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
   * retorna negativo se cidade1 é igual nos dois links
   * retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
   * retorna positivo caso contrário
   * Exemplo: Link1: Recife 3 Olinda / Link2: Recife 2 Camaragibe
   * Link1.compareTo(Link2) -> Resultado: retorna negativo, porque cidade1 é Recife e é igual nos dois Links
   */
  //[Refactor] foi modificado a variavel l -> link
  //[Bug] Foi Corrigido o segundo termo condicional do else IF, mudando o comparador de AND (&&) para OR (||)
  public int compareTo(Link link) {
    if(cidade1==link.cidade1 && cidade2==link.cidade2)
      return 0;
    else if((cidade1.comparaNome(link.cidade1)<0)  || (cidade1==link.cidade1) || cidade2.comparaNome(link.cidade2)<0)
      return -1;
    else
      return +1;
  }
}
