package fr.it4innov.myasso.association.config.persistance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author Christus TCHASSI
 * @Date 03/06/2024
 *
 * la classe de configuration AuditConfig complete cette classe en fournissant
 * aux attributs createdBy et lastModifiedBy le nom de l'utilisateur courant
 */
@Slf4j
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
//@Audited
@EntityListeners( AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    protected Long id;

    @CreatedBy
    @Column( name = "created_by", nullable = false, length = 50, updatable = false )
    @JsonIgnore
    protected String createdBy;

    @CreatedDate
    @Column( name = "created_date", nullable = false )
    @JsonIgnore
    protected Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column( name = "last_modified_by", length = 50 )
    @JsonIgnore
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column( name = "last_modified_date" )
    @JsonIgnore
    protected Instant lastModifiedDate = Instant.now();

}