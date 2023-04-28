package sit.int221.sas.sit_announcement_system_backend.service;

import org.hibernate.annotations.NotFound;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;
import sit.int221.sas.sit_announcement_system_backend.repository.AnnouncementRepository;

import java.util.List;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<Announcement> getAnnouncements() {
        return announcementRepository.findAllByOrderByIdDesc();
    }

    public Announcement getAnnouncementById(Integer announcementid) {
        return announcementRepository.findById(announcementid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Announcement id"+announcementid+ " does not exist"));
    }

}
