package ourbusinessproject;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
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
    @ManyToOne(cascade= CascadeType.ALL) @NotNull
    private Enterprise entreprise;

    public Project(Enterprise enterprise) {
        this.entreprise = enterprise;
        if (enterprise != null) {
            this.entreprise.addProject(this);
        }

    }

    public Project() {

    }

    public Enterprise getEnterprise() {
        return entreprise;
    }

    public void setEnterprise(Enterprise entreprise) {
        this.entreprise = entreprise;
        if (entreprise != null) {
            this.entreprise.addProject(this);
        }
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