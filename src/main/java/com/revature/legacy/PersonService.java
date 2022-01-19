//package com.revature.services;
//
//import com.revature.dao.PersonDAO;
//import com.revature.models.PersonType;
//
//import java.util.ArrayList;
//
//public class PersonService {
//
//
//    private PersonDAO avengerDAO = new PersonDAO();
//
//    public ArrayList<PersonType> gatherAllPersons(){
//        return avengerDAO.getAllPersons();
//    }
//
//    public PersonType getPerson(int id) {
//        return avengerDAO.getPersonById(id);
//    }
//
//    public boolean newPerson(PersonType a) {
//
//        if(avengerDAO.savePerson(a)){
//            return true;
//        }
//        return false;
//    }
//
//
//}
