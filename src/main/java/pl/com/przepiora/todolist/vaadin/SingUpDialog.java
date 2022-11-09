package pl.com.przepiora.todolist.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import lombok.extern.slf4j.Slf4j;
import pl.com.przepiora.todolist.model.User;
import pl.com.przepiora.todolist.repository.UserRepository;

@Slf4j
public class SingUpDialog extends Dialog {
    private UserRepository userRepository;
    EmailField emailField = new EmailField("Email address");
    PasswordField passwordField = new PasswordField("Password");
    TextField nameField = new TextField("Name");
    TextField surnameField = new TextField("Surname");
    Button saveButton = new Button("Save");
    Button cancelButton = new Button("Cancel");

    public SingUpDialog(UserRepository userRepository) {
        this.userRepository = userRepository;
        log.debug("Sing up dialog - new instance");

        H3 title = new H3("Register new user");
        HorizontalLayout level1 = new HorizontalLayout(title);



        HorizontalLayout level2 = new HorizontalLayout(emailField, passwordField);



        HorizontalLayout level3 = new HorizontalLayout(nameField, surnameField);



        HorizontalLayout footer = new HorizontalLayout(saveButton, cancelButton);

        VerticalLayout main = new VerticalLayout(level1, level2, level3, footer);
        main.setAlignItems(FlexComponent.Alignment.CENTER);
        add(main);



        cancelButton.addClickListener(e -> this.close());
        saveButton.addClickListener(e-> saveUser());
    }

    private User saveUser() {
        String email = emailField.getValue();
        String password = passwordField.getValue();
        String name = nameField.getValue();
        String surname = surnameField.getValue();

        User user = User.builder().username(email).password(password).name(name).surname(surname).build();
        User savedUser = userRepository.save(user);
        this.close();
        return savedUser;
    }
}