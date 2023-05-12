package sit.int221.sas.sit_announcement_system_backend.controller;

<<<<<<< HEAD
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
=======
>>>>>>> ca1204e0052e689cb664da30145fb2da4b03dc8e
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int221.sas.sit_announcement_system_backend.DTO.*;
import sit.int221.sas.sit_announcement_system_backend.service.AnnouncementService;
import sit.int221.sas.sit_announcement_system_backend.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("api/announcements")
@CrossOrigin
public class AnnouncementController<T> {
    @Autowired
    private ListMapper listMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AnnouncementService announcementService;

    @GetMapping("")
    public ResponseEntity<List<AnnouncementsResponseDTO>> getAnnouncements(@RequestParam(required = false) String mode) {
        if (mode != null) {
            if (mode.equalsIgnoreCase("active") || mode.equalsIgnoreCase("closed")) {
                return ResponseEntity.status(HttpStatus.OK).body(listMapper.mapList(announcementService.getAnnouncements(mode), AnnouncementsResponseDTO.class, modelMapper));
            }
            throw new RuntimeException();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(listMapper.mapList(announcementService.getAnnouncements(mode), AnnouncementsResponseDTO.class, modelMapper));
        }

    }

   /* public ResponseEntity<List<T>> getAnnouncements(@RequestParam (required = false) String mode ) {
        if( mode != null){
            if(mode.toLowerCase().equals("active")||mode.toLowerCase().equals("close") ){
                return ResponseEntity.status(HttpStatus.OK).body((List<T>) listMapper.mapList(announcementService.getAnnouncements(mode),UserAnnouncementsResponseDTO.class, modelMapper));
            }
            throw new RuntimeException();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body((List<T>) listMapper.mapList(announcementService.getAnnouncements(mode),AnnouncementsResponseDTO.class, modelMapper));
        }

    }*/

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementsResponseDetailDTO> getAnnouncementById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.getAnnouncementById(id), AnnouncementsResponseDetailDTO.class));
    }

    @GetMapping("/pages")
<<<<<<< HEAD
    public ResponseEntity<PageDto> getAnnouncementPage (@RequestParam (defaultValue = "0")Integer page,
                                        @RequestParam (defaultValue = "5") Integer size,
                                        @RequestParam (required = false) String mode,
                                        @RequestParam (required = false) Integer category){
        if( mode != null ){
            if(mode.toLowerCase().equals("active")||mode.toLowerCase().equals("close") ) {
                return ResponseEntity.status(HttpStatus.OK).body(listMapper.toPageDTO(announcementService.getPages(page, size, mode, category), AnnouncementsResponseDTO.class, modelMapper));
            }
            else {
                return ResponseEntity.status(HttpStatus.OK).body(listMapper.toPageDTO(announcementService.getPages(page, size, mode, category), AnnouncementsResponseDTO.class, modelMapper));
            }
            }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(listMapper.toPageDTO(announcementService.getPages(page, size, mode, category), AnnouncementsResponseDTO.class, modelMapper));
=======
    public ResponseEntity<PageDto> getAnnouncementPage(@RequestParam(defaultValue = "0") Integer page,
                                                       @RequestParam(defaultValue = "5") Integer pageSize,
                                                       @RequestParam(required = false) String mode,
                                                       @RequestParam(required = false) Integer id) {
        if (mode != null) {
            if (mode.equalsIgnoreCase("active") || mode.equalsIgnoreCase("closed")) {
                return ResponseEntity.status(HttpStatus.OK).body(listMapper.toPageDTO(announcementService.getPages(page, pageSize, mode, id), UserAnnouncementsResponseDTO.class, modelMapper));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(listMapper.toPageDTO(announcementService.getPages(page, pageSize, mode, id), AnnouncementsResponseDTO.class, modelMapper));
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(listMapper.toPageDTO(announcementService.getPages(page, pageSize, mode, id), AnnouncementsResponseDTO.class, modelMapper));
>>>>>>> ca1204e0052e689cb664da30145fb2da4b03dc8e
        }
    }


    @PostMapping("")
<<<<<<< HEAD
    public ResponseEntity<AnnouncementsResponsehaveidDTO> createAnnouncement(@Valid @RequestBody AnnouncementsRequestDTO announcementDTO){
=======
    public ResponseEntity<AnnouncementsResponsehaveidDTO> createAnnouncement(@RequestBody AnnouncementsRequestDTO announcementDTO) {
>>>>>>> ca1204e0052e689cb664da30145fb2da4b03dc8e

        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.createAnnoucement(announcementDTO), AnnouncementsResponsehaveidDTO.class));
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Integer id) {
        announcementService.deleteAnnouncement(id);
    }

    @PutMapping("/{id}")
<<<<<<< HEAD
    public ResponseEntity<AnnouncementsResponseDetailDTO> updateAnnouncement(@PathVariable Integer id,@Valid @RequestBody AnnouncementsRequestDTO announcmentDTO){
        return  ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.updateAnnouncement(id,announcmentDTO), AnnouncementsResponseDetailDTO.class));
=======
    public ResponseEntity<AnnouncementsResponseDetailDTO> updateAnnouncement(@PathVariable Integer id, @RequestBody AnnouncementsRequestDTO announcmentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(announcementService.updateAnnouncement(id, announcmentDTO), AnnouncementsResponseDetailDTO.class));
>>>>>>> ca1204e0052e689cb664da30145fb2da4b03dc8e

    }

}
