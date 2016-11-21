/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.epicearc.presentation.bean;

import ch.hearc.ig.odi.epicearc.business.Order;
import ch.hearc.ig.odi.epicearc.service.Services;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;

/**
 *
 * @author sebastie.quiquere
 */
@Named(value = "orderValidateBean")
@SessionScoped
public class OrderValidateBean implements Serializable {

    @Inject
    OrderRecapBean orderRecapBean;
    @Inject
    OrderCreateBean orderBean;
    @Inject
    CustomerCreateBean customerBean;
    @Inject
    Services service;

    /**
     * Creates a new instance of orderValidateBean
     */
    public OrderValidateBean() {
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
     * Permet de ré initialiser le bean et d'effacer les valeurs en session en
     * appellant les méthodes crées.
     * @return La page sur laquelle il doit se dirgier 
     */
    public String initbean() {
        orderBean.initBean();
        customerBean.initBean();
        return "home.xhtml";
    }

    /**
     * Permet de mettre la commande dans un tableau pour peupler la DataList qui 
     * permettra d'exporter les données sur le PDF
     * 
     * @return Une liste des commande pour peupler la dataList
     */
    public List<Order> getOrders() {
        ArrayList orders = new ArrayList();
        orders.add(orderRecapBean.getOrder());
        return orders;
    }

    /**
     * Permet de créer le texte à afficher dans le pdf avant les données du tableau
     *
     * @param document document pdf
     * 
     * @throws IOException
     * @throws BadElementException
     * @throws DocumentException
     */
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        // Récupère le chemin du logo et de la police
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "logo.jpg";
        String fontPath = servletContext.getRealPath("") + "/resources/fonts/FreeSans.ttf";

        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        pdf.addTitle("Bulletin de commande");
        Font font = FontFactory.getFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        pdf.add(Image.getInstance(logo));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bulletin de commande");
        stringBuilder.append("\nEpicé'Arc");
        stringBuilder.append("\n");
        stringBuilder.append("\nInformations personnelles : ");
        stringBuilder.append("\n");
        stringBuilder.append(customerBean.getCustomer().getFirstName());
        stringBuilder.append(" ");
        stringBuilder.append(customerBean.getCustomer().getLastName());
        stringBuilder.append("\n");
        stringBuilder.append(customerBean.getCustomer().getAddress());
        stringBuilder.append("\n");
        stringBuilder.append(customerBean.getCustomer().getZip());
        stringBuilder.append(" - ");
        stringBuilder.append(customerBean.getCustomer().getCity());
        stringBuilder.append("\n");
        stringBuilder.append(customerBean.getCustomer().getPhone());
        stringBuilder.append("\n");
        stringBuilder.append(customerBean.getCustomer().getEmail());
        stringBuilder.append("\n");

        Paragraph paragraph = new Paragraph(stringBuilder.toString(), font);

        // Ajoute le paragraphe au pdf        
        pdf.add(paragraph);
        pdf.addHeader(String.valueOf(pdf.getPageNumber()), String.valueOf(pdf.getPageNumber()));

    }

    /**
     * Permet de créer le texte à afficher dans le pdf avant les données du tableau
     *
     * @param document document pdf
     * 
     * @throws IOException
     * @throws BadElementException
     * @throws DocumentException
     */
    public void postProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        // Récupère le chemin du logo et de la police
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "logo.jpg";
        String fontPath = servletContext.getRealPath("") + "/resources/fonts/FreeSans.ttf";

        Document pdf = (Document) document;

        Font font = FontFactory.getFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nPrix de l'arbre : ");
        stringBuilder.append(orderBean.getProductToBook().getPrice());
        stringBuilder.append(" CHF\nPrix du transport : ");
        stringBuilder.append(service.getTransportCosts());
        stringBuilder.append(" CHF\nTotal : ");
        stringBuilder.append(orderBean.getPrice());
        stringBuilder.append(" CHF");

        Paragraph paragraph = new Paragraph(stringBuilder.toString(), font);

        // Ajoute le paragraphe au pdf        
        pdf.add(paragraph);
        pdf.addHeader(String.valueOf(pdf.getPageNumber()), String.valueOf(pdf.getPageNumber()));

    }
}
