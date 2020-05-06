package demo.lambda.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import java.io.Serializable;

/**
 * Created by luwb on 2019/12/03.
 * 文章实体类
 */
@Data
@ToString
@Document(indexName = "article",type = "article")
public class Article implements Serializable {
	@Id
	private String id;
	@Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String title;
	@Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
	private String content;
	private String state;
}
