package controller;

import dto.NotificationSaveRq;
import dto.NotificationUpdateRq;
import exception.CustomException;
import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping
    public void save(@RequestBody NotificationSaveRq notificationSaveRq){
        notificationService.save(notificationSaveRq);
    }

    @GetMapping
    public Notification getById(@RequestParam("id") Long id) throws CustomException {
        return notificationService.getById(id);
    }

    @GetMapping("/getByUuid")
    public Notification getByUuid(@RequestParam("uuid") String uuid) throws CustomException {
        return notificationService.getByUuid(uuid);
    }

    @GetMapping("/getListSortedByFrom")
    public List<Notification> getList(@RequestParam("from") String from){
        return notificationService.getList(from);
    }

    @GetMapping("/getAll")
    public List<Notification> getAll(){
        return notificationService.getAll();
    }

    @PutMapping
    public Notification update(@RequestBody NotificationUpdateRq notificationUpdateRq,
                               @RequestParam("id") Long id) throws CustomException{
        return notificationService.update(id, notificationUpdateRq);
    }


    @DeleteMapping
    public void delete(@RequestParam("id") Long id) throws CustomException {
        Notification notification = notificationService.getById(id);
        notificationService.deleteById(notification.getId());
    }

    @DeleteMapping("/deleteByUuid")
    public void delete(@RequestParam("uuid") String uuid) {
        notificationService.deleteByUuid(uuid);
    }
}
