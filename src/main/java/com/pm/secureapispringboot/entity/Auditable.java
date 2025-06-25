package com.pm.secureapispringboot.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * @author Douglas Nyabasa
 * @version 1.0
 * @since 25/06/2025
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"}, allowGetters = true)
public abstract class Auditable {
}
