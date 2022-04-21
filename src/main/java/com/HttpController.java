package com;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class HttpController {



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(path="URL")
    public void greeting(HttpServletRequest request, HttpServletResponse response) throws  IOException {//В ковычках передается запрашиваемое поле
        PrintWriter out = response.getWriter();//С помощью этого мы будем писать информацию в ответ
        JSONObject js=null;
        //connect2db();//Попытка подключения к бд
        /*if (connection != null) {
            out.println("Connect to DB established!<br/>");
            out.flush();
        }*/
        //Далее нужно сделать запрос в базу данных по этому полю
        //Сформировать Джисон объект
        //и в текстовом виде отправить его
        out.println(js);
        out.flush();

    }


    @RequestMapping(path="/post")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws  SQLException {
        DatabaseConnection.createConnect();
        /*if (request.getParameter("nameCompany") != null || request.getParameter("isSeller") != null ||
                request.getParameter("isCustomer") != null || request.getParameter("FCsGenDirector") != null ||
                request.getParameter("email") != null || request.getParameter("phoneNumber") != null ||
                request.getParameter("legalAddress") != null || request.getParameter("INN") != null ||
                request.getParameter("OGRN") != null || request.getParameter("KPP") != null || request.getParameter("password") != null) {
            if (!request.getParameter("nameCompany").equals("") && !request.getParameter("isSeller").equals("") &&
                    !request.getParameter("isCustomer").equals("") && !request.getParameter("FCsGenDirector").equals("") &&
                    !request.getParameter("email").equals("") && !request.getParameter("phoneNumber").equals("") &&
                    !request.getParameter("legalAddress").equals("") && !request.getParameter("INN").equals("") &&
                    !request.getParameter("OGRN").equals("") && !request.getParameter("password").equals("") && !request.getParameter("KPP").equals("")) {
                JSONObject jsonobject = new JSONObject() {
                };*/

                    if(request!=null) {
                        JSONObject jsonobject = new JSONObject();

                try {
                    jsonobject.put(UserRegistrationFields.nameCompany.name(), request.getParameter("nameCompany"));
                    jsonobject.put(UserRegistrationFields.isCustomer.name(), request.getParameter("isCustomer"));
                    jsonobject.put(UserRegistrationFields.isSeller.name(), request.getParameter("isSeller"));
                    jsonobject.put(UserRegistrationFields.INN.name(), request.getParameter("INN"));
                    jsonobject.put(UserRegistrationFields.OGRN.name(), request.getParameter("OGRN"));
                    jsonobject.put(UserRegistrationFields.FCsGenDirector.name(), request.getParameter("FCsGenDirector"));
                    jsonobject.put(UserRegistrationFields.email.name(), request.getParameter("email"));
                    jsonobject.put(UserRegistrationFields.legalAddress.name(), request.getParameter("legalAddress"));
                    jsonobject.put(UserRegistrationFields.KPP.name(), request.getParameter("KPP"));
                    jsonobject.put(UserRegistrationFields.phoneNumber.name(), request.getParameter("phoneNumber"));
                    jsonobject.put(UserRegistrationFields.password.name(), request.getParameter("password"));
                    jsonobject.put(UserRegistrationFields.dateOfRegistration.name(),  request.getParameter("dateOfRegistration"));
                    UserRegistration userRegistration = new UserRegistration(jsonobject);

                    if (userRegistration.getRequestLogs().get(0)=="200"){
                        PrintWriter out = response.getWriter();
                        out.println("200");
                        out.flush();
                    }else {
                        PrintWriter out = response.getWriter();
                        out.println("");
                        out.flush();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
