/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.db;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author Roger
 */
public class ConnectionUtils {
    
    private Connection connection = null;
    
    public ConnectionUtils(){}
    
    public void init(){
        try
        {
            System.out.println("...tentando conectar...");
            
            String dbURL = "jdbc:mysql://localhost:3311/agenda?zeroDateTimeBehavior=convertToNull";
            //String dbURL = "jdbc:derby://localhost:1527/GameStoreDB";
            
            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "root");
            
            connection = DriverManager.getConnection(dbURL, properties);
            
            System.out.println("conectado!");
        }
        catch(Exception ex){
            System.out.println("Falha de conexão à base de dados.");
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection() throws SQLException {
        
        if (connection == null || connection.isClosed()){
            init();
        }
        
        return connection;
    }
    
     public void close(ResultSet rs){
        
        if(rs !=null){
            try{
               rs.close();
            }
            catch(Exception e){}
        
        }
    }
    
     public void close(java.sql.Statement stmt){
        
        if(stmt !=null){
            try{
               stmt.close();
            }
            catch(Exception e){}
        
        }
    }
     
  public void destroy(){
  
    if(connection !=null){
    
         try{
               connection.close();
            }
            catch(Exception e){}
        
        
    }
  }
}