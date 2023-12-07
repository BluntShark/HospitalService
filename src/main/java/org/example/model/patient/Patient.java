package org.example.model.patient;

import org.example.model.address.Address;

import java.util.List;

/**
 * @author
 * Класс Patient (пациенты)
 */
public class Patient{
    private String name;
    private int age;
    private List<String> illness;
    private Address address;
    private String patientID;
    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Patient(String name, int age, List<String> illness, String patientID){
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.patientID = patientID;
    }
    public List<String> getIllness() {
        return illness;
    }
    /**
     * Меняет список заболеваний
     * @param illness
     */
    public void setIllness(List<String> illness) { this.illness = illness; }
    /**
     * Возвращает строковое предствление класса Patient (имя, адрес, заболевания)
     * @return String
     */

    @Override
    public String toString(){
        return "Name: " + name +
                ", Age: " + age +
                ", Illness: " + illness +
                ", Address: " + getAddress() +
                ", ID: " + patientID +
                 "]";
    }

    /**
     * Возвращает равенство объектов
     * @param obj сопоставляющийся объект
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else {
            return obj != null && obj.getClass() == this.getClass();
        }
    }

    /**
     * Возвращает hashCode объекта
     * @return hashCode
     */
    @Override
    public int hashCode(){
        int total = 31;
        total = total * 31 + name.hashCode();
        total = total * 31 + age;

        total = total * 31 + name.hashCode();
        return total;
    }

    /**
     * Возвращает копию объекта
     * @return Object
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
