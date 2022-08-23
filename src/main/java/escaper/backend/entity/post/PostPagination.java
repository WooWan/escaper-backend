package escaper.backend.entity.post;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostPagination<T> {
    private int page;
    private T content;
    private int totalPage;
    private int size;

}
