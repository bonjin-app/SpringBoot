package kr.co.bonjin.crawling.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import kr.co.bonjin.crawling.entity.base.BaseEntity;
import kr.co.bonjin.crawling.entity.convert.FileAttributeConverter;
import org.hibernate.annotations.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "POLICY_NEWS")
@SequenceGenerator(name = "POLICY_NEWS_SEQ", sequenceName = "POLICY_NEWS_SEQ", allocationSize = 1)
public class PolicyNews extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POLICY_NEWS_SEQ")
    private Long id;

    @Column(name = "source")
    private String source;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "view_type")
    @Enumerated(EnumType.STRING)
    private String viewType;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "files")
    @Convert(converter = FileAttributeConverter.class)
    private List<FileAttribute> files;

}

