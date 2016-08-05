package com.mrv.intern.invoicematch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrv.intern.invoicematch.dao.InsertToMapperDAO;
import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;

@Service
public class InsertVoService {
@Autowired
InsertToMapperDAO insertToMapperDAO;
public void insertHdrVo(VendInvHdrVO invHdrVOs){
	insertToMapperDAO.insertHdrVo(invHdrVOs);
}
public void insertPoVo(final List<VendInvPoVO> invPoVOs){
	insertToMapperDAO.insertPoVo(invPoVOs);
}
public void insertPoItmVo(final List<VendInvPoLinItmVO> invPoLinItmVOs){
	insertToMapperDAO.insertPoItmVo(invPoLinItmVOs);
}
public void insertFrtItmPo(final List<VendInvFrtLinItmVO> invFrtLinItmVOs){
	insertToMapperDAO.insertFrtItmPo(invFrtLinItmVOs);
}
}
