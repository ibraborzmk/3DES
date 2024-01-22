
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DES {
    // Constantes
    private static final int TAILLE_BLOC = 64;
    private static final int TAILLE_SOUS_BLOC = 32;
    static final int NB_RONDE = 16;
 


    private static final int[] tab_decalage = {
            1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
    };
    private static final int[] PC1 = {
            57, 49, 41, 33, 25, 17, 9,
            1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29,
            21, 13, 5, 28, 20, 12, 4
        };

        private static final int[] PC2 = {
            14, 17, 11, 24, 1, 5,
            3, 28, 15, 6, 21, 10,
            23, 19, 12, 4, 26, 8,
            16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55,
            30, 40, 51, 45, 33, 48,
            44, 49, 39, 56, 34, 53,
            46, 42, 50, 36, 29, 32
        };

    public static final int[] perm_initiale = {
            58, 50, 42, 34, 26, 18, 10, 2,
            60, 52, 44, 36, 28, 20, 12, 4,
            62, 54, 46, 38, 30, 22, 14, 6,
            64, 56, 48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17, 9, 1,
            59, 51, 43, 35, 27, 19, 11, 3,
            61, 53, 45, 37, 29, 21, 13, 5,
            63, 55, 47, 39, 31, 23, 15, 7
    };
    
    private static final int[][][] S = {
            {
                    // Table S1
                    {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
                    {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
                    {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
                    {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
            },
            {
                    // Table S2
                    {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
                    {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
                    {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
                    {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
            },
            {
                    // Table S3
                    {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
                    {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
                    {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
                    {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
            },
            {
                    // Table S4
                    {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
                    {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
                    {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
                    {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}
            },
            {
                    // Table S5
                    {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
                    {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
                    {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
                    {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
            },
            {
                    // Table S6
                    {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
                    {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
                    {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
                    {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
            },
            {
                    // Table S7
                    {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
                    {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
                    {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
                    {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
            },
            
            	{
            	    // Table S8
            	    {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
            	    {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
            	    {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
            	    {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
            	}

            
    };
    private static final int[] E = {
            32, 1, 2, 3, 4, 5,
            4, 5, 6, 7, 8, 9,
            8, 9, 10, 11, 12, 13,
            12, 13, 14, 15, 16, 17,
            16, 17, 18, 19, 20, 21,
            20, 21, 22, 23, 24, 25,
            24, 25, 26, 27, 28, 29,
            28, 29, 30, 31, 32, 1
    };
    // Attributs
    public static Random random = new Random();
    private static int[] masterKey = new int[64];
    int[][] tab_cles = new int[NB_RONDE][];
    
    

    // Constructeur
    public DES() {


        // Initialisation de la masterKey
        masterKey = generateMasterKey();

        // Initialisation du tableau des clés
        for (int i = 0; i < NB_RONDE; i++) {
            tab_cles[i] = new int[48];
        }
        
   
    }
    
    
	public int[] crypto(String message) {
        // Conversion du message en tableau de bits
        int[] messageEnBits = stringToBits(message);

        // Découpage du message en blocs de 64 bits
        int[][] blocs = decoupage(messageEnBits, TAILLE_BLOC);

        // Initialisation du tableau de blocs cryptés
        for (int i = 0; i < blocs.length; i++) {
            // 1) Permutation initiale
            blocs[i] = permutation(perm_initiale, blocs[i]);
            // 2) Découpage en deux sous-blocs de 32 bits
            int[][] GD = decoupage(blocs[i], TAILLE_SOUS_BLOC);
            int[] G = GD[0];
            int[] D = GD[1];
            // 3) Rondes n : (NB_RONDE rondes, en utilisant les clés dans l'ordre)
            for (int j = 0; j < NB_RONDE; j++) {
                // 3.1) Calcul de la clé Kj
            	génèreClé(j);
                int[] D2 = D;
                // 3.2) Calcul de D = G xor F(D,Kj)
                D = xor(G, fonction_F(D,j));
                //
                G = D2;
            }

            // 4) Recollage en un bloc de 64 bits
            int[][] re = { G, D };
            int[] recollage = recollage_bloc(re);

            // 5) Permutation inverse
            blocs[i] = invPermutation(perm_initiale, recollage);
        }

        // Recollage final en un seul bloc
        int[] fin = recollage_bloc(blocs);
        return fin;
    }


    public String decrypto(int[] messageCrypte) {
		// Découpage du message en blocs de 64 bits
		int[][] dec1 = decoupage(messageCrypte,TAILLE_BLOC);
		// Initialisation du tableau de blocs cryptés
		for (int i=0;i<dec1.length;i++) {
			// 1) La permutation initiale
			dec1[i] = permutation(perm_initiale, dec1[i]);
			//2) découpage en 2 blocs de 32 : Gn et Dn
			int[][] GD= decoupage(dec1[i],TAILLE_SOUS_BLOC);
			int[] G = GD[0];
			int[] D = GD[1];
			//3) rondes j : (NB_RONDES rondes, en utilisant les clés dans l'ordre)
			for (int j=NB_RONDE-1;j>=0;j--) {
				int[] G2 = G;
				G = xor(D,fonction_F(G,j));
				D = G2;
			}
			//4) recollage → bloc de 64 bits
			int[][] re = {G,D};
			int[] rec = recollage_bloc(re);
			//5) permutation inverse
			dec1[i] = invPermutation(perm_initiale, rec);
		}
        // Recollage final en un seul bloc et conversion en String
		String fin = bitsToString(recollage_bloc(dec1));
		return fin;
	}

    
    public int[] stringToBits(String message) {
        // Vérifiez si la chaîne de caractères est vide ou nulle
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("La chaîne de caractères ne peut pas être vide.");
        }

        // Calculez la taille de la chaîne de caractères en bits
        int totalBits = message.length() * 8;
        // Créez un tableau d'entiers de la taille de la chaîne de caractères en bits
        int[] bits = new int[totalBits];
        // Initialisez l'index du bit
        int bitIndex = 0;
        // Parcourez la chaîne de caractères
        for (int i = 0; i < message.length(); i++) {
            // Récupérez le caractère à l'index i
            char c = message.charAt(i);
            // Parcourez les 8 bits du caractère
            for (int j = 7; j >= 0; j--) {
                // Récupérez le j-ième bit du caractère
                int bit = (c >> j) & 1;
                // Ajoutez le bit au tableau d'entiers
                bits[bitIndex] = bit;
                // Incrémentez l'index du bit
                bitIndex++;
            }
        }



        return bits;
    }


    
    public String bitsToString(int[] bits) {
        // Vérifiez si le tableau bits est vide ou nul
        if (bits == null || bits.length == 0) {
            throw new IllegalArgumentException("Le tableau bits ne peut pas être vide ou nul.");
        }

        // Calculez la taille du tableau d'entiers en bits
        int totalBits = bits.length;

        // Vérifiez que le tableau contient un nombre d'entiers multiple de 8 pour représenter des caractères
        if (totalBits % 8 != 0) {
            throw new IllegalArgumentException("Le tableau bits doit avoir une longueur multiple de 8 pour représenter des caractères.");
        }

        // initialisez le nombre de caractères
        int totalChars = 0;
        // Parcourez le tableau d'entiers en groupes de 8 pour compter le nombre de caractères
        for (int i = 0; i < totalBits; i += 8) {
            // Initialisez un indicateur pour savoir si tous les bits du groupe sont à 0
            boolean isAllZeros = true;
            // Parcourez les 8 bits du groupe
            for (int j = 0; j < 8; j++) {
                // Si un bit est à 1, l'indicateur est mis à faux et on sort de la boucle
                if (bits[i + j] != 0) {
                    // Le bit est à 1, l'indicateur est mis à faux
                    isAllZeros = false;
                    // On sort de la boucle
                    break;
                }
            }
            // Si tous les bits du groupe sont à 0, on ne compte pas de caractère
            if (!isAllZeros) {
                // On compte un caractère
                totalChars++;
            }
        }

        // Créez un tableau de caractères pour stocker les caractères convertis
        char[] chars = new char[totalChars];
        // Initialisez l'index du caractère
        int charIndex = 0;

        // Parcourez le tableau d'entiers en groupes de 8 pour les convertir en caractères
        for (int i = 0; i < totalBits; i += 8) {
            // Initialisez un indicateur pour savoir si tous les bits du groupe sont à 0
            boolean isAllZeros = true;
            // Initialisez la valeur du caractère
            int charValue = 0;
            // Parcourez les 8 bits du groupe
            for (int j = 0; j < 8; j++) {
                // Si un bit est à 1, l'indicateur est mis à faux
                if (bits[i + j] != 0) {
                    // Le bit est à 1, l'indicateur est mis à faux
                    isAllZeros = false;
                }
                // Décalez la valeur du caractère de 1 bit vers la gauche et ajoutez le bit
                charValue = (charValue << 1) | bits[i + j];
            }
            // Si tous les bits du groupe sont à 0, on ne convertit pas le groupe en caractère
            if (!isAllZeros) {
                // Convertissez la valeur du caractère en caractère et ajoutez-le au tableau de caractères
                chars[charIndex] = (char) charValue;
                // Incrémentez l'index du caractère
                charIndex++;
            }
        }

        // Retournez la chaîne de caractères
        return new String(chars);
    }



    


    public int[] generateMasterKey() {
        // Créez un tableau d'entiers de 64 bits
        int[] key = new int[64];
        // Générez 64 bits aléatoires
        for (int i = 0; i < 64; i++) {
            // Générez un bit aléatoire
            int valeurAlea = random.nextInt(2);
            // Ajoutez le bit au tableau d'entiers
            key[i] = valeurAlea;
        }
        return key;
    }
   
    public int[] permutation(int[] tab_permutation, int[] bloc) {
        // Assurez-vous que la taille du bloc correspond à la taille de la permutation
        if (bloc.length != tab_permutation.length) {
            throw new IllegalArgumentException("La taille du bloc doit correspondre à la taille de la permutation.");
        }

        // Créez un tableau d'entiers de la taille du bloc
        int[] blocPermute = new int[bloc.length];

        // Appliquez la permutation en réorganisant les bits du bloc
        for (int i = 0; i < tab_permutation.length; i++) {
            // Ajoutez le bit au tableau d'entiers
            blocPermute[i] = bloc[tab_permutation[i] - 1]; // -1 car les indices commencent à 1 dans tab_permutation
        }
        return blocPermute;
    }
    public int[] invPermutation(int[] tab_permutation, int[] bloc) {
        // Assurez-vous que la taille du bloc correspond à la taille de la permutation
        if (bloc.length != tab_permutation.length) {
            throw new IllegalArgumentException("La taille du bloc doit correspondre à la taille de la permutation.");
        }

        // Créez un tableau d'entiers de la taille du bloc
        int[] blocInversePermute = new int[bloc.length];

        // Appliquez la permutation inverse en réorganisant les bits du bloc
        for (int i = 0; i < tab_permutation.length; i++) {
            // Ajoutez le bit au tableau d'entiers
            blocInversePermute[tab_permutation[i] - 1] = bloc[i]; // -1 car les indices commencent à 1 dans tab_permutation
        }
        return blocInversePermute;
    }
    public int[][] decoupage(int[] bloc, int tailleBlocs) {

        // Calculez le nombre de sous-blocs
        int nombreDeBlocs = bloc.length / tailleBlocs + (bloc.length % tailleBlocs == 0 ? 0 : 1);

        // Créez un tableau d'entiers pour stocker les sous-blocs
        int[][] blocsDecoupes = new int[nombreDeBlocs][tailleBlocs];


        // Découpez le bloc en sous-blocs de la taille spécifiée
        for (int i = 0; i < nombreDeBlocs; i++) {
            // Calculez la longueur effective du sous-bloc
            int longueurEffective = Math.min(tailleBlocs, bloc.length - i * tailleBlocs);
            // Parcourez le sous-bloc
            for (int j = 0; j < tailleBlocs; j++) {
                // Si l'indice est inférieur à la longueur effective, ajoutez le bit au sous-bloc
                if (j < longueurEffective) {
                    // Ajoutez le bit au sous-bloc
                    blocsDecoupes[i][j] = bloc[i * tailleBlocs + j];
                } else {
                    // Remplissez avec des zéros si la longueur est inférieure à tailleBlocs
                    blocsDecoupes[i][j] = 0;
                }
            }
        }
        return blocsDecoupes;
    }
    
    public int[] recollage_bloc(int[][] blocs) {
        //On calcule le nombre de blocs
        int nombreDeBlocs = blocs.length;
        //On calcule la taille des blocs
        int tailleBlocs = blocs[0].length;

        // Vérifiez que tous les blocs ont la même taille
        for (int i = 1; i < nombreDeBlocs; i++) {
            if (blocs[i].length != tailleBlocs) {
                throw new IllegalArgumentException("Tous les blocs doivent avoir la même taille.");
            }
        }
        // Créez un tableau d'entiers pour stocker le bloc recollé
        int[] blocRecolle = new int[nombreDeBlocs * tailleBlocs];

        // Recoller tous les blocs en un seul tableau
        for (int i = 0; i < nombreDeBlocs; i++) {
            // Parcourez le bloc
            for (int j = 0; j < tailleBlocs; j++) {
                // Ajoutez le bit au bloc recollé
                blocRecolle[i * tailleBlocs + j] = blocs[i][j];
            }
        }

        return blocRecolle;
       
    }


    
    public int[] génèreClé(int n) {
        if (n < 0 || n > NB_RONDE) {
            throw new IllegalArgumentException("La ronde doit être entre 1 et 16.");
        }
        // Créez un tableau d'entiers pour stocker la clé de ronde
        int[] cléDeRonde = new int[48];
        // Créez un tableau d'entiers pour stocker la clé
        int[] keyPermuted = new int[56];
        // Permutation de choix PC1 pour obtenir la clé de 56 bits
        for (int i = 0; i < 56; i++) {
            // Ajoutez le bit au tableau d'entiers
            keyPermuted[i] = masterKey[PC1[i] - 1];
        }

        // Diviser la clé en deux parties gauche et droite
        int[][] keys = decoupage(keyPermuted,28);

        // Effectuer les décalages circulaires en fonction de la ronde
        for (int k=0 ; k<n ; k++) {
        	keys[0]=decalle_gauche(keys[0],tab_decalage[n]);
        	keys[1]=decalle_gauche(keys[1],tab_decalage[n]);
        }

        // Combiner les parties gauche et droite
        int[] key = recollage_bloc(keys);

        // Permutation de choix PC2 pour obtenir la clé de ronde
        for (int i = 0; i < 48; i++) {
            // Ajoutez le bit au tableau d'entiers
            cléDeRonde[i] = key[PC2[i] - 1];
        }
        

        // Stocker la clé de ronde dans tab_cles
        tab_cles[n] = cléDeRonde;

        return cléDeRonde;
    }

    int[] decalle_gauche(int[] bloc, int nbCran) {
        // Créez un tableau d'entiers pour stocker le bloc décalé
        int[] tableauDecale = new int[bloc.length];
        // Parcourez le bloc
        for (int i = 0; i < bloc.length; i++) {
            // Calculez le nouvel indice
            int nouvelIndex = (i + nbCran) % bloc.length;
            // Ajoutez le bit au tableau d'entiers
            tableauDecale[i] = bloc[nouvelIndex];
        }

        return tableauDecale;
    }


    public static int[] xor(int[] tab1, int[] tab2) {
            // Calculez la longueur maximale entre les deux tableaux
            int maxLength = Math.max(tab1.length, tab2.length);
            // Créez un tableau d'entiers pour stocker le résultat
            int[] resultatXor = new int[maxLength];
            // Parcourez les deux tableaux
            for (int i = 0; i < maxLength; i++) {
                // Obtenez la valeur de chaque tableau, ou 0 si l'indice est supérieur à la longueur du tableau
                int value1 = i < tab1.length ? tab1[i] : 0;
                int value2 = i < tab2.length ? tab2[i] : 0;
                // Effectuez l'opération XOR
                resultatXor[i] = value1 ^ value2;
            }

            return resultatXor;
        }
    
    	public static int[] fonction_S(int[] tab) {
            // Créez un tableau d'entiers pour stocker le résultat
            int[] resultatS = new int[4];

            // Déterminez la ligne et la colonne pour le bloc de 6 bits
            int ligne = (tab[0] << 1) | tab[5];
            int colonne = (tab[1] << 3) | (tab[2] << 2) | (tab[3] << 1) | tab[4];

            // Obtenez la valeur de substitution à partir de la table S appropriée
            int valeurS = S[0][ligne][colonne]; // Utilisation de la première table S, changez si nécessaire

            // Convertissez la valeur de substitution en binaire (4 bits)
            for (int j = 3; j >= 0; j--) {
                resultatS[j] = (valeurS >> j) & 1;
            }


            return resultatS;
        }
    public int[] fonction_F(int[] unD, int cle ){
    	//Tableau de permutation P
    	int[] P = {16, 7, 20, 21, 29, 12, 28, 17,
                1, 15, 23, 26, 5, 18, 31, 10,
                2, 8, 24, 14, 32, 27, 3, 9,
                19, 13, 30, 6, 22, 11, 4, 25};
    	// Permutation de choix E pour obtenir Dn
    	 int[] Dn_2 = new int[48];
         for (int i = 0; i < 48; i++) {
             Dn_2[i] = unD[E[i] - 1];
         }
        // Faire un XOR entre Dn et la clé Kn pour obtenir D∗n
        int[] Detoile = xor(Dn_2, tab_cles[cle]); // L'indice 0 doit être mis à jour en fonction de la clé actuelle

        // Découper D∗n en 8 blocs de 6 bits
        int[][] blocs6bits = decoupage(Detoile, 6);
        

        // Appliquer la fonction de substitution S à chaque bloc de 6 bits
        int[] resultatS = new int[32];
        int index = 0;
        int[][] resultatBlocS = new int [8][6] ; 
        for (int[] bloc : blocs6bits) {
            resultatBlocS[index]=fonction_S(bloc);
            index ++;
        }
        // Recoller les blocs de 4 bits
        resultatS= recollage_bloc(resultatBlocS);
        // Permutation de choix P pour obtenir le résultat de la fonction F
        resultatS = permutation(P, resultatS);

        return resultatS;
    }




    public static void main(String[] arg) {


    }


    public static class InterfaceTriple {

        public static void main(String[] args) {
            JFrame frame = new JFrame("Interface avec images en fond");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new GridLayout(1, 2));

            // Ajouter l'image de fond pour le panneau de gauche
            ImageIcon image1 = new ImageIcon("chemin/vers/image1.jpg");
            JLabel label1 = new JLabel("", image1, JLabel.CENTER);
            JPanel panel1 = new JPanel(new BorderLayout());
            panel1.add(label1, BorderLayout.CENTER);
            JButton button1 = new JButton("Bouton 1");
            panel1.add(button1, BorderLayout.SOUTH);

            // Ajouter l'image de fond pour le panneau de droite
            ImageIcon image2 = new ImageIcon("chemin/vers/image2.jpg");
            JLabel label2 = new JLabel("", image2, JLabel.CENTER);
            JPanel panel2 = new JPanel(new BorderLayout());
            panel2.add(label2, BorderLayout.CENTER);
            JButton button2 = new JButton("Bouton 2");
            panel2.add(button2, BorderLayout.SOUTH);

            // Ajouter les panneaux à la frame
            frame.add(panel1);
            frame.add(panel2);
            frame.setVisible(true);
        }
    }
}
