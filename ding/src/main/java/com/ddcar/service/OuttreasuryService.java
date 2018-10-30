package com.ddcar.service;

import com.ddcar.entity.TbInout;

import java.util.List;

/**
 * Created by Administrator on 2018-09-05.
 */
public interface OuttreasuryService {

    List<TbInout> findTbInoutListout(Integer page, Integer size);

}
