package com.investree.demo.controller;

import com.investree.demo.model.Transaksi;
import com.investree.demo.repository.TransaksiRepository;
import com.investree.demo.repository.UsersRepository;
import com.investree.demo.view.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/Transaksi")
public class TransaksiController {
    @Autowired
    public TransaksiRepository trsrepo;

    @Autowired
    public UsersRepository usrrepo;

    @Autowired
    TransaksiService servis;


    @PostMapping("/save")
    public ResponseEntity<Map> save( @RequestBody Transaksi trsmodel) {
        System.out.println("Testing Masuk di awal");
        UUID idmeminjam =UUID.fromString("66fd9596-bfb3-4869-a81e-0cf1e384259d");
        UUID idPeminjam =UUID.fromString("0a817546-6ebf-40fc-ba2e-9f979f02a853");
        System.out.println("Berhasil Mmasuk controller");
        Map map = new HashMap();
        Map obj = servis.save(trsmodel,idmeminjam,idPeminjam);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @PutMapping("/save/{id}")
    public ResponseEntity<Map> updatestatus(@PathVariable(value = "id") UUID id, @RequestBody Transaksi trsmodel ) {
        System.out.println("Masuk ke PUT");
        Map map = new HashMap();
        Map obj = servis.updateStatus(trsmodel,id);
        return new ResponseEntity<Map>(obj,HttpStatus.OK);
    }

    @GetMapping("/listPage")
    @ResponseBody
    public ResponseEntity<Map> getList() {
        Map c = servis.getAll();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @GetMapping("/listByNama")
    public ResponseEntity<Page<Transaksi>> listByNama(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() Boolean status) {

        Pageable show_data = PageRequest.of(page,size);
        Page<Transaksi> list = trsrepo.findByStatus(status, show_data);
        return new ResponseEntity<Page<Transaksi>>(list,new HttpHeaders(), HttpStatus.OK);

    }


}
