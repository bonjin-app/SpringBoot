package kr.co.bonjin.crawling.entity;

import jakarta.persistence.*;
import kr.co.bonjin.crawling.entity.base.BaseEntity;

@Entity
@Table(name = "POLICY_EVENT")
@SequenceGenerator(name = "POLICY_EVENT_SEQ", sequenceName = "POLICY_EVENT_SEQ", allocationSize = 1)
public class PolicyEvent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_EVENT_SEQ")
    private Long id;

    @Column(name = "source")
    private String source;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}
