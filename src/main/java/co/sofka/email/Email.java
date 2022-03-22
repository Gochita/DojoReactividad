package co.sofka.email;

public class Email {
    private String email;
    private String estado;

    public Email(String email, String estado) {
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
}
