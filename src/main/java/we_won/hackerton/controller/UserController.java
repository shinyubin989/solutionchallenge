package we_won.hackerton.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import we_won.hackerton.dto.UserFormDTO;
import we_won.hackerton.response.SuccessAndFailureResponse;
import we_won.hackerton.service.UserServiceImpl;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("") //회원가입할 때
    public ResponseEntity<?> insertUser(
            @Valid @RequestBody UserFormDTO dto,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userService.saveOrUpdateAccount(dto.toEntity());
        SuccessAndFailureResponse successAndFailureResponse = new SuccessAndFailureResponse("회원가입에 성공했습니다.",HttpStatus.CREATED);
        return new ResponseEntity<>(successAndFailureResponse,HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> viewAccount() {

        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

//    @PostMapping("/articles") //기사 스크랩할 때
//    public ResponseEntity<?> scrapArticle(@RequestBody UserArticleScrapDTO userArticleScrapDTO){
//        return userService.scrapArticle(userArticleScrapDTO.getUsername(),userArticleScrapDTO.getArticle_id());
//    }
}
