package com.yourcompany.serietv.service;

import com.yourcompany.serietv.entity.Serial;
import com.yourcompany.serietv.enumerate.SerialKind;
import com.yourcompany.serietv.repository.SerialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SerialService {

    private final SerialRepository serialRepository;


    public List<Serial> findAll() {
        Iterable<Serial> serials = serialRepository.findAll();
        return iterableToList(serials);
    }

    public Serial saveSerial(Serial serial) {
        return serialRepository.save(serial);
    }

    public List<Serial> search(String search) {
        return serialRepository.findSerialByNameIsContainingIgnoreCaseOrSerialKindContainingIgnoreCase(search, SerialKind.find(search));
    }

    public Serial putSerial(Serial serial) {
        return serialRepository.save(serial);
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        List<T> retour = new ArrayList<>();
        for (T it : iterable){
            retour.add(it);
        }
        return retour;
    }



}
