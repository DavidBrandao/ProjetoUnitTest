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
  public int compare(Cidade x, Cidade y) {
    return x.comparaDistancia(x,x);
  }
}
