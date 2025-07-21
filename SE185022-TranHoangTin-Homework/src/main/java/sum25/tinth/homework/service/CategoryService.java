package sum25.tinth.homework.service;

import sum25.tinth.homework.pojo.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
    Optional<Category> findByCategoryName(String categoryName);
    boolean existsById(Long id);
    boolean existsByCategoryName(String categoryName);
}
