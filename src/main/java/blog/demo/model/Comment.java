package blog.demo.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;

    @Override
    public String toString() {
        return getDescription();
    }
}
