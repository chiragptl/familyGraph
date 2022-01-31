package com.mo.exercise.programs;

public class Relationship {

        private Person to;
        private Person from;
        private String relationshipType;

    public Relationship(Person from, Person to, String relationshipType) {
            this.to = to;
            this.from = from;
            this.relationshipType = relationshipType;
        }
        public Person getTo() {
            return to;
        }
        public void setTo(Person to) {
            this.to = to;
        }
        public Person getFrom() {
            return from;
        }
        public void setFrom(Person from) {
            this.from = from;
        }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }
}
