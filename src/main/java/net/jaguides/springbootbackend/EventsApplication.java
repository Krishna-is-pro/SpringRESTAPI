package net.jaguides.springbootbackend;
import net.jaguides.springbootbackend.repository.EventRepository;
import net.jaguides.springbootbackend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

	@Autowired
	private EventRepository eventRepository;



	}

