package sit.int221.sas.sit_announcement_system_backend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import sit.int221.sas.sit_announcement_system_backend.DTO.PageDto;

import java.util.List;
import java.util.stream.Collectors;

public class ListMapper {
    private static final ListMapper listMapper = new ListMapper(); //new ตัวเอง แล้วเก็บไว้ โดยคนอื่นจะไม่มีสิทธิ์ New และจะมาเรียกใช้ Method จากที่เดียวกัน

    private ListMapper() {
    } //constructor ห้ามใครยุ่ง

    public static ListMapper getInstance() {
        return listMapper;
    }

    //Generic ต้องเก็บ ทั้งของ Method และ parameter
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> PageDto<T> toPageDTO(Page<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        //get มาแปลง แล้ว set กลับไป
        PageDto<T> page = modelMapper.map(source, PageDto.class); //เอา page ไปแปลง เป็น pageDTO
        page.setContent(mapList(source.getContent(), targetClass, modelMapper)); // เอาข้อมูลมาแปลง เป็น DTO แบบ List แล้ว Set เข้า page
        return page;
    }
}
