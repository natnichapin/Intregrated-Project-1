package sit.int221.sas.sit_announcement_system_backend.service;

import org.hibernate.annotations.NotFound;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
        announcement.setId(announcementDTO.getId());
        return getAnnouncement(announcementDTO, announcement);
    }

    public void deleteAnnouncement(Integer id){
        announcementRepository.deleteById(id);
    }


    public Announcement updateAnnouncement(Integer id,AnnouncmentsRequestDTO announcement){
        Announcement existAnnouncement = announcementRepository.findById(id).orElseThrow(
                ()->new ResourceAccessException(id + "does not exist !!!"));
        return getAnnouncement(announcement, existAnnouncement);
    }

    private Announcement getAnnouncement(AnnouncmentsRequestDTO announcement, Announcement existAnnouncement) {
        existAnnouncement.setAnnouncementTitle(announcement.getAnnouncementTitle());
        existAnnouncement.setAnnouncementDescription(announcement.getAnnouncementDescription());
        existAnnouncement.setPublishDate(announcement.getPublishDate());
        existAnnouncement.setCloseDate(announcement.getCloseDate());
        existAnnouncement.setAnnouncementDisplay(announcement.getAnnouncementDisplay());
        existAnnouncement.setAnnouncementCategory(categoryRepository.findById(announcement.getAnnouncementCategory()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Not found this Category !")));
        return  announcementRepository.saveAndFlush(existAnnouncement);
    }

}
