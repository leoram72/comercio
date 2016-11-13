package com.uan.comercio_jee;

import java.sql.SQLException;

import com.uan.comercio_jee.dao.impl.AreaDaoImpl;
import com.uan.comercio_jee.dto.Areas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        Areas area = new Areas();
        area.setArLlave("7dfe40e4-9376-42f7-ac0f-46a93d079c0b");
        area.setArCodigo("DES-07");
        area.setArDesc("Area Desarrollo");
        
        AreaDaoImpl areaimpl = new AreaDaoImpl();
        
        areaimpl.create(area);
        area.setArCodigo("DES-09");
        areaimpl.update(area);
        areaimpl.findById("7dfe40e4-9376-42f7-ac0f-46a93d079c0b");
        areaimpl.findAll();
    }
}
