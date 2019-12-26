package demo.validate.smscode;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by luwb on 2019/12/26.
 * 短信验证码实体
 */
@Data
@ToString
public class SmsCode {

	private String code;
	private LocalDateTime expireTime;

	public SmsCode(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	public SmsCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}

	boolean isExpire() {
		return LocalDateTime.now().isAfter(expireTime);
	}
}
