package br.com.delivery.pidao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Getter
@Setter
@Entity
public class Manager extends User {

    @Id
    private Long id;

    private String Department;

    @ManyToOne
    private Restaurant RestaurantManager;
}