package com.mo.exercise.programs;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedEdgeGraph {
    private HashMap<String, Person> people;
    private CSVFileReader reader;

    public WeightedEdgeGraph() {
        reader = new CSVFileReader();
        people = new HashMap<String,Person>();
    }
    public HashMap<String, Person> getPeople() {
            return people;
        }
    public void setPeople(HashMap<String, Person> people) {
            this.people = people;
        }
    public boolean addRelationship(String from, String to,String type) {
        Person personOne = people.get(from);
        Person personTwo = people.get(to);
        if(personOne == null || personTwo == null) {
            return false;
        }
        personOne.addRelationship(personTwo,type);
        personTwo.addRelationship(personOne,type);
        return true;
    }
    public void importPeopleFromCSV(String path) {
        for (String p : reader.Read(path)) {
            String[] fields = p.split(",");
            if (fields.length == 3) {
                String name = fields[0];
                String email = fields[1];
                byte age = Byte.parseByte(fields[2]);
                Person person = new Person(name, email, age);
                people.put(email, person);
            }
        }
    }
    public void importRelationshipFromCSV(String path) {
        for (String r : reader.Read(path)) {
            String[] fields = r.split(",");
            if (fields.length == 3) {
                String from = fields[0];
                String to = fields[2];
                String type = fields[1];
                addRelationship(from, to, type);
            }
        }
    }
    public Person getPersonByKey(String key) {
            return people.get(key);
        }
    public int sizeOfExtendedFamily(Person p) {
        ArrayList<String> links = computeExtendedFamily(p, new ArrayList<String>());
        return (int) links.stream().distinct().count();
    }
    private ArrayList<String> computeExtendedFamily(Person person,ArrayList<String> included) {
        included.add(person.getEmail());
        for(Relationship p:person.getRelationships()) {
            if(p.getRelationshipType().equals("FAMILY") && !(included.contains(p.getTo().getEmail()))) {
                included.addAll(computeExtendedFamily(p.getTo(),included));
            }
        }
        return included;
    }
}
