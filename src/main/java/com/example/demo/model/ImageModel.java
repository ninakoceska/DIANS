package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="image_model")
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "pic")
    private byte[] pic;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="winery_id")
    private Winery winery;


    //Custom Construtor
    public ImageModel(String name, String type, byte[] pic) {
        this.name = name;
        this.type = type;
        this.pic = pic;
    }

    @JsonIgnore
    public byte[] getPic() {
        return pic;
    }
}