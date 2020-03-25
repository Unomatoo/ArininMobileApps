package com.example.phraser;

import android.content.Context;

public class Phraser {

    public static String PhraserGen() {
        String[] wordListOne = {"круглосуточный", "звёздный",
                "огромный", "взаимный", "растущий", "фронтэнд",
                "технологичный", "проникающий", "умный", "динамичный"};

        String[] wordListTwo = {"уполномоченный", "трудный",
                "чистый продукт", "ориентированный", "центральный",
                "распределенный", "кластеризованный", "фирменный",
                "нестандартный", "позиционированный", "сетевой",
                "сфокусированный", "использованный с выгодой", "выровненный",
                "целесообразный", "общий", "совместный", "ускоренный"};

        String[] wordListThree = {"процесс", "пункт разгрузки",
                "выход из положения", "тип структуры", "талант", "подход",
                "уровень завоеванного внимания", "портал", "период времени",
                "обзор", "образец", "пункт следования"};

        //Вычисляем, сколько слов в каждом списке
        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLength = wordListThree.length;

        //Генерируем три случайных числа
        int rl = (int) (Math.random() * oneLength) ;
        int r2 = (int) (Math.random() * twoLength) ;
        int r3 = (int) (Math.random() * threeLength);
        //Теперь строим фразу
        String phrase =  "Всё, что нам нужно – это " + wordListOne[rl] + " " +
                wordListTwo[r2] + " " + wordListThree[r3];

        return phrase;
    }

    public static String SwapSubStrings(String string) {
        //Меняем подстроки местами
        String result = "";
        if (string != null) {
            String pivotString = "– это";
            String substr1 = string.substring(0, string.indexOf(pivotString));
            substr1 = substr1.trim();
            substr1 = substr1.toLowerCase();
            String first = string.substring(string.indexOf(pivotString)+pivotString.length()+1, string.indexOf(pivotString)+pivotString.length()+2);
            first = first.toUpperCase();
            String substr2 = string.substring(string.indexOf(pivotString)+pivotString.length()+2);
            substr2 = substr2.trim();
            result = first + substr2 + " " + pivotString + " " + substr1 + ".";
        }
        return result;
    }
}
