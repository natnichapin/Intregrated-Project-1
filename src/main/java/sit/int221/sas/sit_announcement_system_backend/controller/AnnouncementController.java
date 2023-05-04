package sit.int221.sas.sit_announcement_system_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsResponseDTO;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncmentsResponseDetailDTO;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncmentsRequestDTO;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;
import sit.int221.sas.sit_announcement_system_backend.service.AnnouncementService;
import sit.int221.sas.sit_announcement_system_backend.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("api/announcements")
@CrossOrigin
public class AnnouncementController {
    @Autowired
    private ListMapper listMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("")
    public ResponseEntity<List<AnnouncementsResponseDTO>> getAnnouncements() {
        return ResponseEntity.status(HttpStatus.OK).body(listMapper.mapList(announcementService.getAnnouncements(), AnnouncementsResponseDTO.class, modelMapper));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncmentsResponseDetailDTO> getAnnouncementById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.getAnnouncementById(id), AnnouncmentsResponseDetailDTO.class));
    }
    @PostMapping("")
    public ResponseEntity<Announcement> createAnnouncement(@RequestBody AnnouncmentsRequestDTO announcementDTO){

        return ResponseEntity.status(HttpStatus.OK).body(announcementService.createAnnoucement(announcementDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Integer id){
        announcementService.deleteAnnouncement(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable Integer id,@RequestBody AnnouncmentsRequestDTO announcment){
        return  ResponseEntity.status(HttpStatus.OK).body(announcementService.updateAnnouncement(id,announcment));

    }

}
