package com;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.*;


import static com.DatabaseConnection.nameAuthDataTable;

public class CheckUserData {

     JSONObject jsonObject;

     public ArrayList<String> requestLogs =new ArrayList<>();

    boolean errors=false;


     public  CheckUserData(JSONObject jsonObject) throws SQLException {



         this.jsonObject=jsonObject;

         EnumSet.allOf(UserRegistrationFields.class).forEach(field->{  //проверка заполненности всех   полей после передачи.

             checkNotNullField(String.valueOf(field));

         });
         if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.email.name(),jsonObject.getString("email"),nameAuthDataTable)){

             requestLogs.add("Почта "+jsonObject.getString("INN")+" уже занята");

         }

            //проверка уникального названия компаниии
        if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.nameCompany.name(),jsonObject.getString("nameCompany"),nameAuthDataTable)){

            requestLogs.add("Компания с названием "+jsonObject.getString("nameCompany")+" уже существует");
         }

         //проверка уникального инн компаниии
        if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.INN.name(),jsonObject.getString("INN"),nameAuthDataTable)){

            requestLogs.add("ИНН "+jsonObject.getString("INN")+" уже был зарегестрированн");

        }
         //проверка уникального огрн компаниии
         if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.OGRN.name(),jsonObject.getString("OGRN"),nameAuthDataTable)){

             requestLogs.add("ОГРН "+jsonObject.getString("OGRN")+" уже был зарегестрированн");

         }




     }



     public void checkNotNullField(String key){

        try{
            jsonObject.get(key);

        } catch (JSONException e){

            requestLogs.add(  "Ошибка в поле: "+ UserRegistrationFields.valueOf(key).ruLocale+ " - поле пустое");


        }


    }









}
