/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.toavina.tpCustomer.jsf;

import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
import mg.itu.toavina.tpCustomer.entity.Customer;
import mg.itu.toavina.tpCustomer.entity.Discount;
import mg.itu.toavina.tpCustomer.service.CustomerManager;
import mg.itu.toavina.tpCustomer.service.DiscountManager;

/**
 * Backing bean pour la page customerDetails.xhtml.
 *
 * @author toavi
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;

    @Inject
    private DiscountManager discountManager;

    public List<Discount> getDiscounts() {
        return discountManager.getAllDiscounts();
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }
}
