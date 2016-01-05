	

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package test_ledning;
     
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.logging.Level;
    import java.util.logging.Logger;
     
    /**
     *
     * @author Gabetop
     */
    public class DB_conn {
       
        //Skapar en arraylista f�r produkter.
            Connection connection = null;
            Statement stmt = null;
            String projectTable = "projects";
            String employeeTable = "employees";
            String rolesTable = "roles";
            String relationTable = "relations";
            String hourTable = "hours";
                
           
           
            public void Try_conn() {
                try {
                    DB_conn();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DB_conn.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DB_conn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
           
            /**
             * Uppr�ttar en anslutning till databasen.
         * @throws java.lang.ClassNotFoundException
         * @throws java.sql.SQLException
             */
           
            public void DB_conn() throws ClassNotFoundException, SQLException {
                   
     
           
               try {
                   
                String user = "725G75MKAB15G2";
                String pwd = "CMvwgQzax";
               
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String URL = "jdbc:sqlserver://IDASQL.ad.liu.se;databaseName=725G75;";
                connection = DriverManager.getConnection(URL, user, pwd);
                stmt = connection.createStatement();
               
                } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Can't connect to db");
            }
               
                 
         /* 
         //  SKAPA DATABASINLÄGG
            try {
               
            Statement stmt2 = connection.createStatement();
            String strSQL;
               
            strSQL = "INSERT INTO " + rolesTable + " (rolename, hourlywage) "             
               + "VALUES ('Systemutvecklare', '700')";          
               stmt2.executeUpdate(strSQL);       
               strSQL = "INSERT INTO " + rolesTable + " (rolename, hourlywage) "      
               + "VALUES ('Affärskonsult', '750')";             stmt2.executeUpdate(strSQL);   
               strSQL = "INSERT INTO " + rolesTable + " (rolename, hourlywage) "         
               + "VALUES ('Projektledare', '950')";    
               stmt2.executeUpdate(strSQL);   
              
   
            
  strSQL = "INSERT INTO " + projectTable + " (customer, projectname, \n"
                    + "startdate, enddate, projectleader, status, description, budgettedcost) \n"
                    + "VALUES ('Kalle Svensson', 'Godisautomat', '2015-06-24', '2015-07-27', 'Fritjof Höst', 'Planerat',"
                    + " 'Utveckling av en godisautomat som kan skapa godis ur tomma luften', 500000)";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + projectTable + " (customer, projectname, \n"
                    + "startdate, enddate, projectleader, status, description, budgettedcost) \n"
                    + "VALUES ('LiU', 'Lisam', '2013-11-24', '2030-04-19', 'Ivan Nilsson', 'Aktivt',"
                    + " 'Utveckling av en ny webplattform för universitet', 100000)";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + projectTable + " (customer, projectname, \n"
                    + "startdate, enddate, projectleader, status, description, budgettedcost) \n"
                    + "VALUES ('Ivan Nilsson', 'Programmeringsprojekt', '2015-03-01', '2015-03-27', 'Fritjof Höst', 'Aktivt',"
                    + " 'Utveckling av ett projekthanteringssystem', 300)";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + projectTable + " (customer, projectname, \n"
                    + "startdate, enddate, projectleader, status, description, budgettedcost) \n"
                    + "VALUES ('IEI', 'Grundskurs programmering', '2014-09-01', '2014-11-10', 'Ivan Nilsson', 'Avslutat',"
                    + " 'En programmeringskurs för systemvetarstudenter', 80000)";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + employeeTable + " (name, personnr, role, username, password) "
                    + "VALUES ('Fritjof Höst', '199207022519', 'konsult', 'friho608', 'friho608')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + employeeTable + " (name, personnr, role, username, password) "
                    + "VALUES ('Ivan Nilsson', '195404031111', 'hr', 'IvanN', 'IvanN')";
             stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + employeeTable + " (name, personnr, role, username, password) "
                    + "VALUES ('Matte Kod', '195404031111', 'konsult', 'matte', 'kod')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + employeeTable + " (name, personnr, role, username, password) "
                    + "VALUES ('Kalle Svensson', '198305252222', 'it-chef', 'KalleS', 'KalleS')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + employeeTable + " (name, personnr, role, username, password) "
                    + "VALUES ('Palle Andersson', '197212243333', 'hr-chef', 'PalleA', 'PalleA')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + employeeTable + " (name, personnr, role, username, password) "
                    + "VALUES ('Jesus', '000000000000', 'konsult', 'Jesus', 'Jesus')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + rolesTable + " (rolename, hourlywage) "
                    + "VALUES ('Systemutvecklare', '700')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + rolesTable + " (rolename, hourlywage) "
                    + "VALUES ('Affärskonsult', '750')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + rolesTable + " (rolename, hourlywage) "
                    + "VALUES ('Projektledare', '950')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + relationTable + " (employeesid, projectid, rolesid) "
                    + "VALUES ('1', '1', '3')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + relationTable + " (employeesid, projectid, rolesid) "
                    + "VALUES ('2', '2', '3')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + relationTable + " (employeesid, projectid, rolesid) "
                    + "VALUES ('1', '3', '2')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + relationTable + " (employeesid, projectid, rolesid) "
                    + "VALUES ('1', '4', '1')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + relationTable + " (employeesid, projectid, rolesid) "
                    + "VALUES ('2', '4', '2')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + relationTable + " (employeesid, projectid, rolesid) "
                    + "VALUES ('2', '1', '1')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('2', '2', '6', '5', '2015-11-20')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('2', '2', '8', '5', '2015-11-22')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('2', '2', '4', '5', '2015-11-23')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('2', '2', '7', '5', '2015-11-24')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('1', '3', '40', '12', '2015-11-25')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('1', '3', '40', '15', '2015-11-26')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('1', '4', '40', '20', '2015-11-27')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('2', '4', '5', '1', '2015-11-28')";
            stmt2.executeUpdate(strSQL);
            strSQL = "INSERT INTO " + hourTable + " (employeesid, projectid, hoursworked, overtimeworked, datereported) "
                    + "VALUES ('2', '4', '40', '5', '2015-11-29')";
            stmt2.executeUpdate(strSQL);
           
            } catch (Exception e) {
            }
            */
            
            }
           
           
            /**
             * Metod som anropas f�r att st�nga uppkopplingen till databasen
             */
            public void closeConnection() {
                   
                    try {
                            connection.close();
                            System.out.println("stänger uppkoppling");
                    } catch (SQLException e) {
                        System.out.println(e);
                    }
                   
            }
            /*
           
        }
    */
       
       
       
       
    }

