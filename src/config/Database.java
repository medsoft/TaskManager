package config;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class Database {

   private  Connection connection ;
   private ResultSet resultSet ;
   private  PreparedStatement pstm ;
   private int ok   ;


   private  void  getConnection  ()
   {
       String url  = "jdbc:mysql://localhost:3306/task" ;
       String user  =  "root";
       String password  = "" ;

           try {
               Class.forName("com.mysql.jdbc.Driver") ;
               connection = DriverManager.getConnection(url,user , password ) ;
           } catch (Exception e) {
               e.printStackTrace();
           }
   }

   public void initPrepare (String sql)
   {

       try {
           getConnection()  ;
           pstm = connection.prepareStatement(sql)  ;
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

   public ResultSet executeSelect () {

       try {
           resultSet = pstm.executeQuery() ;
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

       return  resultSet ;
   }

   public int executeMaj ()
   {
       try {
           ok = pstm.executeUpdate()  ;
       } catch (Exception e) {
           e.printStackTrace();
       }
    return  ok  ;
   }

   public void closeConnection  ()
   {
       if (connection!= null) {
           try {
               connection.close();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }
    public  PreparedStatement getPstm () throws  SQLException{
       return  pstm ;
    }

}
