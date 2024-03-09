package com.timeaway.service;

import com.timeaway.exceptions.PaidTimeOffNotFoundException;
import com.timeaway.repositories.PaidTimeOff;
import com.timeaway.repositories.PaidTimeOffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaidTimeOffService {

    private final PaidTimeOffRepository paidTimeOffRepository;

    public PaidTimeOffService(PaidTimeOffRepository paidTimeOffRepository) {
        this.paidTimeOffRepository = paidTimeOffRepository;
    }

    public List<PaidTimeOff> getAllPto() {
        return paidTimeOffRepository.findAll();
    }

    public PaidTimeOff findPtoById(Long id) {
        return paidTimeOffRepository.findById(id)
                .orElseThrow(() -> new PaidTimeOffNotFoundException(id));
    }

    public void savePto(PaidTimeOff paidTimeOff) {
        paidTimeOffRepository.save(paidTimeOff);

    }
}
