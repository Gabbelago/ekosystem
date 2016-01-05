/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_ledning;

import java.sql.Date;

/**
 *
 * @author patrickhansson
 */
public class Faktura {
    
    private int fakturaID;
    private int projectID;
    private int cost;
    private String ocr;
    private Date startdate;
    private Date enddate;
    
    public Faktura (int fakturaID, int projectID, int cost, String ocr, Date startdate, Date enddate) {
           this.setFakturaID(fakturaID);
           this.setProjectID(projectID);
           this.setCost(cost);
           this.setOcr(ocr);
           this.setStartdate(startdate);
           this.setEnddate(enddate);
           
    }

    public void setFakturaID(int fakturaID) {
        this.fakturaID = fakturaID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setOcr(String ocr) {
        this.ocr = ocr;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getFakturaID() {
        return fakturaID;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getCost() {
        return cost;
    }

    public String getOcr() {
        return ocr;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getEnddate() {
        return enddate;
    }
    
}
