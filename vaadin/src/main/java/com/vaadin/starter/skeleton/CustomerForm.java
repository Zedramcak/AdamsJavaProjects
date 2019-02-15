package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.starter.skeleton.backend.Customer;
import com.vaadin.starter.skeleton.backend.CustomerService;
import com.vaadin.starter.skeleton.backend.CustomerStatus;

import java.util.Locale;

public class CustomerForm extends FormLayout {
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private ComboBox<CustomerStatus> status = new ComboBox<>("Status");
    private DatePicker birthDate = new DatePicker("Birthday");

    private CustomerService service = CustomerService.getInstance();
    private Customer customer;
    private MainView mainView;

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<Customer> binder = new Binder<>(Customer.class);

    public CustomerForm(MainView mainView) {
        this.mainView = mainView;

        status.setItems(CustomerStatus.values());

        binder.bindInstanceFields(this);

        save.addClickListener(e -> this.save());
        delete.addClickListener(e -> this.delete());

        HorizontalLayout buttons = new HorizontalLayout(save, delete);


        birthDate.setLocale(Locale.UK);
        add(firstName, lastName, status, birthDate, buttons);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        setCustomer(null);
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
        binder.setBean(customer);
        boolean enable = customer != null;
        setVisible(enable);
        if (enable){
            firstName.focus();
        }
    }

    private void delete(){
        service.delete(customer);
        mainView.updateList();
        setCustomer(null);
    }

    private void save(){
        service.save(customer);
        mainView.updateList();
        setCustomer(null);
    }
}
