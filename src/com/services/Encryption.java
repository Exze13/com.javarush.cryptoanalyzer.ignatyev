package com.services;

import com.сonstants.Constants;

public class Encryption {
    private Encryption() {
    }

    /**
     * Метод для шифрования строк, методом Цезаря
     *
     * @param inputStr - Входящая строка для шифрования
     * @param shiftKey - Ключ для шифрования
     * @return - Возвращаемая зашифрованная строка
     */
    public static String encryptData(String inputStr, int shiftKey) {
        inputStr = inputStr.toLowerCase();                                                  //Преобразуем входящую стрингу в нижний регистр
        StringBuilder encryptStrBuilder = new StringBuilder();

        for (int i = 0; i < inputStr.length(); i++) {                                       //Обьявляем цикл ФОР для переборки каждого символа входящей строки
            char currentChar = inputStr.charAt(i);
            int pos = Constants.ALPHABET.indexOf(currentChar);                              //Узнаем позицию каждого символа в алфавите, входящей стринги
            if (pos == -1) {
                encryptStrBuilder.append(currentChar);
                continue;
            }
            int encryptPosition = (shiftKey + pos) % 33;                                    //Получаем зашифрованный символ
            char encryptChar = Constants.ALPHABET.charAt(encryptPosition);

            encryptStrBuilder.append(encryptChar);                                          //Добавляем зашифрованный символ в стрингу для хранения зашифрованных данных
        }
        return encryptStrBuilder.toString();                                                //Возвращаем зашифрованную строку
    }
}
