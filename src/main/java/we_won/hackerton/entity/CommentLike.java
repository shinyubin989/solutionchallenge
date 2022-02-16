package we_won.hackerton.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity(name = "comment_like")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CommentLikeID.class)
public class CommentLike extends BaseEntity {

  @Id
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "user_id")
  private User_ user;

  @Id
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "comment_id")
  private Comment comment;

}
