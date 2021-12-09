package com.spring.whalephoto;

import com.spring.whalephoto.entity.PhotoStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		PhotoStorageProperties.class
})
public class WhalephotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhalephotoApplication.class, args);
	}

}
