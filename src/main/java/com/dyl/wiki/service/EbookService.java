package com.dyl.wiki.service;

import com.dyl.wiki.domain.Ebook;
import com.dyl.wiki.domain.EbookExample;
import com.dyl.wiki.mapper.EbookMapper;
import com.dyl.wiki.req.EbookReq;
import com.dyl.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
//    @Autowired
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList){
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
//            ebookResp.setId(123L);  # 测试修改是否生效
            respList.add(ebookResp);
        }

        return respList;
    }
}
