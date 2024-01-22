
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class DESTest {
    private DES des;


    @BeforeEach
    public void setUp() {
        des = new DES();
        
    }

    @Test
    public void testBitsString() {
     
        String message = "Test message";
        int[] test = des.stringToBits(message) ;
        String test2 = des.bitsToString(test);
        assertEquals(message,test2);
    }

    @Test
    public void testDecoupage() {
        int[] bloc = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tailleBlocs = 3;
        int[][] expectedResult = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = des.decoupage(bloc, tailleBlocs);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testRecollage_bloc() {
        int[][] blocs = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = des.recollage_bloc(blocs);
        assertArrayEquals(expectedResult, result);
    }
   //fait tout les teste
    @Test
    public void testPermutation() {
        int[] bloc = {1, 2, 3, 4, 5, 6};
        int[] expectedResult = {4, 5, 6, 1, 2, 3};
        int[] blocPermtation ={4,5,6,1,2,3};
        int[] result = des.permutation(blocPermtation,bloc);
    assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testPermutationInv() {
        int[] bloc = {1, 2, 3, 4, 5, 6};
        int[] blocPermtation = {4, 1, 5, 2, 6, 3};
        int[] expectedResult = {2, 4, 6, 1, 3, 5};
        int[] result = des.invPermutation(blocPermtation, bloc);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testDecalageAGauche() {
        int[] bloc = {1, 2, 3, 4, 5};
        int nbCran = 2;
        int[] expectedResult = {3, 4, 5, 1, 2};
        int[] result = des.decalle_gauche(bloc, nbCran);
        assertArrayEquals(expectedResult, result);
    }
    @Test
    public void testXor() {
        int[] tab1 = {1, 0, 1, 0, 1};
        int[] tab2 = {0, 1, 0, 1, 0};
        int[] expectedResult = {1, 1, 1, 1, 1};
        int[] result = des.xor(tab1, tab2);
        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testFonctionS() {
        int[] tab = {1, 0, 1, 0, 1, 0};
        int[] expectedResult = {0, 1, 1, 0};
        int[] result = des.fonction_S(tab);
        assertArrayEquals(expectedResult, result);
    }
    @Test
    public void testCrypteDecrypte() {
    	String message_clair = "Test message";
        int[] message = des.crypto(message_clair);
        String blocFinal = des.decrypto(message);
        System.out.println(message_clair);
        System.out.println(blocFinal);
        assertEquals(message_clair, blocFinal);
    }
    
    
    

    
    }
    
    






   



