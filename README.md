```markdown
# String to Binary Array

The provided code converts a string into an array of integers representing the bits of each character. It also handles special characters and uppercase letters using bitwise operations. The bit shift operation (`>>`) is used to extract the bits of a character, while the logical operation `&` extracts the rightmost bit. Thus, each character is represented by a specific sequence of bits in the final integer array. This method facilitates the storage and manipulation of characters as bit sequences, thereby simplifying subsequent operations on the data.

## Tests Performed:

- `testBitsString()`: This test verifies if the conversion of a string into bits, followed by its reconversion into a string, yields the same original string. This ensures that the conversion methods between strings and bits work correctly.
- `testDecoupage()`: This test verifies if the "decoupage" function correctly separates an array of integers into blocks of the specified size. It then compares the obtained result with an expected 2D array of integers to verify the accuracy of the segmentation.
- `testRecollage_bloc()`: This test verifies if the "recollage_bloc" function can correctly reconstruct a single array from a 2D array of blocks, ensuring that the reassembled array exactly matches the expected integer array.
- `testPermutation()`: This test verifies if the "permutation" function performs a permutation on an array of integers according to the specified rules. It compares the result of the permutation with an expected array of integers to ensure the accuracy of the permutation function.
- `testPermutationInv()`: This test verifies if the "invPermutation" function performs an inverse permutation on an array of integers as expected. It compares the result of the inverse permutation with an expected array of integers to ensure the accuracy of the invPermutation function.
- `testDecalageAGauche()`: This test verifies if the "decalle_gauche" function correctly shifts an array of integers to the left by a specified number of positions. It compares the result of the shift with an expected array of integers to ensure that the left shift occurs as expected.
- `testXor()`: This test verifies if the "xor" function correctly performs the XOR (exclusive OR) operation between two arrays of integers. It compares the result of the XOR operation with an expected array of integers to ensure that the XOR operation occurs as expected.
- `testFonctionS()`: This test verifies if the "fonction_S" function correctly applies bit substitution according to the specified rules for the DES algorithm. It compares the substitution result with an expected array of integers to ensure the accuracy of the substitution function.
- `testCrypteDecrypte()`: This test encrypts a message using the DES algorithm, then attempts to decrypt it to verify if the final result matches the original message. This ensures that the encryption and decryption functions of the DES algorithm work correctly and are reversible.

My DES can perform all 16 Rounds.

## Modifications:

- I have added the P table in the function function_F to perform the requested permutations.

## Triple DES:

My TripleDES class uses these 2 methods for 3DES:

### Encryption:

The `chiffrement` method takes an input string message. It first performs a encryption round by calling the `crypto` method of the DES object with the given message as an argument. Then, it encrypts the result again using the `bitsToString` and `crypto` methods of the DES object. Finally, it encrypts the result a third time using again the `bitsToString` and `crypto` methods of the DES object. The method returns the encrypted text as an array of integers.

### Decryption:

The `dechiffrement` method takes an input array of integers `texteChiffre`. It begins by decrypting the encrypted text once by calling the `decrypto` method of the DES object with the encrypted text as an argument. Then, it decrypts the result a second time using the `stringToBits` and `decrypto` methods of the DES object. Finally, it decrypts the result a third time using again the `stringToBits` and `decrypto` methods of the DES object. The method returns the decrypted text as a string.

## Graphical User Interface:

- Launch the `Main` Class.
- Start on a welcome interface where you have the choice between DES and 3DES encryption by pressing one of the buttons, then proceed to another interface divided into 2 with 2 text areas and 2 buttons.
  - Encrypt: Enter the message to encode in the left text area and press the encrypt button; the encrypted result will appear on the right.
  - Decrypt: Enter the encrypted data in the right text area and press the decrypt button; the decrypted message will appear.
```
