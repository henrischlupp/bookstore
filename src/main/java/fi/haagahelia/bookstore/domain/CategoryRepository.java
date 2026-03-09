package fi.haagahelia.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    /**Jos halutaan automaatti joka hakee esim kategorian nimellä niin kirjotan tämän 
     */
    List<Category> findByCategoryName(String categoryName);

}