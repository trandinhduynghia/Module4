package codegym.vn.repository;

import codegym.vn.bean.Category;
import codegym.vn.bean.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
