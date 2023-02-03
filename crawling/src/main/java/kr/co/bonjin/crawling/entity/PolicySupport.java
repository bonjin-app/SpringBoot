package kr.co.bonjin.crawling.entity;

import jakarta.persistence.*;
import kr.co.bonjin.crawling.entity.base.BaseEntity;

@Entity
@Table(name = "POLICY_SUPPORT")
@SequenceGenerator(name = "POLICY_SUPPORT_SEQ", sequenceName = "POLICY_SUPPORT_SEQ", allocationSize = 1)
public class PolicySupport extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_SUPPORT_SEQ")
    private Long id;

    @Column(name = "source")
    private String source;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "category")
    private String category;


}
