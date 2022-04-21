package com;


import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;


public class UserRegistration {


        public ArrayList<String> requestLogs;


         JSONObject jsonObject;


        public UserRegistration(JSONObject jsonObject) throws SQLException {

            this.jsonObject=jsonObject;

            this.requestLogs= getUserRegistration();

        }


       public ArrayList<String> getUserRegistration() throws SQLException {


           CheckUserData checkUserData = new CheckUserData(jsonObject);

           if(requestLogs==null){ SQLQueries.createNewUser(jsonObject);}

           return  checkUserData.requestLogs;


       }


      public ArrayList<String> getRequestLogs() {

              return requestLogs;
      }


}















