package com.uan.comercio_jee.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uan.comercio_jee.dto.Cargos;

import junit.framework.TestCase;

public class CargoDaoImplTest extends TestCase {
	Cargos cargo = new Cargos();
	List<Cargos> result = new ArrayList<Cargos>();
	
	public CargoDaoImplTest(String testName) {
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
        Cargos cargo = new Cargos();
        cargo.setCgCodigo("CAR-01");
        cargo.setCgDesc("Cargo Desarrollo");
        CargoDaoImpl instance = new CargoDaoImpl();
        Cargos expResult = cargo;
        Cargos result = instance.create(cargo);
        assertEquals(expResult, result);
    }

    public void testFindAll() throws ClassNotFoundException, SQLException {
        System.out.println("findAll");
        CargoDaoImpl instance = new CargoDaoImpl();
        List<Cargos> expResult = new ArrayList<Cargos>();
        
        result = instance.findAll();
        expResult = result;
        assertEquals(expResult, result);
    }
    
    public void testUpdate() throws ClassNotFoundException, SQLException {
        System.out.println("update");
        
        
        cargo.setCgLlave(result.get(0).getCgLlave());
        cargo.setCgCodigo("CAR-02");
        cargo.setCgDesc("Cargo de Contabilidad");
        CargoDaoImpl instance = new CargoDaoImpl();
        Cargos expResult = new Cargos();
        expResult.setCgLlave(result.get(0).getCgLlave());
        expResult.setCgCodigo("CAR-02");
        expResult.setCgDesc("Cargo de Contabilidad");
        Cargos result = instance.update(cargo);
        assertEquals(expResult, result);
    }

    public void testFindById() throws ClassNotFoundException, SQLException {
        System.out.println("findById");
        String arllave = result.get(0).getCgLlave();
        CargoDaoImpl instance = new CargoDaoImpl();
        Cargos expResult = new Cargos();
        expResult.setCgLlave(result.get(0).getCgLlave());
        expResult.setCgCodigo("CAR-02");
        expResult.setCgDesc("Cargo de Contabilidad");
        Cargos result = new Cargos();
        result = instance.findById(arllave);
        
        assertEquals(expResult, result);
    }
    
    public void testDelete() throws ClassNotFoundException, SQLException {
        System.out.println("delete");
        Cargos cargo = new Cargos();
        cargo.setCgLlave(result.get(0).getCgLlave());
        CargoDaoImpl instance = new CargoDaoImpl();
        instance.delete(cargo);
    }
}
