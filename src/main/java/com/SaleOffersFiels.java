package com;

public enum SaleOffersFiels {

    productName("Наименование продукции или услуги"),
    quantity("Количество"),
    nameCompany("Имя компании"),
    deliveryCost("Стоимость, за которую готовы сделать поставку продукции"),
    comment("Комментарий");

    public String ruLocale;

    SaleOffersFiels(String ruLocale){
        this.ruLocale=ruLocale;

    }
}
