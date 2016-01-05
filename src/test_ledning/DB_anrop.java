	

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package test_ledning;
     
     
    import java.sql.Connection;
    import java.sql.Date;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    /**
     *
     * @author mattias
     */
    public class DB_anrop {
        DB_conn conn = new DB_conn();
        String sql;
        String projectTable = "projects";
        public boolean LoginCheck(String name, String pass) {
           
            conn.Try_conn();
           
            boolean authorize = false;
           
            try {
               
            Statement sta = conn.connection.createStatement();
            sql = "SELECT * FROM employees WHERE username = '" + name + "' AND password = '" + pass + "'";
           
            ResultSet rs = sta.executeQuery(sql);
               
            while(rs.next()) {
                authorize = true;
            }
           
            } catch (Exception e) {
            }
       
     
            conn.closeConnection();
            return authorize;
        }
       
        public void Skapaprojekt(Project pro) {
           
            conn.Try_conn();
            String SQL;
            Statement sta;
            try {
                sta = conn.connection.createStatement();
      
            
            SQL = "INSERT INTO " + projectTable +" (customer, projectname, \n"
                    + "startdate, enddate, projectleader, status, description, budgettedcost) \n"
                    + "VALUES ( '" + pro.getProjectowner() + "','" + pro.getProjectname() + "', '2015-06-24', '2016-06-24', '" + pro.getProjectleader() + "', 'Planerat',"
                    + " 'Kul med projects liksom', '" + pro.getBudgettedcost() + "')";
            sta.executeUpdate(SQL);
            
                  } catch (SQLException ex) {
                Logger.getLogger(DB_anrop.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conn.closeConnection();
        }
       
        public ArrayList<Person> getEmployees() throws SQLException {
            int id;
            String name = "";
            String personnr = "";
            int roll = 0;
            ArrayList<Person> allemployees = new ArrayList<Person>();  
            
               conn.Try_conn();
           
      
			Statement sta = conn.connection.createStatement();
                         sql = "SELECT employeesid, name, personnr FROM employees";
			ResultSet rs = sta.executeQuery(sql);
                        
                        while(rs.next()) {
			id = rs.getInt("employeesid");
			name = rs.getString("name");
			personnr = rs.getString("personnr");
                        
			Person p = new Person(id, name, personnr, roll);
			allemployees.add(p);
                        
                        } 
                              
                        
                  conn.closeConnection();
                  
         return allemployees;
        }
            // Radvis bearbetning
        
        
public ArrayList<Project> getProject() throws SQLException {
            int projectid;
            String projectname;
            String projectowner;
            String projectleader;
            String projectstatus;
            int budgeteradkostnad;
            
            ArrayList<Project> allProjects = new ArrayList<Project>();  
             
            conn.Try_conn();
           
			Statement sta = conn.connection.createStatement();
                         sql = "SELECT projectid, customer, projectname, startdate, enddate, projectleader, status, budgettedcost FROM projects";
			ResultSet rs = sta.executeQuery(sql);
                        
                        while(rs.next()) {
			projectid = rs.getInt("projectid");
                        projectowner = rs.getString("customer");
			projectname = rs.getString("projectname");		
                        projectleader = rs.getString("projectleader");
                        projectstatus = rs.getString("status");
                        budgeteradkostnad = rs.getInt("budgettedcost");
                        Date startdate = rs.getDate("startdate");
                        Date enddate = rs.getDate("enddate");
                       
                        
			Project pt = new Project(projectid, projectowner, projectname, startdate, enddate, projectleader, projectstatus, budgeteradkostnad);
			allProjects.add(pt);
                        
                        } 
                        
                  conn.closeConnection();
                  
         return allProjects;
        }

    public ArrayList<Roles> getRoles() {
         ArrayList<Roles> roleList = new ArrayList<>();
         int id;
         String roleName;
         int wage;
         Statement sta;
         conn.Try_conn();
       
            try {
                sta = conn.connection.createStatement();
     
                         sql = "SELECT rolesid, rolename, hourlywage FROM roles";
			ResultSet rs = sta.executeQuery(sql);
                        
                        while(rs.next()) {
			id = rs.getInt("rolesid");
			roleName = rs.getString("rolename");
			wage = rs.getInt("hourlywage");
                        
			Roles r = new Roles(id, roleName, wage);
			roleList.add(r);
                        
                        } 
                        
                               } catch (SQLException ex) {
                Logger.getLogger(DB_anrop.class.getName()).log(Level.SEVERE, null, ex);
            }
                  conn.closeConnection();
         
        return roleList;
    }
	
    /*
          public Faktura uploadFaktura(Faktura fak) throws SQLException {
           
             
            conn.Try_conn();
            
            int fakturaID = fak.getFakturaID();
            int projectID;
            int cost;
            String ocr;
            Date startdate;
            Date enddate;
                        Statement sta;
			sta = conn.connection.createStatement();
                        // sql = "INSERT fakturaid, projectid, cost, ocr, startdate, enddate INTO projects";
 sql = "INSERT faktura (fakturaid, projectid, cost, ocr, startdate, enddate) VALUES ('"
					+ fakturaID
					+ "','"
					+ projectID
					+ "','"
					+ cost
					+ "','"
					+ ocr
                                        + "','"
                                        + startdate
                                        + "','"
                                        + enddate
					+ "')";
                        
                        ResultSet rs = sta.executeQuery(sql);                                   
                        
            
            conn.closeConnection();
            
            return Fakturor;
                        
        }     */
    
    public int nextprojektid() throws SQLException{
           
            conn.Try_conn();
           
                        Statement sta = conn.connection.createStatement();
                        sql="SELECT TOP 1 projectid FROM projects ORDER BY projectid DESC";
                        ResultSet rs = sta.executeQuery(sql);
                        int nextproId =0;
                       
                      if (rs.next()) {
                          nextproId =  ((Number) rs.getObject(1)).intValue();
                      }
                      else{
                          System.out.println("resultset är tomt");
                       
                      }
            conn.closeConnection();
            return nextproId;
        }
     
        }
       
    

