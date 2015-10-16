package com.konradkrakowiak.spocktestexample.logic

import spock.lang.Specification
import spock.lang.Unroll


class UserShould extends Specification {


    def user = new User();

    @Unroll
    def "return #fullName for first name : #firstName and  last name : #lastName"() {
        given:
        user.firstName = firstName
        user.lastName = lastName
        expect:
        user.fullName() == fullName
        where:
        firstName | lastName    || fullName
        "Konrad"  | "Krakowiak" || "Konrad Krakowiak"
        "Test"    | "TestLast"  || "Test TestLast"
    }
}
