package br.com.delivery.pidao.entities;


import br.com.delivery.pidao.entities.dto.ItemDTO;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@IdClass(Item.class)
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String itemIdentifier = UUID.randomUUID().toString();

    @Id
    @NotNull
    private String name;

//    @Nullable
//    @OneToMany
//    private List<Rating> ratings;

    @NotNull
    private Double value;

    @Nullable
    private String description;

    @Id
    @NotNull
    @ManyToOne
    @JoinColumn(name="category", referencedColumnName = "details")
    private Category category;

    public ItemDTO entityToDTO(){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setValue(value);
        itemDTO.setDescription(description);
        itemDTO.setName(name);
        itemDTO.setCategoryDetails(category.getDetails());
        return itemDTO;
    }

}
