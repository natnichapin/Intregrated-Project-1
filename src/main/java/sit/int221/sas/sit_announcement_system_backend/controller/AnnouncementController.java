package sit.int221.sas.sit_announcement_system_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsDTO;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncmentsDetailDTO;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;
import sit.int221.sas.sit_announcement_system_backend.service.AnnouncementService;
import sit.int221.sas.sit_announcement_system_backend.utils.ListMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RestController
@RequestMapping("/kw1/api/announcements")
@CrossOrigin
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
    public AnnouncmentsDetailDTO getAnnouncementById(@PathVariable Integer id){
        return modelMapper.map(announcementService.getAnnouncementById(id), AnnouncmentsDetailDTO.class)   ;
    }

}
