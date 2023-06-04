package com.investree.demo.view;

import com.investree.demo.model.Transaksi;

import java.util.Map;
import java.util.UUID;

public interface TransaksiService {

    public Map getAll();
    public Map save(Transaksi transaksi, UUID idmeminjam, UUID idpeminjam);
    public Map updateStatus(Transaksi transaksi, UUID id);

}
