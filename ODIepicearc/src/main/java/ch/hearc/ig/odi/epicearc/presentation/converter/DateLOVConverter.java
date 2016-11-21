/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.converter;

import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.service.Services;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 * Convertisseur des dates
 */
@Named(value = "dateLOVConverter")
@Dependent
public class DateLOVConverter implements Converter{
    
    @Inject Services service;
    
    /**
     * Converti une chaine de caractère données en objet date.
     * @return Objet
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            return null;
        }
    }
    
    /**
     * Converti un objet date en chaine de caractère
     * @return Chaine de caractère
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof DeliveryDate) {
            return ((DeliveryDate) value).getFormatedDate();
        } else {
            return "";
        }
    }
    
}
