package com.services;

import com.сonstants.Constants;

public class Decryption {
    private Decryption() {
    }

    /**
     *
     * @param inputStr - Входящая строка для расшифровки
     * @param shiftKey - Ключ для расшифровки
     * @return - Возвращаемая расшифрованная строка
     */
    public static String decryptData(String inputStr, int shiftKey)
    {
        inputStr = inputStr.toLowerCase();
        StringBuilder decryptStrBuilder = new StringBuilder();

        for (int i = 0; i < inputStr.length(); i++) {
            char currentChar = inputStr.charAt(i);
            int pos = Constants.ALPHABET.indexOf(currentChar);
            if (pos == -1){
                decryptStrBuilder.append(currentChar);
                continue;
            }
            int decryptPosition = (pos - shiftKey) % 33;

            if (decryptPosition < 0){
                decryptPosition = Constants.ALPHABET.length() + decryptPosition;
            }
            char decryptChar = Constants.ALPHABET.charAt(decryptPosition);
            decryptStrBuilder.append(decryptChar);
        }
        return decryptStrBuilder.toString();
    }
}
