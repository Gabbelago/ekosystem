/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_ledning;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author patrickhansson
 */
public class Project {
       private int projectid;
       private String projectname;
       private String projectowner;
       private String projectleader;
       private String projectstatus;
       private int budgettedcost;
       private Date startdate; 
       private Date enddate;
       
       public Project (int projectid, String projectowner, String projectname, Date startdate, Date enddate, String projectleader, String projectstatus, int budgettedcost) {
           this.setProjectid(projectid);
           this.setProjectname(projectname);
           this.setProjectowner(projectowner);
           this.setProjectleader(projectleader);
           this.setProjectstatus(projectstatus);
           this.setBudgettedcost(budgettedcost);
           this.setStartdate(startdate);
           this.setEnddate(enddate);

        }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getStartdate() {
        return startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setBudgettedcost(int budgettedcost) {
        this.budgettedcost = budgettedcost;
    }

    public int getBudgettedcost() {
        return budgettedcost;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public void setProjectowner(String projectowner) {
        this.projectowner = projectowner;
    }

    public void setProjectleader(String projectleader) {
        this.projectleader = projectleader;
    }

    public void setProjectstatus(String projectstatus) {
        this.projectstatus = projectstatus;
    }

    public int getProjectid() {
        return projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public String getProjectowner() {
        return projectowner;
    }

    public String getProjectleader() {
        return projectleader;
    }

    public String getProjectstatus() {
        return projectstatus;
    }

}
