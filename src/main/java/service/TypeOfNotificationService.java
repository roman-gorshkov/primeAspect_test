package service;

import dto.TypeNotificationSaveRq;
import dto.TypeNotificationUpdateRq;
import exception.CustomErrorCode;
import exception.CustomException;
import model.TypeOfNotification;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TypeOfNotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TypeOfNotificationService {
    private final TypeOfNotificationRepository typeOfNotificationRepository;

    @Autowired
    public TypeOfNotificationService(TypeOfNotificationRepository typeOfNotificationRepository) {
        this.typeOfNotificationRepository = typeOfNotificationRepository;
    }

    public void save(TypeNotificationSaveRq typeNotificationSaveRq){
        TypeOfNotification typeOfNotification = new TypeOfNotification();
        typeOfNotification.setUuid(UUID.randomUUID());
        typeOfNotification.setCode(typeNotificationSaveRq.getCode());
        typeOfNotification.setName(typeNotificationSaveRq.getName());
        typeOfNotification.setColor(typeNotificationSaveRq.getColor());
        typeOfNotification.setIcon(typeNotificationSaveRq.getIcon());
        typeOfNotification.setVersion(0);
        typeOfNotification.setCreatedBy(RandomStringUtils.randomAlphabetic(30));
        typeOfNotification.setUpdatedBy(typeOfNotification.getCreatedBy());
        typeOfNotification.setDateOfCreation(LocalDateTime.now());
        typeOfNotification.setDateOfUpdate(typeOfNotification.getDateOfCreation());
        typeOfNotification.setSignOfActivity(true);
        typeOfNotificationRepository.save(typeOfNotification);
    }

    public TypeOfNotification getById(Long id) throws CustomException {
        return typeOfNotificationRepository.findById(id)
                                           .orElseThrow(() -> new CustomException(CustomErrorCode.TYPE_NOT_FOUND));
    }

    public TypeOfNotification getByUuid(String uuid) throws CustomException {
        UUID uuid1 = UUID.fromString(uuid);

        return typeOfNotificationRepository.getByUuid(uuid1)
                                           .orElseThrow(() -> new CustomException(CustomErrorCode.TYPE_NOT_FOUND));
    }

    public  List<TypeOfNotification> getList(String color){
        return typeOfNotificationRepository.findAllByColorOrderByColor(color);
    }

    public List<TypeOfNotification> getAll(){
       return  typeOfNotificationRepository.findAll();
    }

    public TypeOfNotification update(Long id, TypeNotificationUpdateRq typeNotificationUpdateRq) throws CustomException {

        TypeOfNotification oldType = typeOfNotificationRepository.findById(id)
                                                                 .orElseThrow(() -> new CustomException(CustomErrorCode.TYPE_NOT_FOUND));
        oldType.setCode(typeNotificationUpdateRq.getCode());
        oldType.setName(typeNotificationUpdateRq.getName());
        oldType.setColor(typeNotificationUpdateRq.getColor());
        oldType.setIcon(typeNotificationUpdateRq.getIcon());
        oldType.setUpdatedBy(RandomStringUtils.randomAlphabetic(30));
        oldType.setDateOfUpdate(LocalDateTime.now());
        oldType.setSignOfActivity(typeNotificationUpdateRq.isSignOfActivity());
        oldType.setVersion(oldType.getVersion() + 1);

        return typeOfNotificationRepository.save(oldType);

    }

    public void deleteById(Long id){
        typeOfNotificationRepository.deleteById(id);
    }

    public void deleteByUuid(String uuid){
        UUID uuid1 = UUID.fromString(uuid);

        typeOfNotificationRepository.deleteByUuid(uuid1);
    }


}
