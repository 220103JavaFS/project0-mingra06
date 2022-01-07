//This class defines a person, this can be inherited from depending on employee, customer, etc.


package com.revature;

public class PersonType {

    String name;
    String email;
    int id;

    public String getName() { return this.name; }
    public void setName(String newName) { this.name = newName; }

    public String getEmail() { return this.email; }
    public void setEmail(String newEmail) { this.email = newEmail; }

    public int getId() { return this.id; }
    public void setId(int newId) { this.id = newId; }



}
