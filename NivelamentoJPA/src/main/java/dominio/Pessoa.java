package dominio;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String Nome;
    private String email;


    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        Nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
