package com.example.application.views.main;

import com.example.application.controller.MainController;
import com.example.application.entity.Person;
import com.example.application.repository.PersonRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@PageTitle("Main")
@Route(value = "")
public class MainView extends HorizontalLayout {

    private TextField firstName;
    private TextField lastName;

    private Button submit;

    private VerticalLayout nameContainer;

    private MainController mainController;

    public MainView() {
        init();
        addComponents();
    }

    private void init() {
        mainController = new MainController();
        firstName = new TextField("Vorname");
        lastName = new TextField("Nachname");
        submit = new Button("Submit");
        submit.addClickListener(click -> {
            Person p = new Person();
            p.setFirstName(firstName.getValue());
            p.setLastName(lastName.getValue());
            mainController.save(p);
        });
        nameContainer = new VerticalLayout();
    }

    private void addComponents() {
        this.removeAll();
        nameContainer.removeAll();
        mainController.getAllPerson().forEach(person -> {
            Label label = new Label(person.getId() + ": " + person.getFirstName() + " " + person.getLastName());
            nameContainer.add(label);
        });
        this.add(firstName, lastName, nameContainer);
    }
}
