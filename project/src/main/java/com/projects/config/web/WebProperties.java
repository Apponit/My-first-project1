
package com.projects.config.web;

import cn.stylefeng.roses.core.util.ToolUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

import static cn.stylefeng.roses.core.util.ToolUtil.getTempPath;

/**
 * 项目配置

 */
@Component
@ConfigurationProperties(prefix = WebProperties.PREFIX)
public class WebProperties {

	public static final String PREFIX = "guns";

	private Boolean kaptchaOpen = false;

	private Boolean swaggerOpen = false;

	private String fileUploadPath;
	private String serverUploadPath;
	private Boolean haveCreatePath = false;

	private Boolean springSessionOpen = false;

	/**
	 * session 失效时间（默认为30分钟 单位：秒）
	 */
	private Integer sessionInvalidateTime = 30 * 60;

	/**
	 * session 验证失效时间（默认为15分钟 单位：秒）
	 */
	private Integer sessionValidationInterval = 15 * 60;

	public String getFileUploadPath() {
		// 如果没有写文件上传路径,保存到临时目录
		if (ToolUtil.isEmpty(fileUploadPath)) {
			return getTempPath();
		} else {
			// 判断有没有结尾符,没有得加上
			if (!fileUploadPath.endsWith(File.separator)) {
				fileUploadPath = fileUploadPath + File.separator;
			}
			// 判断目录存不存在,不存在得加上
			if (!haveCreatePath) {
				File file = new File(fileUploadPath);
				file.mkdirs();
				haveCreatePath = true;
			}
			return fileUploadPath;
		}
	}

	public void setFileUploadPath(String fileUploadPath) {
		this.fileUploadPath = fileUploadPath;
	}

	public Boolean getKaptchaOpen() {
		return kaptchaOpen;
	}

	public String getServerUploadPath() {
		return serverUploadPath;
	}

	public void setServerUploadPath(String serverUploadPath) {
		this.serverUploadPath = serverUploadPath;
	}

	public void setKaptchaOpen(Boolean kaptchaOpen) {
		this.kaptchaOpen = kaptchaOpen;
	}

	public Boolean getSwaggerOpen() {
		return swaggerOpen;
	}

	public void setSwaggerOpen(Boolean swaggerOpen) {
		this.swaggerOpen = swaggerOpen;
	}

	public Boolean getSpringSessionOpen() {
		return springSessionOpen;
	}

	public void setSpringSessionOpen(Boolean springSessionOpen) {
		this.springSessionOpen = springSessionOpen;
	}

	public Integer getSessionInvalidateTime() {
		return sessionInvalidateTime;
	}

	public void setSessionInvalidateTime(Integer sessionInvalidateTime) {
		this.sessionInvalidateTime = sessionInvalidateTime;
	}

	public Integer getSessionValidationInterval() {
		return sessionValidationInterval;
	}

	public void setSessionValidationInterval(Integer sessionValidationInterval) {
		this.sessionValidationInterval = sessionValidationInterval;
	}
}
