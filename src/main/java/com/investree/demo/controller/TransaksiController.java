package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/barang")
public class TransaksiController {
    @Autowired
    public TransaksiRepository trsrepo;

    @Autowired
    public UsersRepository usrrepo;

    @Autowired
    TransaksiService servis;


    @PostMapping("/save/{idmeminjam}/{idpeminjam}")
    public ResponseEntity<Map> save(@PathVariable(value = "idmeminjam")UUID idmeminjam, @PathVariable(value = "idpeminjam")UUID idpeminjam, @RequestBody Transaksi trsmodel) {
        Map map = new HashMap();
        Map obj = servis.save(trsmodel,idmeminjam,idmeminjam);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<Map> updatestatus(@PathVariable(value = "id") UUID id, @RequestBody Transaksi trsmodel ) {
        Map map = servis.updateStatus(trsmodel,id);
        return new ResponseEntity<Map>(map,HttpStatus.OK);
    }

    @GetMapping("/listPage")
    @ResponseBody
    public ResponseEntity<Map> getList() {
        Map c = servis.getAll();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

}
