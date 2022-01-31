package com.mo.exercise.programs;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        WeightedEdgeGraph people = new WeightedEdgeGraph();
        people.importPeopleFromCSV("src/test/resources/people.csv");
        people.importRelationshipFromCSV("src/test/resources/relationships.csv");

        int size = people.getPeople().size();
        String message = "people.csv has 12 rows however collection has: "+ size;
        System.out.println(message);

        Person bob = people.getPersonByKey("bob@bob.com");
        Person jenny = people.getPersonByKey("jenny@toys.com");
        Person nigel = people.getPersonByKey("nigel@marketing.com");
        Person alan = people.getPersonByKey("alan@lonely.org");

        System.out.println("\nbob has "+bob.getRelationships().size()+" relationships");
        System.out.println("jenny has "+jenny.getRelationships().size()+" relationships");
        System.out.println("nigel has "+nigel.getRelationships().size()+" relationships");
        System.out.println("alan has "+alan.getRelationships().size()+" relationships");

        System.out.println("\njenny has "+people.sizeOfExtendedFamily(jenny)+" family members");
        System.out.println("bob has "+people.sizeOfExtendedFamily(bob)+" family members");

    }
}
