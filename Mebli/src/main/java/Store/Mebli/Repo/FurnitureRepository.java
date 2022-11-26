package Store.Mebli.Repo;

import Store.Mebli.models.Furniture;
import org.springframework.data.repository.CrudRepository;

public interface FurnitureRepository extends CrudRepository<Furniture, Long> {
}
