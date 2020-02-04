package ourbusinessproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Project {



    @Id
    @GeneratedValue
    private long id;

    @NotNull @NotBlank
    private String title;
    private String description;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
//test
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
