package sit.int221.sas.sit_announcement_system_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor

@Table(name = "announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;
    @Column(name="announcementTitle", nullable = false)
    private String announcementTitle;
    @Column(name="announcementDescription", nullable = false)
    private String announcementDescription;


    @ManyToOne
    @JoinColumn(name = "announcementCategory",nullable = false)
    private Category AnnouncementCategory;
//    public String getAnnouncementCategory(){
//        return category.getCategoryName();
//    }
    @Column(name="publishDate", nullable = false)
    private ZonedDateTime publishDate;
    @Column(name="closeDate", nullable = false)
    private ZonedDateTime closeDate;
    //แปลง String จาก DB ได้

    @Column(name="announcementDisplay", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;
    public Announcement() {
        this.announcementDisplay = AnnouncementDisplay.N;
    }
}
