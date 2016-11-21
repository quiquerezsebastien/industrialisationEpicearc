/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.converter;

import ch.hearc.ig.odi.epicearc.presentation.bean.OrderCreateBean;
import ch.hearc.ig.odi.epicearc.business.Product;
import ch.hearc.ig.odi.epicearc.service.Services;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 * Convertisseur des taille de conifer
 */
@Named(value = "sizeLOVConverter")
@RequestScoped
public class SizeLOVConverter implements Converter {

    @Inject
    Services service;
    @Inject
    OrderCreateBean orderBean;

    /**
     * Creates a new instance of SizeLOVConverter
     */
    public SizeLOVConverter() {
    }

    /**
     * Converti une chaine de caractère données en objet produit.
     * @return Objet
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            Product product = null;
            for (Product currentProduct : service.getProductsForConiferType(orderBean.getConiferToBook())) {
                if (currentProduct.getId().toString().equals(value)) {
                    product = currentProduct;
                }
            }
            return product;
        }
    }
    
    /**
     * Converti un objet produit en chaine de caractère
     * @return Chaine de caractère
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof Product) {
            return ((Product) value).getId().toString();
        } else {
            return "";
        }
    }

}
