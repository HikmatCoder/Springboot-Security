package uz.seciurity.seciurity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, name = "first_name")
    private String FirstName;

    @Column(nullable = false, name = "last_name")
    private String LaststName;


    @Size(max = 30, min = 4)
    @NotNull
    @Column(unique = true, nullable = false)
    private String login;

    @Size(max = 60, min = 60)
    @NotNull
    @Column(unique = true, nullable = false)
    private String password;

    private boolean active;


    @ElementCollection(targetClass = Lavozim.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_lavozim",
            joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "lavozim_id")
    private Set<Lavozim> lavozims;

    public Set<Lavozim> getLavozims() {
        return lavozims;
    }

    public void setLavozims(Set<Lavozim> lavozims) {
        this.lavozims = lavozims;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLaststName() {
        return LaststName;
    }

    public void setLaststName(String laststName) {
        LaststName = laststName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
