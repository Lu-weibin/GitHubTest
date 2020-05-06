package demo.dao;

import demo.lambda.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by luwb on 2019/12/04.
 * Article数据访问层
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String>{

	Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
