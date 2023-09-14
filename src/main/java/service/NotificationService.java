package service;

import dto.NotificationSaveRq;
import dto.NotificationUpdateRq;
import exception.CustomErrorCode;
import exception.CustomException;
import model.Notification;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public void save(NotificationSaveRq notificationSaveRq){
        Notification notification = new Notification();
        notification.setUuid(UUID.randomUUID());
        notification.setFrom(notificationSaveRq.getFrom());
        notification.setSubject(notificationSaveRq.getSubject());
        notification.setText(notificationSaveRq.getText());
        notification.setType(notificationSaveRq.getType());
        notification.setReceiptSign(false);
        notification.setVersion(0);
        notification.setCreatedBy(notificationSaveRq.getCreatedBy());
        notification.setUpdatedBy(notificationSaveRq.getCreatedBy());
        notification.setDateOfCreation(LocalDateTime.now());
        notification.setDateOfUpdate(LocalDateTime.now());
        notification.setSignOfActivity(true);

        notificationRepository.save(notification);
    }

    public Notification getById(Long id) throws CustomException {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.NOTIFICATION_NOT_FOUND));
    }

    public Notification getByUuid(String uuid) throws CustomException {
        UUID uuid2 = UUID.fromString(uuid);

        return notificationRepository.getByUuid(uuid2)
                .orElseThrow(() -> new CustomException(CustomErrorCode.NOTIFICATION_NOT_FOUND));
    }

    public List<Notification> getList(String from){
        return notificationRepository.findAllByFromOrderByFrom(from);
    }

    public List<Notification> getAll(){
        return  notificationRepository.findAll();
    }

    public Notification update(Long id, NotificationUpdateRq notificationUpdateRq) throws CustomException{
        Notification oldType = notificationRepository.findById(id)
                                                     .orElseThrow(() -> new CustomException(CustomErrorCode.NOTIFICATION_NOT_FOUND));
        oldType.setType(notificationUpdateRq.getType());
        oldType.setReceiptSign(notificationUpdateRq.isReceiptSign());
        oldType.setUpdatedBy(RandomStringUtils.randomAlphabetic(30));
        oldType.setDateOfUpdate(LocalDateTime.now());
        oldType.setSignOfActivity(notificationUpdateRq.isSignOfActivity());
        oldType.setVersion(oldType.getVersion() + 1);

        return notificationRepository.save(oldType);
    }

    public void deleteById(Long id){
        notificationRepository.deleteById(id);
    }

    public void deleteByUuid(String uuid){
        UUID uuid1 = UUID.fromString(uuid);

        notificationRepository.deleteByUuid(uuid1);
    }
}
