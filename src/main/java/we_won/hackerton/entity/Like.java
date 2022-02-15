package we_won.hackerton.entity;

import javax.persistence.Column;

public class Like extends BaseEntity {

  @Column(nullable = false)
  private User_ user;

  @Column(nullable = false)
  private Long articleId;
}
