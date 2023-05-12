package sit.int221.sas.sit_announcement_system_backend.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.time.ZonedDateTime;

@Getter
@Setter
public class AnnouncementsRequestDTO {
    @Column(name="announcementTitle", nullable = false)
    private String announcementTitle;
    @Column(name="announcementDescription", nullable = false)
    private String announcementDescription ;
    @Column(name="publishDate", nullable = true)
    private ZonedDateTime publishDate;
    @Column(name="closeDate", nullable = true)
    private ZonedDateTime closeDate;
    //แปลง String จาก DB ได้

    @Column(name="announcementDisplay", nullable = true)
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;
    @Column(name="announcementCategory", nullable = false)
    private Integer categoryId ;
}
