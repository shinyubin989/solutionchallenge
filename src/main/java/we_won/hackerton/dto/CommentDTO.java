package we_won.hackerton.dto;

import lombok.*;

public class CommentDTO {

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class CommentRequest {
    private String nickname;
    private Boolean isSecret;
    private String content;
    private String createdAt;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class CommentResponse {
    private Long id;
    private String nickname;
    private Boolean isSecret;
    private Long articleId;
    private int likeNum;
    private String content;
    private String createdAt;
  }

}


