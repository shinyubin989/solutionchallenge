package we_won.hackerton.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import we_won.hackerton.dto.CommentDTO;
import we_won.hackerton.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

  @Autowired
  private CommentService commentService;

  @GetMapping("/{articleId}/comment")
  public List<CommentDTO.CommentResponse> getComments(@PathVariable("articleId") Long articleId) {
    return commentService.getComments(articleId);
  }

  @PostMapping("/{articleId}/comment")
  public ResponseEntity<?> postComment(@PathVariable("articleId") Long articleId,
                                       @RequestBody CommentDTO.CommentRequest commentDto) {
    return commentService.postComments(articleId, commentDto);
  }
}
