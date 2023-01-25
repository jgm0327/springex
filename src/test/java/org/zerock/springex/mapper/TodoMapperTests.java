package org.zerock.springex.mapper;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.springex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
@Log4j2
public class TodoMapperTests {
    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    void testGetTime(){
        log.info(todoMapper.getTime());
    }

    @Test
    void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("스프링 테스트")
                .dueDate(LocalDate.now())
                .writer("user00")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(log::info);
    }

    @Test
    void testSelectOne(){
        log.info(todoMapper.selectOne(1L));
    }
}
