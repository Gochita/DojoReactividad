package co.sofka.email;

import java.util.Objects;

public class Email {
    private Integer id;
    private String email;
    private String estado;

    public Email(Integer id, String email, String estado) {
        this.id = id;
        this.email = email;
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return email.equals(email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
