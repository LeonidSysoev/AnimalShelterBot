package pro.sky.telegrambot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.telegrambot.model.*;
import pro.sky.telegrambot.service.AddService;

import java.time.LocalDateTime;

@RequestMapping("/add")
@RestController
public class FillingDataBaseController {

    private final AddService addService;

    public FillingDataBaseController(AddService addService) {
        this.addService = addService;
    }

    @PostMapping("/animal/{animalType}/{name}/{age}/{breed}")
    public void AnimalSave(@PathVariable String animalType, @PathVariable String name, @PathVariable int age, @PathVariable String breed ){
        addService.AnimalSave(animalType, name, age, breed);
    }

    @PostMapping("/animal-owner/{name}/{phoneNumber}/{eMail}/{trialPeriod}")
    public void AnimalOwnerSave(@PathVariable String name, @PathVariable String phoneNumber,  @PathVariable String eMail, @PathVariable boolean trialPeriod){
        addService.AnimalOwnerSave(name, phoneNumber, eMail, trialPeriod);

    }

    @PostMapping("/pet-report/{diet}/{feelings}/{check}")
    public void PetReportSave(@PathVariable String diet, @PathVariable String feelings, @PathVariable boolean check){
        addService.PetReportSave(diet, feelings, check);
    }

    @PostMapping("/shelter/{shelterType}/{shelterName}/{address}/{information}")
    public void ShelterSave(@PathVariable String shelterType, @PathVariable String shelterName, @PathVariable String address, @PathVariable String information){
        addService.ShelterSave(shelterType, shelterName, address, information);
    }

//    @PostMapping("/user/{name}/{phoneNumber}/{eMail}/{chatId}/{localDateTime}")
//    public void UserSave(@PathVariable String name, @PathVariable String phoneNumber,
//                         @PathVariable Long chatId, @PathVariable LocalDateTime localDateTime){
//        addService.UserSave(name, phoneNumber, chatId, localDateTime);
//    }

    @PostMapping("/{s_id}/{id}")
    public void AS(@PathVariable long s_id, @PathVariable long id){
        addService.anSet(s_id, id);
    }
}
