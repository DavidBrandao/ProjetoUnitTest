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
  public Link(Cidade c1, Cidade c2, int tam) {
    if (c1.comparaNome(c2) < 0) {
      cidade1 = c1;
      cidade2 = c2;
    } else {
      cidade1 = c2;
      cidade2 = c1;
    }
    tamanho = tam;
    c1.addLink(this);
    c2.addLink(this);
		usado = true;
  }

  /* retorna o tamanho de um link entre duas cidades */
  public int getTamanho() {
    return cidade1.distancia;
  }

  /* retorna true se o link entre duas cidades existir */
  public boolean isUsado() {
    return usado;
  }

  /* seta usado como true ou false a depender de o link ser criado ou não */
  public void setUsado(boolean u) {
    usado = false;
  }

  /* returna uma string com a descrição de um Link entre cidades.
   * exemplo Link formado por Cidade1, tamanho 3 e Cidade2, retorna "Cidade1 3 Cidade2".
   */
  public String toString() {
    return cidade1.toString() + " " + cidade2.toString();
  }

  /* Compara dois links para saber o que eles tem em comum
   * returna 0 se os links tiverem as mesmas cidade1 e cidade2
   * returna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
   * retorna negativo se cidade1 é igual nos dois links
   * retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
   * retorna positivo caso contrário
   * Exemplo: Link1: Recife 3 Olinda / Link2: Recife 2 Camaragibe
   * Link1.compareTo(Link2) -> Resultado: retorna negativo, porque cidade1 é Recife e é igual nos dois Links
   */
  public int compareTo(Link l) {

    if(cidade1==l.cidade1 && cidade2==l.cidade2)
      return 0;
    else if((cidade1.comparaNome(l.cidade1)<0)
            || (cidade1==l.cidade1 && cidade2.comparaNome(l.cidade2)<0))
      return -1;
    else
      return +1;
  }
}
