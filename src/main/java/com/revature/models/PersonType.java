//This class defines a person, this can be inherited from depending on employee, customer, etc.


package com.revature.models;

public class PersonType {

    String name;
    String email;
    int id;
    AccessLevel accessLevel;

    public PersonType() {
    }

    public PersonType(String name, String email, int id, AccessLevel accessLevel) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    public String getName() { return this.name; }
    public void setName(String newName) { this.name = newName; }

    public String getEmail() { return this.email; }
    public void setEmail(String newEmail) { this.email = newEmail; }

    public int getId() { return this.id; }
    public void setId(int newId) { this.id = newId; }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }
}
