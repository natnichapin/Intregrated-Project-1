package sit.int221.sas.sit_announcement_system_backend.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.time.ZonedDateTime;

@Getter
@Setter
public class AnnouncmentsRequestDTO {
    private Integer id;
    private String announcementTitle;
    private String announcementDescription;
    private Integer announcementCategory;
    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    //แปลง String จาก DB ไดิ
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;
}
