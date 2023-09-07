package com.dorukt.service;

import com.dorukt.exception.EerrorType;
import com.dorukt.exception.ResultIsEmptyException;
import com.dorukt.repository.IWorksRepository;
import com.dorukt.repository.entity.Works;
import com.dorukt.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorksService extends ServiceManager<Works, Long> {

    public WorksService(IWorksRepository repository) {
        super(repository);
    }

    @Override
    public List<Works> findAll() {
        List<Works> works = super.findAll();
        if (works.isEmpty())
            throw new ResultIsEmptyException(EerrorType.SORGULAMA_YAPILAN_LISTE_BOS);
        return works;
    }

    @Override
    public Optional<Works> findById(Long aLong) {
        if (aLong == null) {
            throw new ResultIsEmptyException(EerrorType.GECERSIZ_PARAMETRE);
        }
        Optional<Works> work = super.findById(aLong);
        if (work.isEmpty())
            throw new ResultIsEmptyException(EerrorType.WORK_NOT_FOUND);
        return work;
    }

    @Override
    public void deleteById(Long aLong) {
        Optional<Works> optWork = findById(aLong);
        super.delete(optWork.get());
    }

    @Override
    public Works update(Works works) {
        Optional<Works> optWork = findById(works.getId());
        return super.update(works);
    }
}
