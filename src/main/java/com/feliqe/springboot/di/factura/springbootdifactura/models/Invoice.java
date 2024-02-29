package com.feliqe.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//se tiene que declarar @Component para poder usar @Value
@Component
// indicando que es un poxi y no esta compartido por toda la aplicacion
@RequestScope
//ignorar los atributos y propiedades del json que esten asociado al proxi
//para ignorar campos espesificos
// @JsonIgnoreProperties({"targetSource","advisors"})
public class Invoice {

    //@Autowired - importamos el clientes
    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;

    @Autowired
    private List<Item> items;

    // @PostConstruct - enves de crear un contructor vacio, se usa para no intanciar
    // sirve para manipular los campos que estan instanciados
    @PostConstruct
    public void init() {
        System.err.println("Crear el componente de factura");
        //cambiar nombre de los campos
        client.setName(client.getName().concat(" Silva "));
        //sumamos campo a la descripcion
        description = description.concat(" del cliente: ").concat(client.getName()).concat(client.getLastname());
    }

    // @PreDestroy - antes de destruir el componente (@Component) Invoice
    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente o bean de invoice!!");
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    // mostrar el total de la factura
    public int getTotal(){
        // int total = 0;
        // //por cada item ir sumando
        // for(Item item : items){
        //     total += item.getImporte();
        // }
        // return total;

        //forma de programacion funcional
        //en sum se va guardando por cada interacion
        return items.stream().map(item -> item.getImporte()).reduce(0, (sum, importe) -> sum + importe);
    }

}
