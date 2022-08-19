package com.example.project.entity;


import com.example.project.vo.JpaAuditingConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="IM_B2B_NOTICE")
@Data

public class Notice extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WR_KEY")
    private Long id;

    @Column(name="WR_SUBJECT")
    private String wrSubject;

    @Column(name="WR_CONTNET")
    private String wrContnet;

}
