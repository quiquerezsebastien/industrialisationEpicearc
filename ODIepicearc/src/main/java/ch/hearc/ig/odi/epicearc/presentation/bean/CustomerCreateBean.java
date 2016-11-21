/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.bean;

import ch.hearc.ig.odi.epicearc.business.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Bean lié à la page informationsPersonnelles.xhtml, qui permet de saisir les
 * informations personnelles d'une personne qui souhaite commander un sapin.
 *
 * @author sergio.dasilvad
 */
@Named(value = "customerCreateBean")
@SessionScoped

public class CustomerCreateBean implements Serializable {

    private Customer customer;
    

    /**
     * Constructeur qui crée un nouvelle utilisateur pour être instancier
     *
     */
    public CustomerCreateBean() {
        this.customer = new Customer();
    }

    /**
     * Retourne la personne qui passe une commande
     *
     * @return L'utilisateur (customer)
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Attribuer la personne qui passe la commande au bean
     *
     * @param customer Utilisateur (customer)
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Permet de ré initialiser le bean et d'effacer les valeurs en session
     *
     */
    public void initBean(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
}
