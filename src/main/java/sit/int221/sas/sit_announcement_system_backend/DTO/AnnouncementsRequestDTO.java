package sit.int221.sas.sit_announcement_system_backend.DTO;

<<<<<<< HEAD
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
=======
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
>>>>>>> ca1204e0052e689cb664da30145fb2da4b03dc8e
import lombok.Getter;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.time.ZonedDateTime;

@Getter
@Setter
public class AnnouncementsRequestDTO {
    @Column(name = "announcementTitle", nullable = false)
    private String announcementTitle;
    @Column(name = "announcementDescription", nullable = false)
    private String announcementDescription;
    @Column(name = "publishDate", nullable = true)
    private ZonedDateTime publishDate;
    @Column(name = "closeDate", nullable = true)
    private ZonedDateTime closeDate;
    //แปลง String จาก DB ได้

    @Column(name = "announcementDisplay", nullable = true)
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;
    @Column(name = "announcementCategory", nullable = false)
    private Integer categoryId;
}
