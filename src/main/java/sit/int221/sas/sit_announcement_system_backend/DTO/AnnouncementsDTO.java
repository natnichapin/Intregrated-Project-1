package sit.int221.sas.sit_announcement_system_backend.DTO;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.util.Date;

@Getter
@Setter
public class AnnouncementsDTO {
    private Integer id;
    private String announcementTitle;
    private Date publishDate;
    private Date closeDate;
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;

    private String announcementCategory;


}
