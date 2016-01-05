/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_ledning;

/**
 *
 * @author Gabetop
 */
public class Roles {
    
    private int roleid;
    private String role;
    private int wage;
    
    public Roles (int roleid, String role, int wage) {
            this.setRoleid(roleid);
            this.setRole(role);
            this.setWage(wage);
           
        }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getRoleid() {
        return roleid;
    }

    public String getRole() {
        return role;
    }

    public int getWage() {
        return wage;
    }
    
}
