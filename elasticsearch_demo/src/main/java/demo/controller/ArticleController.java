package demo.controller;

import demo.dao.ArticleSearchDao;
import demo.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luwb on 2019/12/04.
 * Article控制器
 */
@RestController
@RequestMapping("article")
public class ArticleController {
	@Autowired
	private ArticleSearchDao articleSearchDao;

	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Article article) {
		articleSearchDao.save(article);
	}

	@RequestMapping("search/{keyWord}/{page}/{size}")
	public Page<Article> findByTitleOrContentLike(@PathVariable String keyWord, @PathVariable int page, @PathVariable int size) {
		Pageable pageRequest = PageRequest.of(page-1, size);
		return articleSearchDao.findByTitleOrContentLike(keyWord, keyWord, pageRequest);
	}
}
