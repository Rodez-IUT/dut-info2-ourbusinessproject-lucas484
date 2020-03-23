package ourbusinessproject;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Project {



    @Id
    @GeneratedValue
    private long id;

    @NotNull @NotBlank //@NotNull + @NotBlank = @NotEmpty
    private String title;
    private String description;
    @NotNull @ManyToOne
    private Enterprise entreprise;

    public Enterprise getEnterprise() {
        return entreprise;
    }

    public void setEnterprise(Enterprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return  description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}