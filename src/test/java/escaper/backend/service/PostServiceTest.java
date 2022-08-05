package escaper.backend.service;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.PostTheme;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.theme.Theme;
import escaper.backend.repository.post.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("새 글 쓰기")
    public void 새글_쓰기() {
        //given
        Theme theme1 = createTheme("테마1");
        Theme theme2 = createTheme("테마2");
        CreatePostRequest dto = new CreatePostRequest("title", "content", 1, LocalDate.of(2022, 5, 2), List.of(theme1.getId(), theme2.getId()));

        //when
        Long postId = postService.savePost(dto);

        //then
        Post post = postRepository.findById(postId)
                .orElse(null);

        List<PostTheme> themes = post.getThemes();
        Theme theme = themes.get(0).getTheme();
        assertThat(themes.size()).isEqualTo(2);
        assertThat(theme.getName()).isEqualTo(theme1.getName());
    }
    private Theme createTheme(String name) {
        Theme theme = new Theme(name);
        em.persist(theme);
        return theme;
    }
}