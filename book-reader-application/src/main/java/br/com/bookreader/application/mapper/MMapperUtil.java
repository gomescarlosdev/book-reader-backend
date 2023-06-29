package br.com.bookreader.application.mapper;

import br.com.bookreader.application.request.UploadBookRequest;
import br.com.bookreader.domain.entity.BookFileEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class MMapperUtil {
    private static ModelMapper modelMapper;

    private MMapperUtil() {
    }

    public static ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            configureMappings(modelMapper);
        }
        return modelMapper;
    }

    private static void configureMappings(ModelMapper modelMapper) {
        modelMapper.addMappings(new PropertyMap<UploadBookRequest, BookFileEntity>() {
            protected void configure() {
                skip(destination.getId());
            }
        });
    }

}


