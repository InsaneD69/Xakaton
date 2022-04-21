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
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@RestController
public class HttpController {



    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }





    @RequestMapping(path="/post1")
    public String doPostSaleOffers(HttpServletRequest request, HttpServletResponse response) throws  SQLException {
        DatabaseConnection.createConnect();

        JSONObject jsonobject = new JSONObject();

        try {
            jsonobject.put(SaleOffersFiels.productName.name(), request.getParameter("productName"));
            jsonobject.put(SaleOffersFiels.quantity.name(), request.getParameter("quantity"));
            jsonobject.put(SaleOffersFiels.nameCompany.name(), request.getParameter("nameCompany"));
            jsonobject.put(SaleOffersFiels.deliveryCost.name(), request.getParameter("deliveryCost"));
            jsonobject.put(SaleOffersFiels.comment.name(), request.getParameter("comment"));
            AddPlacement addPlacement = new AddPlacement(jsonobject);
            if (addPlacement.getRequestLogs().get(0)=="200"){
                return "200";
            }else {
                String error="";
                for (int i=0;i<addPlacement.getRequestLogs().size();i++){
                    error+=addPlacement.getRequestLogs().get(i)+" ";
                }
                return error;
            }
        } catch (JSONException e) {
            return "400";
        } catch (SQLException e) {
            return "400";
        }

    }


    @RequestMapping(path="/post2")
    public String doPostUserRegistration(HttpServletRequest request, HttpServletResponse response) throws  SQLException {
        DatabaseConnection.createConnect();
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
            jsonobject.put(UserRegistrationFields.dateOfRegistration.name(), request.getParameter("dateOfRegistration"));
            UserRegistration userRegistration = new UserRegistration(jsonobject);
            if (userRegistration.getRequestLogs().get(0)=="200"){
                return "200";
            }else {
                String error="";
                for (int i=0;i<userRegistration.getRequestLogs().size();i++){
                    error+=userRegistration.getRequestLogs().get(i)+" ";
                }
                return error;
            }
        } catch (JSONException e) {
            return "400";
        } catch (SQLException e) {
            return "400";

        }

    }
}
