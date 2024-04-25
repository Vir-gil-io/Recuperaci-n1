package mx.utng.ultima.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class ListaDeseosDecoracion{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 30)
    private String nombreLista;

    @NotEmpty
    @Column(length = 30)
    private String elementosDecorativos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public String getElementosDecorativos() {
        return elementosDecorativos;
    }

    public void setElementosDecorativos(String elementosDecorativos) {
        this.elementosDecorativos = elementosDecorativos;
    }

        
    
    
}
