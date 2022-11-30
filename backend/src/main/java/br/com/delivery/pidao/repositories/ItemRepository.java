package br.com.delivery.pidao.repositories;

import br.com.delivery.pidao.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByNameAndDescriptionAndCategoryUuid(String name, String description, UUID uuid);

    Optional<Item> findByItemIdentifier(String itemIdentifier);

    List<Item> findByCategoryUuid(UUID uuid);
}
