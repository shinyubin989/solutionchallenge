package we_won.hackerton.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import we_won.hackerton.Interface.ArticleRepository;
import we_won.hackerton.Interface.CommentRepository;
import we_won.hackerton.Interface.UserRepository;
import we_won.hackerton.dto.CommentDTO;
import we_won.hackerton.entity.Article;
import we_won.hackerton.entity.Comment;
import we_won.hackerton.entity.User_;
import we_won.hackerton.mapper.CommentMapper;
import we_won.hackerton.response.SuccessAndFailureResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;
  private final ArticleRepository articleRepository;
  private final CommentMapper commentMapper;
  private final ModelMapper modelMapper;


  public ResponseEntity<?> postComments(CommentDTO.CommentRequest request) {

    Comment comment = modelMapper.map(request, Comment.class);
    Article article = articleRepository.getById(request.getArticleId());
    if (userRepository.findByNickname(request.getNickname()).isPresent()) {
      comment.setUser(userRepository.findByNickname(request.getNickname()).get());
    }
    comment.setArticle(articleRepository.getById(request.getArticleId()));
    article.setComment_num(article.getComment_num()+1);
    articleRepository.save(article);
    commentRepository.save(comment);

    final SuccessAndFailureResponse successAndFailureResponse = new SuccessAndFailureResponse("댓글 작성을 완료했습니다.",HttpStatus.OK);
    return new ResponseEntity<>(successAndFailureResponse, HttpStatus.OK);

  }

  public List<CommentDTO.CommentResponse> getComments(Long articleId) {
    List<Comment> comments = commentRepository.findAllByArticle_Id(articleId);

    List<CommentDTO.CommentResponse> commentDTOList = new ArrayList<>();

    for (Comment comment : comments) {
      commentDTOList.add(commentMapper.toDomain(comment));
    }
    return commentDTOList;

//    List<CommentDTO> commentDTOList = null;
//
//    for (int i = 0; i < comments.size(); i++) {
//      commentDTOList.add(i, CommentMapper.INSTANCE.CommentToCommentDTO(comments.get(i)));
//    }
//
//    return commentDTOList;
  }

  public ResponseEntity<?> deleteComment(@RequestBody CommentDTO.CommentDeleteRequest request) {
    Optional<Comment> comment = commentRepository.findById(request.getCommentId());
    if (Objects.equals(request.getNickname(), comment.get().getUser().getNickname())) {
      commentRepository.deleteById(request.getCommentId());
      return new ResponseEntity<>("댓글을 삭제했습니다.", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("댓글을 삭제할 수 없습니다.", HttpStatus.BAD_REQUEST);
    }
  }
//  private Long commentId; // 삭제하려는 코멘트의 아이디
//  private String nickname; // 삭제하려는 유저의 닉네임
}
