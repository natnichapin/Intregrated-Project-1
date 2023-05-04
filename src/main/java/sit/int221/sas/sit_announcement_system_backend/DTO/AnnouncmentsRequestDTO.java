package sit.int221.sas.sit_announcement_system_backend.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.time.ZonedDateTime;

@Getter
@Setter
public class AnnouncmentsRequestDTO {
    @Column(name="announcementTitle", nullable = false)
    private String announcementTitle;
    @Column(name="announcementDescription", nullable = false)
    private String announcementDescription ;
    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    //แปลง String จาก DB ไดิ
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;
    @Column(name="announcementCategory", nullable = false)
    private Integer announcementCategory;
}
