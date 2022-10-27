package br.com.delivery.pidao.entities.dto;

import br.com.delivery.pidao.entities.Menu;

public class MenuDTO {

    private String restaurantIdentifier;

    public Menu menuToEntity() {
        Menu menu = new Menu();
        menu.setRestaurantIdentifier(restaurantIdentifier);
        return menu;
    }

}
