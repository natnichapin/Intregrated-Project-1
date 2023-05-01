package sit.int221.sas.sit_announcement_system_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int221.sas.sit_announcement_system_backend.utils.AnnouncementDisplay;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "announcement")
public class Announcement {
    @Id
    private Integer id;
    private String announcementTitle;
    private String announcementDescription;



    @ManyToOne
    @JoinColumn(name = "announcementCategory")
    private Category AnnouncementCategory;

//    public String getAnnouncementCategory(){
//        return category.getCategoryName();
//    }


    private ZonedDateTime publishDate;
    private ZonedDateTime closeDate;
    //แปลง String จาก DB ไดิ
    @Enumerated(EnumType.STRING)
    private AnnouncementDisplay announcementDisplay;


}
