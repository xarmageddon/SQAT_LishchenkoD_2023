package ua.opu.sqat.cargo_taxi;


import java.io.*;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author david
 * @version 0.4.1
 */
/**
 *Клас який описую логіку роботи методів програми
 */
public class Program implements InterfaceObj {


    /**
     * Конструктор вантаж
     * */


    Cargo cargo1 = new Cargo(10001,800,"Чубарська 19","Миру 124");
    Cargo cargo2 = new Cargo(10002,1600,"Чубарська 19","Смокіна 40");
    Cargo cargo3 = new Cargo(10003,1000,"Володимирська 18","Артема, 54");
    Cargo cargoeror;
    int[] listOfprices = new int[] {cargo1.price,cargo2.price,cargo3.price};
    /**
     * вивід списку водіїв
     */
    public void listOfDrivers() {
        /**
         * Конструктор водій
         */


        Driver driver1=new Driver("BH1234AA");driver1.numberOfTell="Gogo";driver1.fullName="3801231231";
        Driver driver2=new Driver("BH3242AA");driver2.fullName="Kisame";driver2.numberOfTell="38064363463";
        Driver driver3=new Driver("DH7777AK");driver3.fullName="Saitama";driver3.numberOfTell="380532523452";

        System.out.println(driver1.getNumberOfCar()+"-"+driver1.fullName+"-"+driver1.numberOfTell);
        System.out.println(driver2.getNumberOfCar()+"-"+driver2.fullName+"-"+driver2.numberOfTell);
        System.out.println(driver3.getNumberOfCar()+"-"+driver3.fullName+"-"+driver3.numberOfTell);
        System.out.println("ХешКод об'єкта BH1234AA: "+Objects.hash(driver1.getNumberOfCar()));
    }

    /**
     * список адрес активних замовлень
     */
    public void listAdress() {
        System.out.println("Пункт А: "+cargo1.pointA+" - Пункт Б: "+cargo1.pointB);
        System.out.println("Пункт А: "+cargo2.pointA+" - Пункт Б: "+cargo2.pointB);
        System.out.println("Пункт А: "+cargo3.pointA+" - Пункт Б: "+cargo3.pointB);
    }
    public void listAdresseror() {
        try {
            System.out.println("Пункт А: " + cargoeror.pointA + " - Пункт Б: " + cargoeror.pointB);
        }catch (NullPointerException e){
            System.err.println("Помилка: NullPointerException ");
            System.err.println("Відсутній об'єкт класу Cargo");
        }
    }
    /**
     * список активних замовлень
     *
     */
    public void listOrder() {
        try {
            BufferedReader br = null;
            File file = new File("newFile.txt");
            if (!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            pw.println("id:"+cargo1.cargoId+"-"+cargo1.price+"грн - Пункт А: "+cargo1.pointA+" - Пункт Б: "+cargo1.pointB);
            pw.println("id:"+cargo2.cargoId+"-"+cargo2.price+"грн - Пункт А: "+cargo2.pointA+" - Пункт Б: "+cargo2.pointB);
            pw.println("id:"+cargo3.cargoId+"-"+cargo3.price+"грн - Пункт А: "+cargo3.pointA+" - Пункт Б: "+cargo3.pointB);
            pw.close();

            br = new BufferedReader(new FileReader("newFile.txt"));
            String line;
            while ((line= br.readLine()) != null){
                System.out.println(line);
            }


        }catch (IOException e){
            System.err.println("Error: "+e);
        }

    }


    /**
     * найважливіше перевезення
     */
    public void superTrans() {
        int superprice=0;

        try {
            for (int i = 0; i < listOfprices.length + 1; i++) {
                if (listOfprices[i] > superprice) {
                    superprice = listOfprices[i];
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Сталася помилка 'ArrayIndexOutOfBoundsException'");
            System.err.println("елементів в масиві "+listOfprices.length);
            System.err.println("була спроба задіяти елементів "+(listOfprices.length+1));
        }
        System.out.println("Данне перевезення є найважливішим:");
        if(superprice==cargo1.price){
            System.out.println("id:"+cargo1.cargoId+"-"+cargo1.price+"грн - Пункт А: "+cargo1.pointA+" - Пункт Б: "+cargo1.pointB);
        } else if (superprice==cargo2.price) {
            System.out.println("id:"+cargo2.cargoId+"-"+cargo2.price+"грн - Пункт А: "+cargo2.pointA+" - Пункт Б: "+cargo2.pointB);
        }else {
            System.out.println("id:"+cargo3.cargoId+"-"+cargo3.price+"грн - Пункт А: "+cargo3.pointA+" - Пункт Б: "+cargo3.pointB);}
    }

    /**
     * середня ціна послуги
     */
    public void averagePrice() {
        int avarage = (cargo1.price+cargo2.price+cargo3.price)/listOfprices.length;
        System.out.println("Середня вартість послуги :"+avarage+"грн");
    }

    public void clon() throws CloneNotSupportedException {
        /**
         * глибое клонування
         * @param driver оригінал
         * @param driverClone клон
         * */
        Driver driver = new Driver();
        Driver driverClone = (Driver) driver.clone();
        System.out.println("Оригінал об'єкта numberOfCar:"+driver.getNumberOfCar());
        System.out.print("Клон об'єкта numberOfCar:");
        System.out.println(driverClone.setNumberOfCar("BH4050АК"));

        /**
         * клонування конструктором копіювання
         * */
        Cargo cargo = new Cargo(4444,500,"Москва вул. Степана Бандери112","Москва вул. Степана Бандери12");
        System.out.println("Клонування конструктором копівання: ");
        System.out.println("id:"+cargo.cargoId+"-"+cargo.price+"грн - Пункт А: "+cargo.pointA+" - Пункт Б: "+cargo.pointB);

    }
    public void methodInter(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть id замовлення: ");

        int input = in.nextInt();

        switch (input){
            case 10001:
                System.out.println("id:"+cargo1.cargoId+" - Ціна:"+cargo1.price+"грн - Пункт А: "+cargo1.pointA+" - Пункт Б: "+cargo1.pointB);
                break;
            case 10002:
                System.out.println("id:"+cargo2.cargoId+" - Ціна:"+cargo2.price+"грн - Пункт А: "+cargo2.pointA+" - Пункт Б: "+cargo2.pointB);
                break;
            case 10003:
                System.out.println("id:"+cargo3.cargoId+" - Ціна:"+cargo3.price+"грн - Пункт А: "+cargo3.pointA+" - Пункт Б: "+cargo3.pointB);
                break;
            default:System.err.println("Замовлення за таким id не існує!");
        }




    }

}



