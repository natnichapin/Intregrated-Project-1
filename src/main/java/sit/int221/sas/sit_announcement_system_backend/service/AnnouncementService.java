package sit.int221.sas.sit_announcement_system_backend.service;

import org.hibernate.annotations.NotFound;
import org.modelmapper.ValidationException;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.sas.sit_announcement_system_backend.DTO.AnnouncmentsRequestDTO;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;
import sit.int221.sas.sit_announcement_system_backend.repository.AnnouncementRepository;
import sit.int221.sas.sit_announcement_system_backend.repository.CategoryRepository;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Announcement> getAnnouncements() {
        return announcementRepository.findAllByOrderByIdDesc();
    }

    public Announcement getAnnouncementById(Integer announcementid) {
        return announcementRepository.findById(announcementid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Announcement id"+announcementid+ " does not exist"));
    }
    public Announcement createAnnoucement(AnnouncmentsRequestDTO announcementDTO){
        Announcement announcement = new Announcement();
        return getAnnouncement(announcementDTO, announcement);
    }

    public void deleteAnnouncement(Integer id){
        announcementRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND," Announcement id" +id + " does not exist, Can not delete !")) ;
        announcementRepository.deleteById(id);
    }


    public Announcement updateAnnouncement(Integer id,AnnouncmentsRequestDTO announcement) {
        try {
            Announcement existAnnouncement = announcementRepository.findById(id).orElseThrow(
                    ()->new   ResponseStatusException(HttpStatus.NOT_FOUND,"Announcement id" +id + " does not exist, Can not update !"));
            return    getAnnouncement(announcement, existAnnouncement);
        }
        catch (RuntimeException e) {
         throw new RuntimeException(e);
        }


    }

    private Announcement getAnnouncement(AnnouncmentsRequestDTO announcement, Announcement RealAnnouncement) {
        RealAnnouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
        RealAnnouncement.setAnnouncementDescription(announcement.getAnnouncementDescription());
        RealAnnouncement.setPublishDate(announcement.getPublishDate());
        RealAnnouncement.setCloseDate(announcement.getCloseDate());
        if(announcement.getAnnouncementDisplay()!=null){
            RealAnnouncement.setAnnouncementDisplay(announcement.getAnnouncementDisplay());
        }
        RealAnnouncement.setAnnouncementCategory(categoryRepository.findById(announcement.getAnnouncementCategory()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category id" +announcement.getAnnouncementCategory()+" does not exist, Can not update !")));
        return  announcementRepository.saveAndFlush(RealAnnouncement);
    }

}
