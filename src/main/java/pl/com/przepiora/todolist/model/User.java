package pl.com.przepiora.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="USER2")
public class User {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private String username;
    private String password;
    private String name;
    private String surname;
}
