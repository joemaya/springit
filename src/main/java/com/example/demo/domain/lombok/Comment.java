package com.example.demo.domain.lombok;

import com.example.demo.service.BeanUtil;
import lombok.*;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public class Comment extends Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String body;

    // tie to Link
    @ManyToOne
    @NonNull
    private Link link;

    private String testLink;

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

}
