package ourbusinessproject;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Entity
public class Enterprise {


    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;
    @NotBlank @Length(min = 10)
    private String description;
    @NotBlank
    private String contactName;
    @NotBlank @Email
    private String contactEmail;
    @OneToMany(cascade= CascadeType.ALL) @NotNull
    private List<Project> projects;



    public Enterprise(){
        this.projects = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @com.fasterxml.jackson.annotation.JsonIgnore
    public Collection<Project> getProjects() {
        if(projects.isEmpty()) {
            return null;
        }else{
            return projects;
        }
    }

    public void addProject(Project aAdd){
        this.projects.add(aAdd);
    }

    @Override
    public String toString() {
        return this.name;
    }
}