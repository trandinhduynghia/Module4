package codegym.vn.repository;

import codegym.vn.bean.Music;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends PagingAndSortingRepository<Music, Long> {
}
