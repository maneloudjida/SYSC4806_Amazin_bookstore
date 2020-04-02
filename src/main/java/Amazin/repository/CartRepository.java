package Amazin.repository;

import Amazin.entity.Cart;
import Amazin.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Cart", path = "carts")
public interface CartRepository extends CrudRepository<Cart, Integer>{
}
