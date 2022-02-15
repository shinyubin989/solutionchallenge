package we_won.hackerton.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import we_won.hackerton.Interface.ArticleRepository;
import we_won.hackerton.Interface.CommentRepository;
import we_won.hackerton.Interface.UserRepository;
import we_won.hackerton.dto.CommentLikeDTO;
import we_won.hackerton.entity.Comment;
import we_won.hackerton.entity.User_;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
  private final UserRepository userRepository;
  private final CommentRepository commentRepository;
  private final ArticleRepository articleRepository;

//  public ResponseEntity<?> clickLike(@RequestBody CommentLikeDTO.LikeRequest request) {
//    User_ user = userRepository.findByNickname(request.getNickname());
//    Optional<Comment> comment = commentRepository.findById(request.getCommentId());
//    if (user == null) {
//      return new ResponseEntity<>("로그인을 한 회원만 좋아요를 누를 수 있습니다.", HttpStatus.BAD_REQUEST);
//    } else if () {
//    } else if (comment.get().getLikedUser().contains(user)) {
//      return new ResponseEntity<>("이미 좋아요를 누른 댓글입니다.", HttpStatus.BAD_REQUEST);
//    } else {
//      comment.get().getLikedUser().add(user);
//      comment.get().setLikeNum(comment.get().getLikeNum() + 1);
//      return new ResponseEntity<>(HttpStatus.OK);
//    }
////    if (commentRepository.findByUser(userRepository.findByNickname(request.getNickname())).getLikedUser().contains(userRepository.findByNickname(request.getNickname()))) {
////      return new ResponseEntity<>("이미 좋아요를 누른 댓글입니다.", HttpStatus.BAD_REQUEST);
////    } else {
////      commentRepository.findByUser(userRepository.findByNickname(request.getNickname())).setLikeNum(commentRepository.findByUser(userRepository.findByNickname(request.getNickname())).getLikeNum()+1);
////
////    }
//  }

}
