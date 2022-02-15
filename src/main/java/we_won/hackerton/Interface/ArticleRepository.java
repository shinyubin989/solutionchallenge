package we_won.hackerton.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import we_won.hackerton.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
    //List<Article> findAll();
}
