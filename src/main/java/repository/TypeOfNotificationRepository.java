package repository;

import model.TypeOfNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeOfNotificationRepository extends JpaRepository <TypeOfNotification, Long> {

    Optional<TypeOfNotification> getByUuid(UUID uuid);

    List<TypeOfNotification> findAllByColorOrderByColor(String color);

    void deleteByUuid(UUID uuid);
}
