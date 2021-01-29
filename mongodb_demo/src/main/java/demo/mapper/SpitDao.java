package demo.mapper;

import demo.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by luwb on 2019/12/02.
 * 数据访问层
 */
public interface SpitDao extends MongoRepository<Spit,String> {
	Page<Spit> findByParentid(String parentid, Pageable pageable);
}
