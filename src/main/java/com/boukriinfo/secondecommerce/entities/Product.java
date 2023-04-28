package com.boukriinfo.secondecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data @ToString @Builder
public class Product implements Serializable {
    @Id
    private Long id;
    @NotEmpty
    @Size(min = 4,max = 50)
    private String name;
    @NotEmpty
    private String description;
    @NotNull(message = "Le champ 'price' ne peut pas être nul.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le champ 'price' doit être un nombre positif.")
    private double price;
    @NotEmpty
    private String slug;
    private String image;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    private boolean deleted;

    @ManyToOne
    private Category category;


    public boolean getDeleted() {
        return deleted;
    }






}
