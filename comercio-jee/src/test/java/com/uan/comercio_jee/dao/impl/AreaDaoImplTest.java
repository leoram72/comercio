package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uan.comercio_jee.dto.Areas;

import junit.framework.TestCase;

public class AreaDaoImplTest extends TestCase  {
    
    public AreaDaoImplTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() throws ClassNotFoundException, SQLException {
        System.out.println("create");
        Areas area = new Areas();
        area.setArCodigo("DES-99");
        area.setArDesc("Area DE Desarrollo");
        AreaDaoImpl instance = new AreaDaoImpl();
        Areas expResult = area;
        Areas result = instance.create(area);
        assertEquals(expResult, result);
    }

    public void testUpdate() throws ClassNotFoundException, SQLException {
        System.out.println("update");
        Areas area = new Areas();
        area.setArLlave("7dfe40e4-9376-42f7-ac0f-46a93d079c0b");
        area.setArCodigo("DES-02");
        area.setArDesc("Area de Contabilidad");
        AreaDaoImpl instance = new AreaDaoImpl();
        Areas expResult = new Areas();
        expResult.setArLlave("7dfe40e4-9376-42f7-ac0f-46a93d079c0b");
        expResult.setArCodigo("DES-02");
        expResult.setArDesc("Area de Contabilidad");
        Areas result = instance.update(area);
        assertEquals(expResult, result);
    }

    public void testFindById() throws ClassNotFoundException, SQLException {
        System.out.println("findById");
        String arllave = "7dfe40e4-9376-42f7-ac0f-46a93d079c0b";
        AreaDaoImpl instance = new AreaDaoImpl();
        Areas expResult = new Areas();
        expResult.setArLlave("7dfe40e4-9376-42f7-ac0f-46a93d079c0b");
        expResult.setArCodigo("DES-02");
        expResult.setArDesc("Area de Contabilidad");
        Areas result = new Areas();
        result = instance.findById(arllave);
        
        assertEquals(expResult, result);
    }

    public void testFindAll() throws ClassNotFoundException, SQLException {
        System.out.println("findAll");
        AreaDaoImpl instance = new AreaDaoImpl();
        List<Areas> expResult = new ArrayList<Areas>();
        List<Areas> result = new ArrayList<Areas>();
        result = instance.findAll();
        expResult = result;
        assertEquals(expResult, result);
    }
    
    public void testDelete() throws ClassNotFoundException, SQLException {
        System.out.println("delete");
        Areas area = new Areas();
        area.setArLlave("41020c12-82f8-49aa-8b8d-9535f0b77fad");
        AreaDaoImpl instance = new AreaDaoImpl();
        instance.delete(area);
    }

}
