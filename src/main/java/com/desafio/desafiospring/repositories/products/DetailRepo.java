package com.desafio.desafiospring.repositories.products;

import com.desafio.desafiospring.dto.products.DetailDto;
import com.desafio.desafiospring.entities.products.Detail;
import com.desafio.desafiospring.exceptions.products.DetailNotFound;
import com.desafio.desafiospring.repositories.Repo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class DetailRepo implements Repo {

    private static List<Detail> FILE = new ArrayList<>();

    private List<Detail> loadData(){
        return FILE;
    }

    @Override
    public List<Detail> findAll() {
        return loadData();
    }

    @Override
    public Detail findById(long id) {
        Optional<Detail> oDetail = loadData().stream().filter(x-> x.getProductId() == id).findFirst();

        if(oDetail.isPresent())
            return oDetail.get();
        else
            throw new DetailNotFound("Produto não cadastrado");
    }

    @Override
    public Detail save(Object obj) {

        Detail detail = new Detail((DetailDto) obj);
        List<Detail> details = loadData();

        if(details.isEmpty()){
            detail.setProductId(0L);
            details.add(detail);
        }else{
            // faço uma função max pelo arraylist para encontrar o maior id cadastrado e acrescento 1, desta forma nunca repito o id mesmo removendo um elemento
            long id = details.stream().max(Comparator.comparingLong(Detail::getProductId)).get().getProductId()+1;

            detail.setProductId(id);
            details.add(detail);

        }

        return detail;
    }

    @Override
    public void delete(long id) {
        List<Detail> details = loadData();

        details.removeIf(x->x.getProductId() == id);
    }
}
