/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.bean;

import ch.hearc.ig.odi.epicearc.business.ConiferType;
import ch.hearc.ig.odi.epicearc.business.DeliveryDate;
import ch.hearc.ig.odi.epicearc.business.PickupDate;
import ch.hearc.ig.odi.epicearc.business.Product;
import ch.hearc.ig.odi.epicearc.service.Services;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "orderCreateBean")
@SessionScoped

public class OrderCreateBean implements Serializable{

    @Inject Services service;
    
    private ConiferType coniferToBook;
    private Product productToBook;
    private List<Product> listProduct;
    private DeliveryDate deliveryDateToBook;
    private List<DeliveryDate> listDeliveryDate;
    private PickupDate returnDateToBook;
    private List<PickupDate> listReturnDate;
    private Float price;
    private Long idCustomer;
    /**
     * Creates a new instance of OrderCreateBean
     */
    public OrderCreateBean() {
    }
    
    /**
     * Retourne le type de connifer à réserver
     * @return Le type de conifer réservé
     */
    public ConiferType getConiferToBook() {
        return coniferToBook;
    }
    
    /**
     * Modifier le conifer à réserver
     * @param coniferToBook Le conifer à modifier
     */
    public void setConiferToBook(ConiferType coniferToBook) {
        this.coniferToBook = coniferToBook;
    }
    
    /**
     * Retourne les services disponibles
     * @return services disponibles
     */
    public Services getService() {
        return service;
    }
    
    /**
     * Retourne les produits à réserver
     * @return Le produit à réserver
     */
    public Product getProductToBook() {
        return productToBook;
    }
    
    /**
     * Changer le produit à réserver
     * @param productToBook Produit à réserver
     */
    public void setProductToBook(Product productToBook) {
        this.productToBook = productToBook;
    }
    
    /**
     * Retourne la liste de tous les produits
     * @return Liste des produits
     */
    public List<Product> getListProduct() {
        return listProduct;
    }
    
    /**
     * Retourne la date de livraison choisie
     * @return Date de livraison
     */
    public DeliveryDate getDeliveryDateToBook() {
        return deliveryDateToBook;
    }
    
    /**
     * Permet de changer la date de livraison
     * @param deliveryDateToBook Date de livraison
     */
    public void setDeliveryDateToBook(DeliveryDate deliveryDateToBook) {
        this.deliveryDateToBook = deliveryDateToBook;
    }

    /**
     * Retourne la liste des dates de livraison disponibles
     * @return Liste des dates de livraison disponibles
     */
    public List<DeliveryDate> getListDeliveryDate() {
        return listDeliveryDate;
    }

    /**
     * Retourne la date de retour choisie
     * @return Date de retour choisie
     */
    public PickupDate getReturnDateToBook() {
        return returnDateToBook;
    }
    
    /**
     * Changer la date de retour
     * @param returnDateToBook Date de retour
     */
    public void setReturnDateToBook(PickupDate returnDateToBook) {
        this.returnDateToBook = returnDateToBook;
    }
    
    /**
     * Retourne la liste des dates de retour disponibles
     * @return La listes des dates de retour disponibles
     */
    public List<PickupDate> getListReturnDate() {
        return listReturnDate;
    }

    /**
     * Retourne le prix du produit séléctionné
     * @return Le prix
     */
    public Float getPrice() {
        return price;
    }

    /**
     * Permet d'attribuer le prix de l'arbre
     * @param price Prix
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * Retourne l'id de l'utilisateur qui passe la commande
     * @return L'id de l'utilisateur 
     */
    public Long getIdCustomer() {
        return idCustomer;
    }

    /**
     * Permet d'attribuer l'id de l'utilisateur qui passe la commande
     * @param idCustomer id de l'utilisateur
     */
    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }
    
    /**
     * Mise à jour de la liste des produits disponibles selon un type de conifer
     * choisi.
     * @param event 
     */
    public void updateSizeList(AjaxBehaviorEvent event){
        listProduct = service.getProductsForConiferType(ConiferType.valueOf(coniferToBook.getCode().toUpperCase()));
        productToBook = null;
    }
    
    /**
     * Mise à jour de la liste des dates de livraison disponibles selon un produit
     * choisi
     * @param event 
     */
    public void updateDeliveryDateList(AjaxBehaviorEvent event){
        listDeliveryDate = service.getDeliveryDatesForProduct(productToBook);
        deliveryDateToBook = null;
    }
    
    /**
     * Mise à jour de la liste des dates de retour disponibles selon un produit
     * choisi
     * @param event
     */
    public void updateReturnDateList(AjaxBehaviorEvent event){
        listReturnDate = service.getPickupDatesForProduct(productToBook);
        returnDateToBook = null;
    }
    
    /**
     * Permet de calculer le prix total de la commande et retourne la page sur
     * laquelle il doit se diriger
     * @return La prochaine page sur laquelle il doit se diriger 
     */
    public String calculatePrice(){
        price = productToBook.getPrice() + service.getTransportCosts();
        
        if (idCustomer != null) {
            return"orderRecap.xhtml";
        }
        return"personalData.xhtml";
    }
    
    /**
     * Permet de ré initialiser le bean et d'effacer les valeurs en session
     *
     */
    public void initBean(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
