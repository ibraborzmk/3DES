package Crypto.src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleDESTest {

    @Test
    public void testChiffrementDechiffrement() {
        TripleDES tripleDES = new TripleDES();
        String messageOriginal = "Hello World!";

        int[] chiffre = tripleDES.chiffrement(messageOriginal);
        String dechiffre = tripleDES.dechiffrement(chiffre);
        System.out.println(messageOriginal);
        System.out.print(dechiffre);
        assertEquals(messageOriginal, dechiffre);

    }
}
