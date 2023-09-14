package repository;

import model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository <Notification, Long> {

    Optional<Notification> getByUuid(UUID uuid);

    List<Notification> findAllByFromOrderByFrom(String from);

    void deleteByUuid(UUID uuid);
}
