package com.feliqe.springboot.di.factura.springbootdifactura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feliqe.springboot.di.factura.springbootdifactura.models.Client;
import com.feliqe.springboot.di.factura.springbootdifactura.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public Invoice show() {
        //para no usar @JsonIgnoreProperties({"targetSource","advisors"}) en los models, se indicara los datos que necesitamos mostrar ignorando el contenido demas del poxi
        // d@JsonIgnoreProperties de los models invoice y client
        Invoice i = new Invoice();
        Client c = new Client();

        //indcamos los campos a mostra
        c.setLastname(invoice.getClient().getLastname());
        c.setName(invoice.getClient().getName());
        i.setClient(c);
        i.setDescription(invoice.getDescription());
        i.setItems(invoice.getItems());

        return i;
    }
}
