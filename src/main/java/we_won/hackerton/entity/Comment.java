package we_won.hackerton.entity;

import lombok.*;
import org.springframework.data.relational.core.sql.Like;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity{

  @ManyToOne(targetEntity = User_.class)
  private User_ user;

  @ManyToOne(targetEntity = Article.class)
  private Article article;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private Boolean isSecret = true;

  @Column(nullable = false)
  private int likeNum = 0;

  @Column(nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  public void changeBasicInfo(User_ user, Article article, String content, Boolean isSecret, int likeNum, String createdAt) {
    this.user = user;
    this.article = article;
    this.content = content;
    this.isSecret = isSecret;
    this.likeNum = likeNum;
    this.createdAt = LocalDateTime.parse(createdAt);
  }

}
