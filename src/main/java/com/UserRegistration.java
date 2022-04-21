package com;


import org.json.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;


public class UserRegistration {


        private ArrayList<String> requestLogs;


         JSONObject jsonObject;


        public UserRegistration(JSONObject jsonObject) throws SQLException {

            this.jsonObject=jsonObject;

            this.requestLogs= getUserRegistration();

            if(this.requestLogs.isEmpty()){ this.requestLogs.add("200");SQLQueries.createNewUser(jsonObject);

                System.out.println(this.requestLogs);}

        }


       public ArrayList<String> getUserRegistration() throws SQLException {

           CheckUserData checkUserData = new CheckUserData(jsonObject);

           return  checkUserData.getRequestLogs();

       }


      public ArrayList<String> getRequestLogs() {

              return requestLogs;
      }


}















