package controller;

import dto.TypeNotificationSaveRq;
import dto.TypeNotificationUpdateRq;
import exception.CustomException;
import model.TypeOfNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.TypeOfNotificationService;

import java.util.List;

@RestController
@RequestMapping("type_of_notification")
public class TypeOfNotificationController {

    private final TypeOfNotificationService typeOfNotificationService;

    @Autowired
    public TypeOfNotificationController(TypeOfNotificationService typeOfNotificationService){
        this.typeOfNotificationService = typeOfNotificationService;
    }

    @PostMapping
    public void save(TypeNotificationSaveRq typeNotificationSaveRq) {
        typeOfNotificationService.save(typeNotificationSaveRq);
    }

    @GetMapping
    public TypeOfNotification getById(@RequestParam("id") Long id) throws CustomException {
        return typeOfNotificationService.getById(id);
    }

    @GetMapping("/getByUuid")
    public TypeOfNotification getByUuid(@RequestParam("uuid") String uuid) throws CustomException {
        return typeOfNotificationService.getByUuid(uuid);
    }

    @GetMapping("/getListByColor")
    public List<TypeOfNotification> getList(@RequestParam("color") String color) {
        return typeOfNotificationService.getList(color);
    }

    @GetMapping("getAll")
    public List<TypeOfNotification> getAll() {
        return typeOfNotificationService.getAll();
    }

    @PutMapping
    public TypeOfNotification update(@RequestBody TypeNotificationUpdateRq typeNotificationUpdateRq,
                                     @RequestParam("id") Long id) throws CustomException {
        return typeOfNotificationService.update(id, typeNotificationUpdateRq);
    }

    @DeleteMapping
    public void deleteById(@RequestParam("id") Long id) {
        typeOfNotificationService.deleteById(id);
    }

    @DeleteMapping("/deleteByUuid")
    public void deleteByUuid(@RequestParam("uuid") String uuid) {
        typeOfNotificationService.deleteByUuid(uuid);
    }
}
