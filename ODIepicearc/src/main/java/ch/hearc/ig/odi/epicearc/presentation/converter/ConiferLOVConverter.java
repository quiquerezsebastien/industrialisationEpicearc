/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.converter;

import ch.hearc.ig.odi.epicearc.business.ConiferType;
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
 * 
 * Convertisseurs personnalisés des conifers
 */
@Named(value = "coniferLOVConverter")
@Dependent
public class ConiferLOVConverter implements Converter {

    @Inject Services service;

    /**
     * Creates a new instance of SapinLOVConverter
     */
    public ConiferLOVConverter() {
    }
    
    /**
     * Converti une chaine de caractère données en objet conifer.
     * @return Objet
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null) {
            return null;
        } else {
            ConiferType conifer = null;
            for (ConiferType currentConifer : service.getConiferTypes()) {
                if (currentConifer.getCode().equals(value)) {
                    conifer = currentConifer;
                }
            }
            
            return conifer;
        }
    }
    
    /**
     * 
     * Converti un objet conifer en chaine de caractère
     * @return Chaine de caractère
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof ConiferType) {
            return ((ConiferType) value).getCode();
        } else {
            return "";
        }
    }

}
