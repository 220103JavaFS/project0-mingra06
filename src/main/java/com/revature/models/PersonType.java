//This class defines a person, this can be inherited from depending on employee, customer, etc.


package com.revature.models;

public class PersonType {

    String firstName;
    String lastName;
    String email;
    int id;
    AccessLevel accessLevel;

    public PersonType() {
    }

    public PersonType(String firstName, String lastName, String email, int id, AccessLevel accessLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

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
