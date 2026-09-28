package com.ga.Todo.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String emailAddress;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id" , referencedColumnName = "id")
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private List<Item> itemList;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
    private List<Category> categoryList;

    @JsonIgnore
    public String getPassword(){
        return password;
    }

}
