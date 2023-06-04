package com.investree.demo.view.impl;

import com.investree.demo.model.Transaksi;
import com.investree.demo.model.Users;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.*;

@Service
@Transactional
public class TransaksiPaymentImple implements TransaksiService {
    @Autowired
    public TransaksiRepository transrepo;
    public UsersRepository userrepo;

    @Override
    public Map save(Transaksi transaksi, UUID idmeminjam, UUID idpeminjam) {
        Map map = new HashMap();
        try {
            Users userMeminjam = userrepo.getbyID(idmeminjam);
            transaksi.setMeminjam(userMeminjam);

            Users userPeminjam = userrepo.getbyID(idpeminjam);
            transaksi.setPeminjam(userPeminjam);

            Transaksi obj = transrepo.save(transaksi);

            map.put("data", obj);
            map.put("statusCode :", "200");
            map.put("statusMessage", "Sukses");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("StatusCode", "500");
            map.put("statusMessage", e);
            return  map;
        }
    }

    @Override
    public Map updateStatus(Transaksi transaksi, UUID id) {
        Map map = new HashMap();

        try {
            Transaksi trs = transrepo.getById(id);
            if(trs == null) {
                map.put("statusCode", "404");
                map.put("statusMessage","Data "+id+" Tidak ditemukan");
                return map;
            }
            trs.setStatus(transaksi.getStatus());
            transrepo.save(trs);

            map.put("data", trs);
            map.put("statusCode", "200");
            map.put("statusMessage","Update Sukses");
            return map;

        }catch (Exception e) {
            e.printStackTrace();
            map.put("StatusCode","500");
            map.put("StatusMessage", e);
            return map;
        }
    }

    @Override
    public Map getAll() {
        List<Transaksi> list = new ArrayList<Transaksi>();
        Map map = new HashMap();
        try {
            list = transrepo.getList();
            map.put("data",list);
            map.put("StatusCode",200);
            map.put("StatusMessage", "Get Sukses");
            return map;

        }catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;

        }
    }
}
