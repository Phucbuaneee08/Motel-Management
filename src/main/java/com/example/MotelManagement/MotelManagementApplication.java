package com.example.MotelManagement;

import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.entities.User;
import com.example.MotelManagement.repository.StudentRepository;
import com.example.MotelManagement.repository.UserRepository;
import com.example.MotelManagement.service.MotelService;
import com.example.MotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class MotelManagementApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(MotelManagementApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MotelService motelService;
	@Autowired
	private RoomService roomService;


	@Override
	public void run(String... args) throws Exception {



	}
}
