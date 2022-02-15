package we_won.hackerton.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SuccessAndFailureResponse<T> extends BasicResponse {

    private T message;
    private HttpStatus status;

    public SuccessAndFailureResponse(T message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
