package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import static com.DatabaseConnection.connectionDB;

abstract public class CheckValueInDB {



       static public boolean checkUniquenessValue(String type,String field, String table) throws SQLException {


              Statement statement = connectionDB.createStatement();
              ResultSet resultSet=statement.executeQuery("select  u.\""+type+"\" from \""+table+"\" u; ");

              while(resultSet.next()){


                    if( resultSet.getString(type).equals(field)){return true;};
              }
              return false;


       }








}
