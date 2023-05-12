package sit.int221.sas.sit_announcement_system_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_Id")
    private Integer categoryId;
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy = "announcementCategory")
    private List<Announcement> announcements;
}
