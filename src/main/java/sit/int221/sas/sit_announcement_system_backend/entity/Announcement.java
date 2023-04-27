package sit.int221.sas.sit_announcement_system_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "announcement")
public class Announcement {
    @Id
    private Integer id ;
    private String announcementTitle;
    private String announcementDescription;
    @ManyToOne
    @JoinColumn(name="announcementCategory")
    private Category announcementCategory ;
    private Date publishDate ;
    private Date closeDate ;
    //แปลง String จาก DB ไดิ
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay ;


}
