package ua.opu.sqat.cargo_taxi;

import javax.swing.plaf.PanelUI;
import java.util.Objects;

/**
 * @author david
 * @version 0.4.1
 */


public class Cargo {
    //private Driver numberOfCar = new Driver();
    public int cargoId;
    public int price;
    public String pointA;
    public String pointB;

    /**
     * перевизначення equals
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cargo cargo = (Cargo) o;
        return cargoId == cargo.cargoId;
    }
    /**
     *перевизначення  hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(cargoId);
    }

    /**
     * Конструктор вантажу
     * */
    public Cargo(int cargoId,int price,String pointA,String pointB){
        this.cargoId=cargoId;
        this.price=price;
        this.pointA=pointA;
        this.pointB=pointB;
    }
    public Cargo(Cargo other){
        this(other.cargoId, other.price, other.pointA, other.pointB);
    }

}

