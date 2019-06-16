package blog.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "Post" +
                "id=" + id +
                ", content='" + content;
    }
}
