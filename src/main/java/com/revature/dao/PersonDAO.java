package com.revature.dao;

import com.revature.models.*;

import java.util.ArrayList;

import static javax.swing.UIManager.get;

public class PersonDAO {

    ArrayList<PersonType> personTypeArrayList;

    public PersonDAO(){
        personTypeArrayList = new ArrayList<>();
        personTypeArrayList.add(
                new PersonType("Nancy Smith", "nancysmith@yahoo.com", 1, AccessLevel.BASE));
        personTypeArrayList.add(
                new Customer("Drew Barrymore", "randomactress@aol.com",2, new ArrayList<BankAccount>()));
        personTypeArrayList.add(
                new Employee("Travis Mcmullen", "randomactress@aol.com", 3, 1, AccessLevel.EMPLOYEE));
        personTypeArrayList.add(
                new Employee("Taylor Lautner", "randomactress@aol.com", 4, 1, AccessLevel.MANAGER));
    }


    public ArrayList<PersonType> getAllPersons(){
        return (personTypeArrayList);
    }


    public PersonType getPersonById(int id) {
        return (personTypeArrayList.get((id-1)));
    }

    public boolean savePerson(PersonType a) {
        personTypeArrayList.add(a);
        return true;
    }

}
