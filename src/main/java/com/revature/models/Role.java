package com.revature.models;

import io.javalin.core.security.RouteRole;

public enum Role implements RouteRole {
    BASE, CUSTOMER, EMPLOYEE, MANAGER
}
