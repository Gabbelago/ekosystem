	

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package test_ledning;
     
    /**
     *
     * @author mattias
     */
    public class Person {
        private int id;
        private String name;
        private String personnr;
        private int roll;
       
        public Person (int id, String name, String personnr, int roll) {
            this.setId(id);
            this.setName(name);
            this.setPersonnr(personnr);
            this.setRoll(roll);
           
        }
     
        public void setId(int id) {
            this.id = id;
        }
     
        public void setName(String name) {
            this.name = name;
        }
     
        public void setPersonnr(String personnr) {
            this.personnr = personnr;
        }
     
        public void setRoll(int roll) {
            this.roll = roll;
        }
       
     
        public int getId() {
            return id;
        }
     
        public String getName() {
            return name;
        }
     
        public String getPersonnr() {
            return personnr;
        }
     
        public int getRoll() {
            return roll;
        }
        
        public String idName() {
            
            String idName = getId() + ". " + getName();
            
            return idName;
        }
    }


