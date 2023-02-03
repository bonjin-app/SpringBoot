package kr.co.bonjin.crawling.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Comment("생성일자")
    @Column(name="created_datetime")
    private LocalDateTime createdDatetime;

    @Comment("변경일자")
    @LastModifiedDate
    @Column(name="modified_datetime")
    private LocalDateTime modifiedDatetime;

    public LocalDateTime getCreatedDatetime() {
        return createdDatetime;
    }

    public LocalDateTime getModifiedDatetime() {
        return modifiedDatetime;
    }
}
