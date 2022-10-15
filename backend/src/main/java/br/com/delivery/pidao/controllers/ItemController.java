package br.com.delivery.pidao.controllers;

import br.com.delivery.pidao.dao.UserDAO;
import br.com.delivery.pidao.entities.Manager;
import br.com.delivery.pidao.entities.Restaurant;
import br.com.delivery.pidao.entities.dto.ItemDTO;
import br.com.delivery.pidao.entities.dto.ItemDescriptionDTO;
import br.com.delivery.pidao.entities.dto.UserDTO;
import br.com.delivery.pidao.services.ItemService;
import br.com.delivery.pidao.services.SessionService;
import br.com.delivery.pidao.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    private SessionService sessionService;

    @PostMapping
    public ResponseEntity<?> insertItem(@RequestBody ItemDTO itemDTO,@RequestHeader("token") final String token){
        try{
            sessionService.validateToken(token);
            UserDTO userDTO = sessionService.findUserDTOByToken(token);
            return ResponseEntity.ok(itemService.addItem(itemDTO,userDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody ItemDTO itemDTO, @RequestHeader("token") String token){
        try{
            sessionService.validateToken(token);
            UserDTO userDTO = sessionService.findUserDTOByToken(token);
            return ResponseEntity.ok(itemService.updateItem(itemDTO,userDTO));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{menuIdentifier}")
    public ResponseEntity<?> deleteItem(@PathVariable String menuIdentifier,@RequestHeader("token") final String token, @RequestBody ItemDescriptionDTO itemDescriptionDTO){
        try{
            sessionService.validateToken(token);
            UserDTO userDTO = sessionService.findUserDTOByToken(token);
            return ResponseEntity.ok(itemService.deleteItem(userDTO,itemDescriptionDTO,menuIdentifier));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/public/{menuIdentifier}")
    public ResponseEntity<?> findAllByMenuIdentifier(@PathVariable String menuIdentifier,@RequestHeader("token") final String token){
        try{
            sessionService.validateToken(token);
            return ResponseEntity.ok(itemService.getItensFromMenuIdentifier(menuIdentifier));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/public/{categoryIdentifier}")
    public ResponseEntity<?> findAllByCategoryIdentifier(@PathVariable String categoryIdentifier,@RequestHeader("token") final String token){
        try{
            sessionService.validateToken(token);
            return ResponseEntity.ok(itemService.getItensFromCategoryIdentifier(categoryIdentifier));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{itemIdentifier}")
    public ResponseEntity<?> findItemByIdentifier(@PathVariable String itemIdentifier, @RequestHeader("token") String token){
        try{
            sessionService.validateToken(token);
            return ResponseEntity.ok(itemService.getItemByIdentifier(itemIdentifier));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
