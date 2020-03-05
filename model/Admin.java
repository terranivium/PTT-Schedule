package model;

public class Admin { // Class does not need to be used?
    private ListOfStaff listOfStaff = new ListOfStaff();

    public Admin(){

    }

    public ListOfStaff getListOfStaff(){
        return this.listOfStaff;
    }
}
