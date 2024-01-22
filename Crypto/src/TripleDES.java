package Crypto.src;

public class TripleDES {

    private static DES des;

    public TripleDES() {
        des = new DES();
    }

    public static int[] chiffrement(String message) {
        int[] texteChiffre;
        // Premier tour de chiffrement
        texteChiffre = des.crypto(message);

        // Deuxième tour de chiffrement
        texteChiffre = des.crypto(des.bitsToString(texteChiffre));

        // Troisième tour de chiffrement
        texteChiffre = des.crypto(des.bitsToString(texteChiffre));

        return texteChiffre;
    }

    public static String dechiffrement(int[] texteChiffre) {
        String texteClair;
        // Premier tour de déchiffrement
        texteClair = des.decrypto(texteChiffre);

        // Deuxième tour de déchiffrement
        texteClair = des.decrypto(des.stringToBits(texteClair));

        // Troisième tour de déchiffrement
        texteClair = des.decrypto(des.stringToBits(texteClair));

        return texteClair;
    }

    public static void main(String[] args) {

    }
}
