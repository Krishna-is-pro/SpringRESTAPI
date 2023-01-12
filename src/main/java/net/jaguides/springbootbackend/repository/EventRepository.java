package net.jaguides.springbootbackend.repository;
import net.jaguides.springbootbackend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EventRepository extends JpaRepository<Event,Long> {
    // all crude database method
}
