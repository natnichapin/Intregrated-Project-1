package sit.int221.sas.sit_announcement_system_backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;

public interface PagingAnnouncementRepository extends PagingAndSortingRepository<Announcement, Integer> {


}
