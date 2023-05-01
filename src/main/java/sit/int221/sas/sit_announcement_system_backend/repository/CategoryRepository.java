package sit.int221.sas.sit_announcement_system_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int221.sas.sit_announcement_system_backend.entity.Announcement;
import sit.int221.sas.sit_announcement_system_backend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
