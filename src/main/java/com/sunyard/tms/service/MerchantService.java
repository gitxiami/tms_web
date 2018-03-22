package com.sunyard.tms.service;

import com.sunyard.tms.entity.Merchant;
import com.sunyard.tms.utils.DataGrid;
import com.sunyard.tms.utils.IPage;

public interface MerchantService {
    int addMerchant(Merchant merchant);

    int updateMerchant(Merchant merchant);

    DataGrid<Merchant> showMerchantByPage(Merchant merchant, IPage page);

    Merchant findMerchantById(Merchant merchant);

    boolean checkTerminal(Merchant merchant);

    boolean checkMerchantId(Merchant merchant);
}
