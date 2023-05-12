package sit.int221.sas.sit_announcement_system_backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class UserAnnouncementsResponseDetailDTO {
    private Integer id;
    private String announcementTitle;
    private String announcementDescription;
    private ZonedDateTime closeDate;
    private String announcementCategory;
}
