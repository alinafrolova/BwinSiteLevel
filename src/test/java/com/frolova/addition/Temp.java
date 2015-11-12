package com.frolova.addition;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Frolova.A on 11/10/2015.
 */
public class Temp {
    public static String randomtxt(int n){
        char[] str = {'z','x','a','s','d','f','g','h','j','k','l','q','w','e','r','t','y','u','u','i','c','v','b','n','m','o','p'};
        StringBuilder sb = new StringBuilder();
        Random random = new Random(100);
        for(int x = 1; x < n; x++) {
            sb.append(str[random.nextInt(str.length)]);
        }
        return sb.toString();
    };
    public static void writeToFile (String fileName,String name) {

        //Определяем файл
        File file = new File(fileName);

        try {
            //проверяем, что если файл не существует то создаем его
            if(!file.exists()){
                file.createNewFile();
                System.out.println("create file");
            }
            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            System.out.println(name);
            try {
                //Записываем текст у файл
                out.print(name);
            } finally {
                System.out.println("close");
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);

        }
    }
}
