package demo.controller;

import demo.dao.SpitDao;
import demo.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by luwb on 2019/12/03.
 * Spit控制器
 */
@RestController
@RequestMapping("spit")
public class SpitController {
	@Autowired
	private SpitDao spitDao;
	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping("list")
	public List<Spit> list() {
		return spitDao.findAll();
	}

	@RequestMapping("{id}")
	public Spit findOne(@PathVariable String id) {
		Spit spit = mongoTemplate.findById(id, Spit.class);
		System.out.println(spit);
		return spit;
//		return spitDao.findById(id).get();
	}

	@RequestMapping(value = "add",method = RequestMethod.POST)
	public Spit add(Spit spit) {
		spit.set_id(UUID.randomUUID().toString());
		return spitDao.save(spit);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Spit update(@RequestBody Spit spit) {
		return spitDao.save(spit);
	}

	@RequestMapping("delete/{id}")
	public void delete(@PathVariable String id) {
		spitDao.deleteById(id);
	}

	@RequestMapping("findByParentid/{parentid}")
	public Page<Spit> findByParentId(@PathVariable String parentid) {
		Pageable pageRequest = PageRequest.of(0,10);
		return spitDao.findByParentid(parentid, pageRequest);
	}

	@RequestMapping("updateThumbup/{id}")
	public void updateThumbup(@PathVariable String id) {
		long startTime = System.currentTimeMillis();
		Spit spit = spitDao.findById(id).get();
		spit.setThumbup(spit.getThumbup()==null?1:spit.getThumbup()+1);
		spitDao.save(spit);
		System.out.println(System.currentTimeMillis()-startTime);

//		Query query = new Query();
//		query.addCriteria(Criteria.where("_id").is(id));
//		Update update = new Update();
//		update.inc("thumbup", 1);
//		mongoTemplate.updateFirst(query, update, "spit");
//		System.out.println(System.currentTimeMillis()-startTime);

	}
}
