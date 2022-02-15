package we_won.hackerton.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import we_won.hackerton.Interface.ArticleRepository;
import we_won.hackerton.Interface.CommentRepository;
import we_won.hackerton.Interface.UserRepository;
import we_won.hackerton.dto.CommentDTO;
import we_won.hackerton.entity.Article;
import we_won.hackerton.entity.Comment;
import we_won.hackerton.mapper.CommentMapper;

import java.util.ArrayList;
import java.util.List;

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
    if (userRepository.findByNickname(request.getNickname()) != null) {
      comment.setUser(userRepository.findByNickname(request.getNickname()));
    }
    comment.setArticle(articleRepository.getById(request.getArticleId()));
    article.setComment_num(article.getComment_num()+1);
    articleRepository.save(article);
    commentRepository.save(comment);

    return new ResponseEntity<>(HttpStatus.OK);

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
}
