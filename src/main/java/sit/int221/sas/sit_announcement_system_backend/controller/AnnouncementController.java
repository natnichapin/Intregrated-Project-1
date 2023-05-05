package sit.int221.sas.sit_announcement_system_backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsResponseDTO;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsRequestDTO;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsResponseDetailDTO;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncementsResponsehaveidDTO;
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
        return ResponseEntity.status(HttpStatus.OK).body(listMapper.mapList(announcementService.getAnnouncements(),AnnouncementsResponseDTO.class, modelMapper));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementsResponseDetailDTO> getAnnouncementById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.getAnnouncementById(id),AnnouncementsResponseDetailDTO.class));
    }
    @PostMapping("")
    public ResponseEntity<AnnouncementsResponsehaveidDTO> createAnnouncement(@RequestBody AnnouncementsRequestDTO announcementDTO){

        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.createAnnoucement(announcementDTO), AnnouncementsResponsehaveidDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Integer id){
        announcementService.deleteAnnouncement(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementsResponseDetailDTO> updateAnnouncement(@PathVariable Integer id,@RequestBody AnnouncementsRequestDTO announcmentDTO){
        return  ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.updateAnnouncement(id,announcmentDTO), AnnouncementsResponseDetailDTO.class));

    }

}
