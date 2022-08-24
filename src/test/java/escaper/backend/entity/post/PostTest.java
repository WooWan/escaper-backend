package escaper.backend.entity.post;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    public void title_비어있으면_exception() {
        assertThrows(IllegalArgumentException.class,
                ()-> Post.builder()
                        .content("content")
                        .participation(1)
                        .appointmentDate(LocalDate.of(2022, 5, 5))
                        .build());
    }

    @Test
    public void content_비어있으면_exception() {
        assertThrows(IllegalArgumentException.class,
                ()-> Post.builder()
                        .title("title")
                        .participation(1)
                        .appointmentDate(LocalDate.of(2022, 5, 5))
                        .build());
    }

    @Test
    public void participation_비어있으면_exception() {
        assertThrows(IllegalArgumentException.class,
                ()-> Post.builder()
                        .title("title")
                        .content("content")
                        .appointmentDate(LocalDate.of(2022, 5, 5))
                        .build());
    }
    @Test
    public void appointmentDate_비어있으면_exception() {
        assertThrows(IllegalArgumentException.class,
                ()-> Post.builder()
                        .title("title")
                        .content("content")
                        .participation(1)
                        .build());
    }
}