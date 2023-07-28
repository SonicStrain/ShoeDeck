package com.shoedeck.project.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shoeinfo")
public class ShoeInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoeinfo_id_seq")
    @SequenceGenerator(name = "shoeinfo_id_seq", sequenceName = "shoeinfo_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;
    @Column(name = "brand")
    private String brandName;
    @Column(name = "color")
    private String shoeColor;
    @Column(name = "type")
    private String shoeType;
    @Column(name = "rating")
    private String rating;
    @Column(name = "price")
    private String price;
    @Column(name = "url")
    private String imageUrl;
    @Column(name = "is_for_home")
    private String forHome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShoeInfo shoeInfo = (ShoeInfo) o;
        return id != null && Objects.equals(id, shoeInfo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
