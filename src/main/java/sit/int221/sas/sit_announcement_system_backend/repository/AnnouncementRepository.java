package sit.int221.sas.sit_announcement_system_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement,Integer> {
}