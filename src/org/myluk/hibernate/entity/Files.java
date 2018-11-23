package org.myluk.hibernate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor @Getter @Setter
@Entity(name = "files")
@Table(name = "files")
public class Files {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "file_name")
    private String filename;

    @Column(name = "label")
    private String label;

    @Column(name = "caption")
    private String caption;

    public Files(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", label='" + label + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }
}
