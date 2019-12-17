package demo.code;

import lombok.Data;
import lombok.ToString;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Created by luwb on 2019/12/17.
 * 实体
 */
@Data
@ToString
public class ImageCode {
	// 图片
	private BufferedImage image;
	// 验证码
	private String code;
	// 过期时间
	private LocalDateTime expireTime;

	public ImageCode(BufferedImage image, String code, int expireIn) {
		this.image = image;
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		this.image = image;
		this.code = code;
		this.expireTime = expireTime;
	}

	boolean isExpire() {
		return LocalDateTime.now().isAfter(expireTime);
	}
}
