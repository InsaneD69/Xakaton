package com;

import org.json.JSONException;
import org.json.JSONObject;
import java.sql.SQLException;
import java.util.*;
import static com.DatabaseConnection.nameUserSignTable;

public class CheckUserData {

     JSONObject jsonObject;

     private ArrayList<String> requestLogs ;

    public ArrayList<String> getRequestLogs() {

        return this.requestLogs;

    }

    boolean errors=false;


     public  CheckUserData(JSONObject jsonObject) throws SQLException {

         requestLogs=new ArrayList<>();

         this.jsonObject=jsonObject;

         EnumSet.allOf(UserRegistrationFields.class).forEach(field->{  //проверка заполненности всех   полей после передачи.
             errors=true;
             checkNotNullField(String.valueOf(field));

         });
         if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.email.name(),jsonObject.getString("email"),nameUserSignTable)){
             errors=true;
             requestLogs.add("Почта "+jsonObject.getString("INN")+" уже занята\n");

         }

            //проверка уникального названия компаниии
        if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.nameCompany.name(),jsonObject.getString("nameCompany"),nameUserSignTable)){
            errors=true;
            requestLogs.add("Компания с названием "+jsonObject.getString("nameCompany")+" уже существует\n");
         }

         //проверка уникального инн компаниии
        if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.INN.name(),jsonObject.getString("INN"),nameUserSignTable)){
            errors=true;
            requestLogs.add("ИНН "+jsonObject.getString("INN")+" уже был зарегестрированна\n");

        }
         //проверка уникального огрн компаниии
         if( CheckValueInDB.checkUniquenessValue(UserRegistrationFields.OGRN.name(),jsonObject.getString("OGRN"),nameUserSignTable)){
             errors=true;
             requestLogs.add("ОГРН "+jsonObject.getString("OGRN")+" уже был зарегестрированна\n");

         }

        if(errors){


            System.out.println(requestLogs);

        } else {

            requestLogs.add("200");

        }


     }



     public void checkNotNullField(String key){

        try{
            jsonObject.get(key);

        } catch (JSONException e){
            errors=true;
            requestLogs.add(  "Ошибка в поле: "+ UserRegistrationFields.valueOf(key).ruLocale+ " - поле пустое\n");


        }


    }









}
