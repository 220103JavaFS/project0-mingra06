////This class defines the structure for updating and managing the database.
//
//package com.revature.controllers;
//
//import com.revature.services.PersonService;
//import com.revature.models.PersonType;
//import io.javalin.Javalin;
//import io.javalin.http.Handler;
//
//import java.util.List;
//
//public class PersonController implements Controller{
//
//    private PersonService personService = new PersonService();
//
//    private Handler getAllPersons = (ctx) ->{
//        List<PersonType> list = personService.gatherAllPersons();
//
//        ctx.json(list);
//        ctx.status(200);
//    };
//
//    private Handler getOnePerson = (ctx)->{
//        String pathId = ctx.pathParam("id");
//        int id = Integer.parseInt(pathId);
//        PersonType a = personService.getPerson(id);
//        ctx.json(a);
//        ctx.status(200);
//    };
//
//    private Handler addPerson = (ctx) ->{
//        PersonType a = ctx.bodyAsClass(PersonType.class);
//        if(personService.newPerson(a)){
//            ctx.status(201);
//        }else{
//            ctx.status(400);
//        }
//    };
//
//    @Override
//    public void addRoutes(Javalin app) {
//        app.get("/person", getAllPersons);
//        app.get("/person/{id}", getOnePerson);
//        app.post("/person", addPerson);
//    }
//
//



//}
