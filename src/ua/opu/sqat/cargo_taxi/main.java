package ua.opu.sqat.cargo_taxi;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * @author david
 * @version 0.4.1
 */
public abstract class main {
    /**
     * являється головним класом
     * котрий буде виконувати основний
     * код програми
     */
    public static void main(String[] args)throws Exception{
        ua.opu.sqat.cargo_taxi.Program program = new ua.opu.sqat.cargo_taxi.Program();


        ArrayList<String> address = new ArrayList<>();
        address.add(program.cargo1.pointA);
        address.add(program.cargo1.pointB);
        address.add(program.cargo2.pointA);
        address.add(program.cargo2.pointB);
        address.add(program.cargo3.pointA);
        address.add(program.cargo3.pointB);

         /*ArrayList arrayList = new ArrayList();
         arrayList.add(program.cargo1.pointA);
         arrayList.add(program.cargo2);
         arrayList.add(program.cargo3);
         Object[] objArray = arrayList.toArray();*/

        Scanner in = new Scanner(System.in);
        System.out.println("Меню:");
        System.out.println("Вивести список водіїв - введіть 1");
        System.out.println("Виввести список адрес активних замовень - введіть 2");
        System.out.println("Вивести список активних замовлень - введіть 3");
        System.out.println("Вивести кількість клієнтів з обраною адресою - введіть 4");
        System.out.println("Вивести деталі найважливішого перевезення - введіть 5");
        System.out.println("Вивести вивести середню ціну послуги - введіть 6");
        System.out.println("Клоновані об'єкти - введіть 7");
        System.out.println("Приклад помилки NullPointerException - введіть 8 ");
        System.out.println("Інтерфейс - 9 ");

        try {
            int button;

            do {
                do {
                    System.out.println("Для виходу - введіть 0");
                    System.out.print("Введення:");

                    button = in.nextInt();
                    if (button > 9) {
                        System.err.println("Правильний діапазон введення від 0 до 9");
                    }
                } while (button > 9);

                switch (button) {
                    case 1:
                        program.listOfDrivers();
                        break;
                    case 2:
                        program.listAdress();
                        break;
                    case 3:
                        program.listOrder();
                        System.out.println("Дані замовлення зчитані з файлу 'newFile.txt' ");
                        break;
                    case 4:
                        /**
                         * кількість клієнтів з обраною адресою
                         */
                        Scanner inn = new Scanner(System.in);
                        System.out.print("Введіть адресу: ");
                        String input = inn.nextLine();
                        int zbig = 0;

                        for (String i : address) {
                            if (input.equals(i)) {
                                zbig++;
                            }
                        }
                        System.out.println("кількість клієнтів з обраною адресою: " + zbig);
                        break;
                    case 5:
                        program.superTrans();
                        break;
                    case 6:
                        program.averagePrice();
                        break;
                    case 7:
                        program.clon();
                        break;
                    case 8:
                        program.listAdresseror();
                    case 9:
                        program.methodInter();
                }

            } while (button != 0);

        } catch (InputMismatchException e) {
            InputMismatchException inputMismatchException = new InputMismatchException();
            System.err.println("Помилка:InputMismatchException: "+inputMismatchException.getMessage());
            System.err.println("Некоректне введення");


        }
    }

}

