package com.feliqe.springboot.di.factura.springbootdifactura;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.feliqe.springboot.di.factura.springbootdifactura.models.Item;
import com.feliqe.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
//data.properties - para asociar los datos de data
//encoding="UTF-8" - para que os hacentos no tengas problema al aparecer
@PropertySource(value="classpath:data.properties", encoding="UTF-8")
public class AppConfig {

    @Primary
    @Bean
    //lo que devuelva este metodo se guardara como metodo de spring
    List<Item> itemsInvoice(){
        //llamado en una linea los campos por el contructor de models
        //le damos el valor a los atributos
        Product p1 = new Product("Camara Sony", 800);
        Product p2 = new Product("Bicicleta Bienachi 26", 1200);
        //listamos la data e indicamos la cantidad a mostrar
        return Arrays.asList(new Item(p1,2), new Item(p2,4));
    }

    @Bean
    List<Item> itemsInvoiceOffice(){
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
    }
}
