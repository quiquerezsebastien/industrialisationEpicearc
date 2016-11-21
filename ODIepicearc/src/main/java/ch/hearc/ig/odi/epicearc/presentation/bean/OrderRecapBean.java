/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.bean;

import ch.hearc.ig.odi.epicearc.business.Customer;
import ch.hearc.ig.odi.epicearc.business.Order;
import ch.hearc.ig.odi.epicearc.exception.IncorrectStateException;
import ch.hearc.ig.odi.epicearc.service.Services;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "orderRecapBean")
@SessionScoped
public class OrderRecapBean implements Serializable {

    private Order order;

    @Inject
    OrderCreateBean orderBean;
    @Inject
    CustomerCreateBean customerBean;
    @Inject
    Services service;

    /**
     * Creates a new instance of OrderRecapBean
     */
    public OrderRecapBean() {
    }

    /**
     * Permet de retourner l'instance du bean OrderCreateBean
     * 
     * @return L'instane du bean OrderCreateBean
     * 
     */
    public OrderCreateBean getOrderBean() {
        return orderBean;
    }

    /**
     * Attribuer l'instance du bean OrderCreateBean
     *
     * @param orderBean Instance du bean OrderCreateBean
     */
    public void setOrderBean(OrderCreateBean orderBean) {
        this.orderBean = orderBean;
    }

    /**
     * Permet de retourner l'instance du bean CustomerCreateBean
     * 
     * @return L'instane du bean CustomerCreateBean
     * 
     */
    public CustomerCreateBean getCustomerBean() {
        return customerBean;
    }

    /**
     * Attribuer l'instance du bean CustomerCreateBean
     *
     * @param customerBean Instance du bean CustomerCreateBean
     */
   
    public void setCustomerBean(CustomerCreateBean customerBean) {
        this.customerBean = customerBean;
    }

    /**
     * Permet de retourner l'instance de la classe Services
     * 
     * @return L'instane de la classe Services
     * 
     */
    public Services getService() {
        return service;
    }

    /**
     * Attribuer l'instance de la classe Services
     *
     * @param service Instance de la classe Services
     */
    public void setService(Services service) {
        this.service = service;
    }

    /**
     * Permet de sauvergader la commande dans la classe Service qui simule
     * la base de données et retourne la page sur laquelle il doit se diriger
     * 
     * @return La prochaine page sur laquelle il doit se diriger 
     * @throws IncorrectStateException
     */
    public String saveOrder() throws IncorrectStateException {       
        order = new Order(null, new Date(), orderBean.getPrice(), orderBean.getDeliveryDateToBook(), orderBean.getReturnDateToBook(), orderBean.getProductToBook(),customerBean.getCustomer());
        service.saveOrder(order);
        orderBean.setIdCustomer(customerBean.getCustomer().getId());
        return "orderValidate.xhtml";
    }

    /*
     * Permet de retourner la commande pour être utilisé par la suite pour
     * exporter les données sur PDF
     * 
     * @return La commande
     */
    public Order getOrder() {
        return order;
    }


}
