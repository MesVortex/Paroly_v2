package com.youcode.paroly;

import org.springframework.boot.SpringApplication;

public class TestAlbumManagementApplication {

	public static void main(String[] args) {
		SpringApplication.from(ParolyApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
