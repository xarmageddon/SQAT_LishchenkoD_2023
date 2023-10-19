package ua.opu.sqat.cargo_taxi;

/**
 * @author david
 * @version 0.4.1
 */
public class OrderRecipient extends Person {
    public String nameOfCompany;
    public String address;

    public void doOrder(){
        System.out.println("Оформити замовлення");
    }
}
