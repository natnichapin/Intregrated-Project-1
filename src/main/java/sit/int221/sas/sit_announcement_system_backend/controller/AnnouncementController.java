package sit.int221.sas.sit_announcement_system_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsDTO;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;
import sit.int221.sas.sit_announcement_system_backend.service.AnnouncementService;
import sit.int221.sas.sit_announcement_system_backend.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/kw1/api/announcements")
public class AnnouncementController {
    @Autowired
    private ListMapper listMapper ;
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private AnnouncementService announcementService ;

    @GetMapping("")
    public List<AnnouncementsDTO> getAnnouncements (){
        return listMapper.mapList(announcementService.getAnnouncements(),AnnouncementsDTO.class,modelMapper);
    }

    @GetMapping("/{id}")
    public Announcement getAnnouncementById(@PathVariable Integer id){
        return announcementService.getAnnouncementById(id) ;
    }

}
