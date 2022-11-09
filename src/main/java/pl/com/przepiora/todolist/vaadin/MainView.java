package pl.com.przepiora.todolist.vaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.com.przepiora.todolist.model.User;
import pl.com.przepiora.todolist.repository.UserRepository;

@Route("/go")
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainView extends HorizontalLayout {
    private UserRepository userRepository;

    public MainView(UserRepository userRepository) {
        this.userRepository = userRepository;

        SingUpDialog singUpDialog = new SingUpDialog(userRepository);

        Button button = new Button("click me");
        User user = User.builder().password("qweqe").username("weqeqew").build();
        button.addClickListener(event -> singUpDialog.open());
        add(button);
    }
}
