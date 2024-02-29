package com.feliqe.springboot.di.factura.springbootdifactura.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//se tiene que declarar @Component para poder usar @Valueo
@Component
//indicando que ya no es compartida por toda la aplicacion, dure la session pero se elimina los proxi para que no se concatenen
@RequestScope
//para ignorar campos espesificos
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Client {

    @Value("${client.name}")
    private String name;

    @Value("${client.lastname}")
    private String lastname;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
