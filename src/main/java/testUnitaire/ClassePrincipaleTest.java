package testUnitaire;

/**
 *
 * @author JF45E37N
 *
 *Cette classe est faite pour centraliser les diff�rentes m�thodes qui vont �tre test�es
 *dans la classe principale des test "TestClassePrincipale"
 */
public class ClassePrincipaleTest {
	
	/**
	 * Asserttion avec le Delta(intervalle o� doit se trouver le r�sultat pour �tre consid�r� comme bon)
	 */
	public static double soustraire(final double...pNombres) {
        if(pNombres.length < 2) {
            throw new IllegalArgumentException(
                    "Il faut au moins deux nombres en entr�e");
        }
        double lRetour = pNombres[0];
        for(int i=1;i<pNombres.length;i++) {
            lRetour -= pNombres[i];
        }
        return lRetour;
    }
    
	
}
