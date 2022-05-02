package insa.smart.smart_back.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentDTO {

    private Long id;

    private String message;

    private Integer upvote;

    private Integer downvote;

    private LocalDate created_at;

    private LocalDate deleted_at;

    private String created_by;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", upvote=" + upvote +
                ", downvote=" + downvote +
                ", created_at=" + created_at +
                ", deleted_at=" + deleted_at +
                '}';
    }
}
