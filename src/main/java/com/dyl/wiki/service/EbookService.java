package com.dyl.wiki.service;

import com.dyl.wiki.domain.Ebook;
import com.dyl.wiki.domain.EbookExample;
import com.dyl.wiki.mapper.EbookMapper;
import com.dyl.wiki.req.EbookReq;
import com.dyl.wiki.resp.EbookResp;
import com.dyl.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

//        List<EbookResp> respList = new ArrayList<>();
//        for (Ebook ebook : ebookList){
////            EbookResp ebookResp = new EbookResp();
////            BeanUtils.copyProperties(ebook, ebookResp);
////            ebookResp.setId(123L);  # 测试修改是否生效
//            EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
//            respList.add(ebookResp);
//        }

        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        return list;
    }
}
