package testJunit;

import java.io.Serializable;

import org.hamcrest.core.AllOf;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.hamcrest.core.IsSame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import testUnitaire.ClassePrincipaleTest;




/**
 * 
 * @author JF45E37N
 *
 *cette classe pour les tests est destin�e � centraliser le maximum d'outil utilis� dans un test JUnit standard
 */
public class TestClassePrincipale {
	
	/**
	 * cette m�thode va s'ex�cuter AVANT tous les tests de la s�rie
	 */
	@BeforeClass
	public static void testAvantTousLesTestsDeLaClasse(){
		System.out.println("--------**********-------");
        System.out.println(" \"AVANT\" TOUS LES TESTS");
	}
	
	/**
	 * cette m�thode va s'ex�cuter APRES tous les tests de la s�rie
	 */
	@AfterClass
	public static void testApresTousLesTestsDeLaClasse(){
		System.out.println("--------**********-------");
        System.out.println(" \"APRES\" TOUS LES TESTS");
	}
	
	
	/**
	 * Cette m�thode est ex�cut�e avant chaque test
	 */
	@Ignore
	@Before
	public void testAvantTousLesTets(){
		System.out.println("------------------------");
        System.out.println("Avant chaque Test");
	}
	
	@Ignore
	@After
	public void testApresChaqueTest(){
		System.out.println("------------------------");
        System.out.println("Apr�s chaque Test");
	}
	
	/**
	 * @Ignore permet d'ignorer le test
	 */
	@Ignore
	@Test
	public void testPremierTest(){
		System.out.println("le premier test Test");
	}
	
	@Ignore
	@Test
	public void testUnSecondTest(){
		System.out.println("le second test Test");
	}
	
	
	
	/**
	 * Test d'assertion pour les doubles avec un Delta
	 */
	@Test
    public void testValeursExactementEgales() {
        final double lResultat = ClassePrincipaleTest.soustraire(5, 2.5);
        Assert.assertEquals(2.5, lResultat, 0);
    }

    @Test
    public void testValeursAvecUneLegereDifference() {
        final double lResultat = ClassePrincipaleTest.soustraire(71.19, 98);
        Assert.assertEquals(-26.81, lResultat, 0.005);
    }

    @Test
    public void testValeursAvecUneDifferenceTropImportante() {
        final double lResultat = ClassePrincipaleTest.soustraire(1, 2);
        Assert.assertEquals(-1, lResultat, 0);
    }
    
    /**
     * ASSERTION SUR UNE CONDITION DEFINIE PAR CONTRAT
     * Pour que l'assertion soit juste, il faut que le contrat soit v�rifi�.
     */
    
    /**
     * Assertion d�finie par contrat "IsSame"
     * Le contrat v�rifie que l'instance pass�e en premier param�tre de l'assertion 
     * et celle pass�e en param�tre du contrat sont les m�mes.
     */
    @Test
    public void testPareil() {
        // Remarque : c'est la m�me instance � cause du cache
        Assert.assertThat("texte", IsSame.sameInstance("texte"));
    }
    
    @Ignore
    @Test
    public void testPasPareil() {
        // Remarque : ce n'est pas la m�me instance parce que new String() force une nouvelle instance.
        Assert.assertThat(new String("texte"), IsSame.sameInstance("texte"));
    }
    
    
    /**
     * Assertion d�finie par contrat "ISEqual" 
     * Le contrat v�rifie que l'instance pass�e en premier param�tre de 
     * l'assertion et celle pass�e en param�tre du contrat sont �gales.
     */
    @Test
    public void testEgal1() {
    	// Remarque: ici il ya �galit� par utilisation du cache
        Assert.assertThat("texte", IsEqual.equalTo("texte"));
    }

    @Test
    public void testEgal2() {
        Assert.assertThat(new String("texte"), IsEqual.equalTo("texte"));
    }
    
    @Ignore
    @Test
    public void testPasEgal1() {
    	//Remarque : "Texte" est diff�rent de "texte"
        Assert.assertThat("Texte", IsEqual.equalTo("texte"));
    }
    
    @Ignore
    @Test
    public void testPasEgal2() {
    	//Remarque : "Texte" est diff�rent de "texte" et aussi new string() force la cr�ation d'une nouvelle instance
        Assert.assertThat(new String("Texte"), IsEqual.equalTo("texte"));
    }
    
    /**
     * Assertion d�finie par contrat "IsInstanceOf" 
     * Le contrat v�rifie que l'instance pass�e en premier param�tre de 
     * l'assertion est de la classe pass�e en param�tre du contrat.
     */
    @Test
    public void classeDeString() {
        Assert.assertThat("texte", IsInstanceOf.instanceOf(String.class));
    }

    @Test
    public void classeDeSerializable() {
        Assert.assertThat("texte", IsInstanceOf.instanceOf(Serializable.class));
    }

    @Test
    public void classeDeCharSequence() {
        Assert.assertThat("texte", IsInstanceOf.instanceOf(CharSequence.class));
    }
    
    @Ignore
    @Test
    public void classeDeInteger() {
    	//Remarque : "texte" n'est pas un objet de la classe "Integer"
        Assert.assertThat("texte", IsInstanceOf.instanceOf(Integer.class));
    }
    
    
    /**
     * Assertion d�finie par contrat "IsNull" 
     * Le contrat v�rifie que la r�f�rence pass�e en premier param�tre de l'assertion est null ou n'est pas null.
     */
    @Test
    public void testValeurNull1(){
    	final String chaine=null;
    	Assert.assertThat(chaine,IsNull.nullValue());
    }
    
