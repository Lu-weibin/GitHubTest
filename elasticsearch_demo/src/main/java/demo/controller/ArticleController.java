package demo.controller;

import demo.dao.ArticleSearchDao;
import demo.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * Created by luwb on 2019/12/04.
 * Article控制器
 */
@RestController
@RequestMapping("article")
public class ArticleController {

	private final ArticleSearchDao articleSearchDao;

	public ArticleController(ArticleSearchDao articleSearchDao) {
		this.articleSearchDao = articleSearchDao;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Article article) {
		articleSearchDao.save(article);
	}

	@GetMapping("save")
	public Article save() {
		Article article = new Article();
		article.setId(UUID.randomUUID().toString());
		article.setTitle("测试数据");
		article.setContent("Elasticsearch是一个实时的分布式搜索和分析引擎。它可以帮助你用前所未有的速\n" +
				"度去处理大规模数据。ElasticSearch是一个基于Lucene的搜索服务器。它提供了一个分\n" +
				"布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发\n" +
				"的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用\n" +
				"于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。");
		article.setState("1");
		return articleSearchDao.save(article);
	}

	@RequestMapping("search/{keyWord}/{page}/{size}")
	public Page<Article> findByTitleOrContentLike(@PathVariable String keyWord, @PathVariable int page, @PathVariable int size) {
		Pageable pageRequest = PageRequest.of(page-1, size);
		return articleSearchDao.findByTitleOrContentLike(keyWord, keyWord, pageRequest);
	}

	@RequestMapping("list")
	public Iterable findAll() {
		return articleSearchDao.findAll();
	}
}
