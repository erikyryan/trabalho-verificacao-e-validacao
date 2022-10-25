package br.com.delivery.pidao.services;

import br.com.delivery.pidao.entities.Menu;
import br.com.delivery.pidao.entities.Restaurant;
import br.com.delivery.pidao.exceptions.MenuNotFound;
import br.com.delivery.pidao.exceptions.RestaurantNotFound;
import br.com.delivery.pidao.repositories.MenuRepository;
import br.com.delivery.pidao.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuService {

    private MenuRepository menuRepository;

    private RestaurantRepository restaurantRepository;

    public Menu getMenu(String menuIdentifier){
        Optional<Menu> menu = menuRepository.findByMenuIdentifier(menuIdentifier);
        if(menu.isPresent()){
            return menu.get();
        }
        throw new MenuNotFound("Menu não encontrado");
    }

    public Restaurant getRestaurantFromIdentifier(String menuIdentifier){
        Optional<Menu> menu = menuRepository.findByMenuIdentifier(menuIdentifier);
        if(menu.isPresent()){
            Optional<Restaurant> restaurant = restaurantRepository.findByRestaurantIdentifier(menu.get().getRestaurantIdentifier());
            if(restaurant.isPresent()) {
                return restaurant.get();
            }

            throw new RestaurantNotFound("Restaurante não encontrado");
        }
        throw new MenuNotFound("Menu não encontrado");
    }

}
