import java.util.Comparator;

/* Compare two cidades for use in sorting or data structures
 */ 
public class ComparadorCidade implements Comparator<Cidade> {
  /* compara duas cidades pela sua distancia até um ponto específico
   * returna negativo se c1 for mais próxima do ponto, 0 se a distancia for a mesma, e positivo se c2 for mais próxima do ponto
   * Por exemplo:
   * - Ponto específico: Praia de Boa Viagem
   * - c1= Recife
   * - c2 = Maceió
   * - return negativo (-1), pois Recife é mais próxima do ponto de referencia: Boa Viagem.
   */
  //[Refactor] Alteração de variaveis x -> cidade1 | y -> cidade2
  //[BUG] Metodo utilizava X e X como parametros, foi trocado para X e Y (cidade1, cidade2)
  public int compare(Cidade cidade1, Cidade cidade2) {
    return cidade1.comparaDistancia(cidade1,cidade2);
  }
}
