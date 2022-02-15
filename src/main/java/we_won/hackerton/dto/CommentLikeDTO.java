package we_won.hackerton.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommentLikeDTO {

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public class LikeRequest {
    String nickname;
    Long commentId;
  }
}