    @Ignore
    @Test
    public void testValeurNull2() {
    	//Remarque : "texte" est diff�rent de "null
        final String chaine = "texte";
        Assert.assertThat(chaine, IsNull.nullValue());
    }
    
    @Ignore
    @Test
    public void testValeurPasNull1() {
    	//Remarque : "null" est bel et bien "null"
        final String chaine = null;
        Assert.assertThat(chaine, IsNull.notNullValue());
    }

    @Test
    public void testValeurPasNull2() {
        final String lTexte = "texte";
        Assert.assertThat(lTexte, IsNull.notNullValue());
    }
    
    
    /**
     * Assertion d�finie par contrat "Is"
     * Le contrat v�rifie que l'instance pass�e en premier param�tre correspond � 
     * ce qui est pass� (classe, valeur, autre contrat) en param�tre du contrat. 
     * Ce contrat n'apporte pas de nouveau type de contrat.
     */
    @Test
    @SuppressWarnings(value = { "deprecation" })
    public void testClasseDeString(){
    	Assert.assertThat("texte", Is.is(String.class));
    }
    
	@Test
    @SuppressWarnings("deprecation")
    public void testClassInteger(){
    	final int entier=12;
    	//Remarque : si on passe une classe, cela correspond � un contrat "classe de l'instance"
    	Assert.assertThat(entier, Is.is(Integer.class));
    }
    
    @Test
    public void testEgal() {
    	//Remarque : si on passe une valeur, cela correspond � un contrat "�galit�"
        Assert.assertThat("texte", Is.is("texte"));
    }
    
    @Ignore
    @Test
    public void testPasEgal() {
    	//Remarque : contrat de type "�galit�" mais  "Texte" est diff�rent de "texte"
        Assert.assertThat("Texte", Is.is("texte"));
    }

    @Test
    public void testPareil2() {
        Assert.assertThat("texte", IsSame.sameInstance("texte"));
    }
    
    @Test
    public void testPareil2Bis() {
        Assert.assertThat("texte", Is.is(IsSame.sameInstance("texte")));
    }
    
    @Ignore
    @Test
    public void testPasPareil2() {
        Assert.assertThat(new String("texte"), Is.is(IsSame.sameInstance("texte")));
    }
    
    
    /**
     * Assertion d�finie par contrat "IsNot"
     * Le contrat v�rifie que l'instance pass�e en premier param�tre ne correspond pas � ce qui 
     * est pass� (valeur ou autre contrat) en param�tre du contrat. Ce contrat n'apporte pas de nouveau type de contrat 
     */
    @Ignore
    @Test
    public void testEgal3() {
    	//Remarque passage par valeur (test qui �choue comme attendu)
        Assert.assertThat("texte", IsNot.not("texte"));
    }
    
    @Ignore
    @Test
    public void testPasEgal3() {
        Assert.assertThat("Texte", IsNot.not("texte"));
    }
    
    @Ignore
    @Test
    public void testPareil3() {
    	// Remarque : passage par contrat en param�tre du contrat
        Assert.assertThat("texte", IsNot.not(IsSame.sameInstance("texte")));
    }

    @Test
    public void testPasPareil3() {
        Assert.assertThat(new String("texte"), IsNot.not(IsSame.sameInstance("texte")));
    }
    
    /**
     * Assertion d�finie avec le contrat "AllOf" 
     * Le contrat v�rifie que TOUS les contrats pass�s en param�tre du contrat sont respect�s.
     */
    @Test
    public void testClasseDeStringEtEgal(){
    	//Remarque : On v�rifie que "texte" est un objet de la classe "String" et vaut "texte"
    	Assert.assertThat("texte", AllOf.allOf(IsInstanceOf.instanceOf(String.class),IsEqual.equalTo("texte")));
    }
    
    @Test
    public void testClasseIntegerEtEgal(){
    	final int entier=1;
    	Assert.assertThat(entier, AllOf.allOf(IsInstanceOf.instanceOf(Integer.class),IsEqual.equalTo(1)));
    }
    
    @Ignore
    @Test
    public void testClasseDeStringEtPasEgal() {
    	// Remarque : le premier contrat r�ussit (objet de "String") "Texte" est diff�rent de "texte" (le test �choue comme pr�vue�)
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("Texte")
        ));
    }

    @Test
    public void tetClasseDePasIntegerEtEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsNot.not(IsInstanceOf.instanceOf(Integer.class)), IsEqual.equalTo("texte")
        ));
    }

    @Test
    public void testClasseDeStringEtPasPasEgal() {
        Assert.assertThat("texte", AllOf.allOf(
                IsInstanceOf.instanceOf(String.class), IsNot.not(IsEqual.equalTo("Texte"))
        ));
    }
    
    /**
     * Assertion d�finie avec le contrat "AllOf" 
     * Le contrat v�rifie que AU MOINS UN des contrats pass�s en param�tre du contrat sont respect�s.
     */
    @SuppressWarnings("unchecked")
	@Test
    public void testClasseDeStringEtEgal2() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("texte")));
    }

    @SuppressWarnings("unchecked")
	@Test
    public void testClasseDeIntegerEtEgal() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(Integer.class), IsEqual.equalTo("texte")
        ));
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void testClasseDeStringEtPasEgal2() {
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(String.class), IsEqual.equalTo("Texte")
        ));
    }
    
    @Ignore
    @SuppressWarnings("unchecked")
    @Test
    public void testClasseDeIntegerEtPasEgal() {
    	// Remarque : ce test �choue comme pr�vue car "texte" n'est ni "Integer" ni �gale � "Texte"
        Assert.assertThat("texte", AnyOf.anyOf(
                IsInstanceOf.instanceOf(Integer.class), IsEqual.equalTo("Texte")
        ));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
