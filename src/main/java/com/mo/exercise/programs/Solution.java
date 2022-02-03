package com.mo.exercise.programs;

public class Solution {
    public static void main(String[] args) {

        WeightedEdgeGraph people = new WeightedEdgeGraph();
        people.importPeopleFromCSV("src/test/resources/people.csv");
        people.importRelationshipFromCSV("src/test/resources/relationships.csv");

        int size = people.getPeople().size();
        String message = "people.csv has 12 rows however collection has: "+ size;
        System.out.println(message);

        Person person1 = people.getPersonByKey("bob@bob.com");
        Person person2 = people.getPersonByKey("jenny@toys.com");
        Person person3 = people.getPersonByKey("nigel@marketing.com");
        Person person4 = people.getPersonByKey("alan@lonely.org");

        System.out.println(person1.getRelationshipCount());
        System.out.println(person2.getRelationshipCount());
        System.out.println(person3.getRelationshipCount());
        System.out.println(person4.getRelationshipCount());

        System.out.println(people.sizeOfExtendedFamily(person2));
        System.out.println(people.sizeOfExtendedFamily(person1));

    }
}
